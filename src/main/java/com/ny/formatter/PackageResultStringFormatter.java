package com.ny.formatter;

import java.util.List;
import java.util.stream.Collectors;

import com.ny.model.Item;
import com.ny.model.PackageInfo;

/**
 * 
 * Implements all the functions of IPackageResultFormatter interface.
 * Format the results as string
 * @author N.Yesilkaya
 *
 */
public class PackageResultStringFormatter implements IPackageResultFormatter<String> {

	@Override
	public String getResult(List<PackageInfo> packageList) {
		StringBuilder builder = new StringBuilder();
	
		String prefix = "";
		for (PackageInfo pack : packageList) {
			List<Item> selectedItems = pack.getSelectedItems();
			if (!selectedItems.isEmpty()) {
				builder.append(prefix);				
				builder.append(selectedItems.stream().map(e -> String.valueOf(e.getIndex())).collect(Collectors.joining(",")));
			} else {
				builder.append(prefix);	
				builder.append("-");
			}
			prefix = "\n";
		}		
		return builder.toString();
	}

}
