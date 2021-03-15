package com.ny.packer;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import com.ny.exception.APIException;

/**
 * @author N.Yesilkaya
 *
 */
public class PackerIntegrationTest {

	@Test
	public void testPack() throws APIException {
		String absoluteFilePath = "src/test/resources/example_input";

		String result = Packer.pack(absoluteFilePath);
		assertEquals(result, "4\n-\n2,7\n8,9");
	}

	@Test(expectedExceptions = { APIException.class }, expectedExceptionsMessageRegExp = "Could not read file.*")
	public void testPackExceptionIsThrown() throws APIException {
		String absoluteFilePath = "src/test/resources/not_existing_file";
		Packer.pack(absoluteFilePath);
	}

}
