package com.ny.packer;

import java.util.List;

import com.ny.enums.FileParserTypes;
import com.ny.enums.PackageCalculatorTypes;
import com.ny.enums.PackageResultFormatterTypes;
import com.ny.calculator.IPackageCalculator;
import com.ny.calculator.PackageCalculatorFactory;
import com.ny.exception.APIException;
import com.ny.formatter.IPackageResultFormatter;
import com.ny.formatter.PackageResultFormatterFactory;
import com.ny.model.PackageInfo;
import com.ny.parser.FileParserFactory;
import com.ny.parser.IFileParser;

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
