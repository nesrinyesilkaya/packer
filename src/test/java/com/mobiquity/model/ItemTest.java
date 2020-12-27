package com.mobiquity.model;

import java.math.BigDecimal;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author N.Yesilkaya
 *
 */
public class ItemTest {

	@Mock
	private Item item;

	@BeforeTest
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		item = new Item(1, 81.0, new BigDecimal(92));
	}

	@Test
	public void testGetIndex() {
		Assert.assertTrue(item.getIndex() == 1);
	}

	@Test
	public void testGetWeight() {
		Assert.assertTrue(item.getWeight() == 81.0);
	}

	@Test
	public void testGetCost() {
		Assert.assertTrue(item.getCost().compareTo(new BigDecimal(92)) == 0);
	}

	@Test
	public void testToString() {
		Assert.assertTrue(item.toString().equals("Item [index=1, weight=81.0, cost=92]"));
	}

}
