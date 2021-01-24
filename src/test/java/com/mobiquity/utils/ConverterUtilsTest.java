package com.mobiquity.utils;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.math.BigDecimal;

import org.testng.annotations.Test;

import com.mobiquity.exception.APIException;

public class ConverterUtilsTest {
	
	@Test
	public void testConvert2Int() throws APIException {
		assertEquals(ConverterUtils.convert2Int("2"), 2);
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Could not convert string value to int.*")
	public void testConvert2IntExceptionIsThrown() throws APIException {
		ConverterUtils.convert2Int("A");
	}

	@Test
	public void testConvert2Double() throws APIException {
		assertEquals(ConverterUtils.convert2Double("2.0"), new Double(2.0));
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Could not convert string value to Double.*")
	public void testConvert2DoubleExceptionIsThrown() throws APIException {
		ConverterUtils.convert2Double("A");
	}

	@Test
	public void testConvert2BigDecimal() throws APIException {
		assertTrue(ConverterUtils.convert2BigDecimal("2").compareTo(new BigDecimal("2")) == 0);
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Could not convert string value to BigDecimal.*")
	public void testConvert2BigDecimalExceptionIsThrown() throws APIException {
		ConverterUtils.convert2BigDecimal("A");
	}

}
