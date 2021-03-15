package com.ny.formatter;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ny.enums.PackageResultFormatterTypes;
import com.ny.exception.APIException;

/**
 * @author N.Yesilkaya
 *
 */
public class PackageResultFormatterFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(PackageResultFormatterFactory.class);

	private PackageResultFormatterFactory() {
	}

	@SuppressWarnings("rawtypes")
	private static Map<PackageResultFormatterTypes, IPackageResultFormatter> factoryMap = new HashMap<>();

	static {
		factoryMap.put(PackageResultFormatterTypes.AS_STRING, new PackageResultStringFormatter());
	}

	/**
	 * returns a concrete formatter class according to resultFormatterType 
	 * @param resultFormatterType
	 * @return a concrete formatter class according to resultFormatterType 
	 * @throws APIException
	 */
	public static IPackageResultFormatter<?> getFormatter(PackageResultFormatterTypes resultFormatterType) throws APIException {

		IPackageResultFormatter<?> formatter = factoryMap.get(resultFormatterType);
		if (formatter == null) {
			String message = String.format("Result formatter not found. resultFormatterType : %s", resultFormatterType);
			LOGGER.error(message);
			throw new APIException(message);
		}
		return formatter;
	}

}