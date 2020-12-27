package com.mobiquity.exception;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

/**
 * @author N.Yesilkaya
 *
 */
public class APIExceptionTest {

	@Test
	public void testApiExceptionWithMessage() {
		APIException exception = new APIException("Fancy Message1");
		assertEquals(exception.getMessage(), "Fancy Message1");
	}
	
	@Test
	public void testApiExceptionWithMessageAndException() {
		APIException exception = new APIException("Fancy Message2", new Exception("Fancy Exception"));
		assertEquals(exception.getMessage(), "Fancy Message2");
	}
}
