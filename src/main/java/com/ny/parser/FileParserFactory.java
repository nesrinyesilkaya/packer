package com.ny.parser;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ny.enums.FileParserTypes;
import com.ny.exception.APIException;

/**
 * @author N.Yesilkaya
 *
 */
public class FileParserFactory {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileParserFactory.class);

	private FileParserFactory() {
	}

	@SuppressWarnings("rawtypes")
	private static Map<FileParserTypes, IFileParser> factoryMap = new HashMap<>();

	static {
		factoryMap.put(FileParserTypes.PACKAGE_INFO_PARSER, new PackageInfoFileParser());
	}

	/**
	 * returns a concrete file parser class according to parserType 
	 * @param parserType
	 * @return a concrete file parser class according to parserType 
	 * @throws APIException
	 */
	public static IFileParser<?> getFileParser(FileParserTypes parserType) throws APIException {

		IFileParser<?> parser = factoryMap.get(parserType);
		if (parser == null) {
			String message = String.format("File parser not found. parserType : %s", parserType);
			LOGGER.error(message);
			throw new APIException(message);
		}
		return parser;
	}

}