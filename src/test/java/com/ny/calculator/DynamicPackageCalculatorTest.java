package com.ny.calculator;

import static org.testng.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.ny.model.Item;
import com.ny.model.PackageInfo;

/**
 * @author N.Yesilkaya
 *
 */
public class DynamicPackageCalculatorTest {
	
	@InjectMocks
	private DynamicPackageCalculator dynamicPackageCalculator;

	@BeforeTest
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCalculate() {
		List<Item> items = Arrays.asList(new Item(1, 15.0, new BigDecimal(34)));
		PackageInfo packageInfo = new PackageInfo(81, items);
		dynamicPackageCalculator.calculate(packageInfo);
		assertEquals(packageInfo.getSelectedItems().size(), 1);
		assertEquals(packageInfo.getSelectedItems().get(0).getIndex(), 1);
		assertEquals(packageInfo.getSelectedItems().get(0).getWeight(), new Double(15.0));
		assertEquals(packageInfo.getSelectedItems().get(0).getCost(), new BigDecimal(34));
	}

}
