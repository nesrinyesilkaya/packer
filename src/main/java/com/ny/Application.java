package com.ny;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ny.exception.APIException;
import com.ny.packer.Packer;

/**
 * @author N.Yesilkaya
 *
 */
public class Application {
	private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) throws APIException {
		if (args.length <= 0) {
			throw new APIException("Please enter a file path!");
		}
		
		String result = Packer.pack(args[0]);
		LOGGER.info("Result:\n{}", result);
	}
}
