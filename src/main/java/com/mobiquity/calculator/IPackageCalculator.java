package com.mobiquity.calculator;

import com.mobiquity.model.PackageInfo;

/**
 * @author N.Yesilkaya
 *
 */
public interface IPackageCalculator {

	/**
	 * calculates which items to be selected and append them to packageInfo.selectedItems field 
	 * @param packageInfo
	 */
	void calculate(PackageInfo packageInfo);

}
