package com.mobiquity.packer;

import java.util.List;

import com.mobiquity.calculator.IPackageCalculator;
import com.mobiquity.calculator.PackageCalculatorFactory;
import com.mobiquity.enums.FileParserTypes;
import com.mobiquity.enums.PackageCalculatorTypes;
import com.mobiquity.enums.PackageResultFormatterTypes;
import com.mobiquity.exception.APIException;
import com.mobiquity.formatter.IPackageResultFormatter;
import com.mobiquity.formatter.PackageResultFormatterFactory;
import com.mobiquity.model.PackageInfo;
import com.mobiquity.parser.FileParserFactory;
import com.mobiquity.parser.IFileParser;

/**
 * @author N.Yesilkaya
 *
 */
public class Packer {

	private Packer() {
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static String pack(String filePath) throws APIException {

		IFileParser fileParser = FileParserFactory.getFileParser(FileParserTypes.PACKAGE_INFO_PARSER);

		List<PackageInfo> packageInfoList = fileParser.parseFile(filePath);

		IPackageCalculator packageCalculator = PackageCalculatorFactory.getCalculator(PackageCalculatorTypes.DYNAMIC_CALCULATOR);

		for (PackageInfo packageInfo : packageInfoList) {
			packageCalculator.calculate(packageInfo);
		}

		IPackageResultFormatter formatter = PackageResultFormatterFactory.getFormatter(PackageResultFormatterTypes.AS_STRING);

		return (String) formatter.getResult(packageInfoList);
	}
}
