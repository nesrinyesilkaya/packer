package com.mobiquity.formatter;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.mobiquity.model.Item;
import com.mobiquity.model.PackageInfo;

/**
 * @author N.Yesilkaya
 *
 */
public class PackageResultStringFormatterTest {

	@InjectMocks
	PackageResultStringFormatter packageResultStringFormatter;

	@BeforeTest
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetResultWithEmptyInputList() {
		assertEquals(packageResultStringFormatter.getResult(new ArrayList<>()), "");
	}

	@Test
	public void testGetResultSingleLineNoSolution() {
		List<Item> items = Arrays.asList(new Item(1, 15.0, new BigDecimal(34)));
		List<PackageInfo> packageList = Arrays.asList(new PackageInfo(81, items));
		assertEquals(packageResultStringFormatter.getResult(packageList), "-");
	}

	@Test
	public void testGetResultSingleLineSingleSolution() {
		List<Item> items = Arrays.asList(new Item(1, 15.0, new BigDecimal(34)));
		PackageInfo packageInfo = new PackageInfo(81, items);
		packageInfo.setSelectedItems(Arrays.asList(new Item(1, 15.0, new BigDecimal(34))));
		List<PackageInfo> packageList = Arrays.asList(packageInfo);

		assertEquals(packageResultStringFormatter.getResult(packageList), "1");
	}

	@Test
	public void testGetResultMultiLineMultiSolution() {
		List<Item> items = Arrays.asList(new Item(1, 15.0, new BigDecimal(34)));
		PackageInfo packageInfo1 = new PackageInfo(81, items);
		packageInfo1.setSelectedItems(Arrays.asList(new Item(1, 15.0, new BigDecimal(34)), new Item(2, 15.0, new BigDecimal(34))));
		PackageInfo packageInfo2 = new PackageInfo(81, items);
		packageInfo2.setSelectedItems(Arrays.asList(new Item(1, 15.0, new BigDecimal(34))));
		List<PackageInfo> packageList = Arrays.asList(packageInfo1, packageInfo2);

		assertEquals(packageResultStringFormatter.getResult(packageList), "1,2\n1");
	}

}
