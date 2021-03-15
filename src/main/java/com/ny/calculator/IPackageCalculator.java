package com.ny.calculator;

import com.ny.model.PackageInfo;

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
