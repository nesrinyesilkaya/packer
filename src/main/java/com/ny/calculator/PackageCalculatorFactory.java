package com.ny.calculator;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ny.enums.PackageCalculatorTypes;
import com.ny.exception.APIException;
/**
 * @author N.Yesilkaya
 *
 */
public class PackageCalculatorFactory {
	private static final Logger LOGGER = LoggerFactory.getLogger(PackageCalculatorFactory.class);

	private PackageCalculatorFactory() {

	}

	private static Map<PackageCalculatorTypes, IPackageCalculator> factoryMap = new HashMap<>();

	static {
		factoryMap.put(PackageCalculatorTypes.DYNAMIC_CALCULATOR, new DynamicPackageCalculator());
	}

	/**
	 * returns a concrete calculator class according to calculatorType 
	 * @param calculatorType
	 * @return a concrete calculator class according to calculatorType
	 * @throws APIException
	 */
	public static IPackageCalculator getCalculator(PackageCalculatorTypes calculatorType) throws APIException {

		IPackageCalculator calculator = factoryMap.get(calculatorType);
		if (calculator == null) {
			String message = String.format("Package calculator not found. calculatorType : %s", calculatorType);
			LOGGER.error(message);
			throw new APIException(message);
		}
		return calculator;
	}

}