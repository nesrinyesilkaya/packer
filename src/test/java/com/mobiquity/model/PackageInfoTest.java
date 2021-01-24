package com.mobiquity.model;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author N.Yesilkaya
 *
 */
public class PackageInfoTest {

	@Mock
	private PackageInfo packageInfo;

	@BeforeTest
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		List<Item> items = Arrays.asList(new Item(1, 15.0, new BigDecimal(34)));
		packageInfo = new PackageInfo(8, items);
	}

	@Test
	public void testGetWeightLimit() {
		Assert.assertEquals(packageInfo.getWeightLimit(),8);
	}

	@Test
	public void testGetItems() {
		Assert.assertEquals(packageInfo.getItems().size(), 1);
	}

	@Test
	public void testGetSelectedItems() {
		Assert.assertTrue(packageInfo.getSelectedItems().isEmpty());
	}

	@Test
	public void testSetSelectedItems() {
		List<Item> selectedItems = Arrays.asList(new Item(1, 15.0, new BigDecimal(34)));
		packageInfo.setSelectedItems(selectedItems);
		Assert.assertTrue(!packageInfo.getSelectedItems().isEmpty());
	}

}
