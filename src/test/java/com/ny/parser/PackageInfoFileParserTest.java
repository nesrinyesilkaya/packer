package com.ny.parser;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ny.exception.APIException;
import com.ny.model.PackageInfo;

/**
 * @author N.Yesilkaya
 *
 */
public class PackageInfoFileParserTest {

	@InjectMocks
	private PackageInfoFileParser packageInfoFileParser;
	
	@BeforeTest
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testParseFile() throws APIException {
		String absoluteFilePath = "src/test/resources/example_input";
		List<PackageInfo> actualPackageInfoList = packageInfoFileParser.parseFile(absoluteFilePath);

		assertEquals(actualPackageInfoList.size(), 4);

		assertEquals(actualPackageInfoList.get(0).getWeightLimit(), 81);
		assertEquals(actualPackageInfoList.get(0).getItems().size(), 6);
		assertEquals(actualPackageInfoList.get(0).getItems().get(0).getWeight(), new Double(53.38));

		assertEquals(actualPackageInfoList.get(1).getWeightLimit(), 8);
		assertEquals(actualPackageInfoList.get(1).getItems().size(), 1);
		assertEquals(actualPackageInfoList.get(1).getItems().get(0).getWeight(), new Double(15.30));

		assertEquals(actualPackageInfoList.get(2).getWeightLimit(), 75);
		assertEquals(actualPackageInfoList.get(2).getItems().size(), 9);
		assertEquals(actualPackageInfoList.get(2).getItems().get(0).getWeight(), new Double(85.31));

		assertEquals(actualPackageInfoList.get(3).getWeightLimit(), 56);
		assertEquals(actualPackageInfoList.get(3).getItems().size(), 9);
		assertEquals(actualPackageInfoList.get(3).getItems().get(0).getWeight(), new Double(90.72));
	}
	
	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Wrong line format.*")
	public void testLinePartCountExceptionIsThrown() throws APIException {
		String absoluteFilePath = "src/test/resources/example_input_line_part_count_not_match";
		packageInfoFileParser.parseFile(absoluteFilePath);
	}
	
	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Wrong item format.*")
	public void testItemPartCountExceptionIsThrown() throws APIException {
		String absoluteFilePath = "src/test/resources/example_input_item_part_count_not_match";
		packageInfoFileParser.parseFile(absoluteFilePath);
	}
	
	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Item allowed cost exceeded.*")
	public void testParseFileMaxCostExceptionIsThrown() throws APIException {
		String absoluteFilePath = "src/test/resources/example_input_max_cost_exceed";
		packageInfoFileParser.parseFile(absoluteFilePath);
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Package allowed item count exceeded.*")
	public void testParseFileMaxItemCountExceptionIsThrown() throws APIException {
		String absoluteFilePath = "src/test/resources/example_input_max_item_count_exceed";
		packageInfoFileParser.parseFile(absoluteFilePath);
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Item allowed weight exceeded.*")
	public void testParseFileMaxWeightExceptionIsThrown() throws APIException {
		String absoluteFilePath = "src/test/resources/example_input_max_weight_exceed";
		packageInfoFileParser.parseFile(absoluteFilePath);
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Package allowed weight limit exceeded.*")
	public void testParseFileMaxWeightLimitExceptionIsThrown() throws APIException {
		String absoluteFilePath = "src/test/resources/example_input_max_weight_limit_exceed";
		packageInfoFileParser.parseFile(absoluteFilePath);
	}
}
