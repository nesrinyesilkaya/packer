package com.ny.parser;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.ny.enums.FileParserTypes;
import com.ny.exception.APIException;

/**
 * @author N.Yesilkaya
 *
 */
public class FileParserFactoryTest {

	@Test
	public void testGetFileParser() throws APIException {
		IFileParser<?> parser = FileParserFactory.getFileParser(FileParserTypes.PACKAGE_INFO_PARSER);
		assertTrue(parser instanceof PackageInfoFileParser);
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "File parser not found.*")
	public void testGetFileParserNoFormatterExceptionIsThrown() throws APIException {
		FileParserFactory.getFileParser(null);
	}
}
