package com.mobiquity.formatter;

import java.util.List;

import com.mobiquity.model.PackageInfo;

/**
 * @author N.Yesilkaya
 *
 */
public interface IPackageResultFormatter <T> {
	
	/**
	 * returns results in the desired format
	 * @param packageList
	 * @return results in the desired format
	 */
	T getResult(List<PackageInfo> packageList);

}
