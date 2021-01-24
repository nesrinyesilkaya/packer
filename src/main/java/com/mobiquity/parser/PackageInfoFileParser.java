package com.mobiquity.parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mobiquity.constant.ItemConstants;
import com.mobiquity.constant.PackageConstants;
import com.mobiquity.exception.APIException;
import com.mobiquity.model.Item;
import com.mobiquity.model.PackageInfo;
import com.mobiquity.utils.ConverterUtils;

/**
 * Implements all the functions of IFileParser interface. Reads the file in
 * given path. Parse the content and fit each line to the PackageInfo object
 * 
 * @author N.Yesilkaya
 *
 */
public class PackageInfoFileParser implements IFileParser<PackageInfo> {

	private static final Logger LOGGER = LoggerFactory.getLogger(PackageInfoFileParser.class);

	@Override
	public List<PackageInfo> parseFile(String filePath) throws APIException {

		List<PackageInfo> packageInfoList = new ArrayList<>();

		List<String> lines = getFileLines(filePath);

		for (String line : lines) {
			int lineNumber = lines.indexOf(line) + 1;
			LOGGER.debug(line);
			line = line.replace(" ", "").replace("\u20ac", "").replace("(", "");
			String[] lineParts = line.split(":");
			checkLinePart(line, lineParts.length);

			int weightLimit = ConverterUtils.convert2Int(lineParts[0]);

			checkPackageWeightLimit(lineNumber, weightLimit);

			List<Item> items = getPackageItems(lineNumber, lineParts[1]);

			PackageInfo newPackageInfo = new PackageInfo(weightLimit, items);
			packageInfoList.add(newPackageInfo);
		}

		return packageInfoList;

	}

	private List<String> getFileLines(String filePath) throws APIException {
		Path path = Paths.get(filePath);
		try(BufferedReader reader = Files.newBufferedReader(path)){
			Stream<String> streamLines = reader.lines();
			return streamLines.collect(Collectors.toList());
		} catch (IOException e) {
			throw new APIException(String.format("Could not read file. Error message : %s", e.getMessage()), e);
		} 
	}

	private List<Item> getPackageItems(int lineNumber, String lineItemsPart) throws APIException {
		String[] allItems = lineItemsPart.split("\\)");

		checkPackageMaxItemCount(lineNumber, allItems.length);

		List<Item> items = new ArrayList<>();
		for (String item : allItems) {

			String[] itemParts = item.split(",");

			checkItemPart(item, itemParts.length);

			int index = ConverterUtils.convert2Int(itemParts[0]);
			Double weight = ConverterUtils.convert2Double(itemParts[1]);
			BigDecimal cost = ConverterUtils.convert2BigDecimal(itemParts[2]);

			checkItemWeight(lineNumber, weight);

			checkItemCost(lineNumber, cost);

			Item newItem = new Item(index, (Double) (weight), cost);

			items.add(newItem);
		}
		return items;

	}

	private void checkLinePart(String line, int linePartsCount) throws APIException {
		if (linePartsCount != 2) {
			throw new APIException(String.format("Wrong line format. Line : %s", line));
		}
	}

	private void checkItemPart(String item, int itemPartsCount) throws APIException {
		if (itemPartsCount != 3) {
			throw new APIException(String.format("Wrong item format. Line : %s", item));
		}
	}

	private void checkPackageMaxItemCount(int lineNumber, int itemCount) throws APIException {
		if (itemCount > PackageConstants.MAX_ITEM_COUNT) {
			throw new APIException(String.format("Package allowed item count exceeded. Line Number: %s Item Count : %s", lineNumber, itemCount));
		}
	}

	private void checkPackageWeightLimit(int lineNumber, int capacity) throws APIException {
		if (capacity > PackageConstants.MAX_WEIGHT_LIMIT) {
			throw new APIException(String.format("Package allowed weight limit exceeded. Line Number: %s Weight Limit : %s", lineNumber, capacity));
		}
	}

	private void checkItemCost(int lineNumber, BigDecimal itemCost) throws APIException {
		if (itemCost.compareTo(new BigDecimal(ItemConstants.MAX_COST)) > 0) {
			throw new APIException(String.format("Item allowed cost exceeded. Line Number: %s cost : %s", lineNumber, itemCost));
		}
	}

	private void checkItemWeight(int lineNumber, Double itemWeight) throws APIException {
		if (itemWeight > ItemConstants.MAX_WEIGHT) {
			throw new APIException(String.format("Item allowed weight exceeded. Line Number: %s weight : %s", lineNumber, itemWeight));
		}
	}

}