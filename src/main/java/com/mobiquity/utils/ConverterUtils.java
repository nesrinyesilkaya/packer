package com.mobiquity.utils;

import java.math.BigDecimal;

import com.mobiquity.exception.APIException;

/**
 * @author N.Yesilkaya
 *
 */
public class ConverterUtils {

	private ConverterUtils() {
	}

	/**
	 * Converts string value to Integer
	 * @param value
	 * @return Integer value of given string value
	 * @throws APIException
	 */
	public static int convert2Int(String value) throws APIException {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new APIException(String.format("Could not convert string value to int. The value: %s", value), e);
		}

	}

	/**
	 * Converts string value to Double
	 * @param value
	 * @return Double value of given string value
	 * @throws APIException
	 */
	public static Double convert2Double(String value) throws APIException {
		try {
			return Double.parseDouble(value);
		} catch (NumberFormatException e) {
			throw new APIException(String.format("Could not convert string value to Double. The value: %s", value), e);
		}
	}

	/**
	 * Converts string value to BigDecimal
	 * @param value
	 * @return BigDecimal value of given string value
	 * @throws APIException
	 */
	public static BigDecimal convert2BigDecimal(String value) throws APIException {
		try {
			return new BigDecimal(value);
		} catch (NumberFormatException e) {
			throw new APIException(String.format("Could not convert string value to BigDecimal. The value: %s", value), e);
		}
	}

}
