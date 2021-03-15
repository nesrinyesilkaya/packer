package com.ny.parser;

import java.util.List;

import com.ny.exception.APIException;

/**
 * @author N.Yesilkaya
 *
 */
public interface IFileParser<T> {

	/**
	 * reads the file in given path, parses and convert content into a desired list of object
	 * @param filePath
	 * @return a list of desired object
	 * @throws APIException
	 */
	List<T> parseFile(String filePath) throws APIException;

}