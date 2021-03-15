package com.ny.calculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.ny.model.Item;
import com.ny.model.PackageInfo;


/**
 * Implements all the functions of IPackageCalculator interface. 
 * Implementation of a dynamic programming based solution for 0-1 Knapsack problem 
 * 
 * @author N.Yesilkaya
 *
 */
public class DynamicPackageCalculator implements IPackageCalculator {

	@Override
	public void calculate(PackageInfo packageInfo) {
		
		List<Item> items = packageInfo.getItems();
		int itemCount = packageInfo.getItems().size();
		int weightLimit = packageInfo.getWeightLimit();

		items.sort(Comparator.comparing(Item::getWeight));

		BigDecimal[][] matrix = new BigDecimal[itemCount + 1][weightLimit + 1];

		for (int i = 0; i <= weightLimit; i++) {
			matrix[0][i] = BigDecimal.ZERO;
		}

		for (int i = 1; i <= itemCount; i++) {
			for (int j = 0; j <= weightLimit; j++) {
				if (items.get(i - 1).getWeight() > j) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					BigDecimal newValue = matrix[i - 1][j - items.get(i - 1).getWeight().intValue()].add(items.get(i - 1).getCost());
					matrix[i][j] = matrix[i - 1][j].max(newValue);
				}
			}
		}

		BigDecimal res = matrix[itemCount][weightLimit];
		int w = weightLimit;
		List<Item> selectedItems = new ArrayList<>();

		for (int i = itemCount; i > 0 && res.compareTo(BigDecimal.ZERO) > 0; i--) {
			if (res.compareTo(matrix[i - 1][w]) != 0) {
				selectedItems.add(items.get(i - 1));
				res = res.subtract(items.get(i - 1).getCost());
				w -= items.get(i - 1).getWeight().intValue();
			}
		}

		selectedItems.sort(Comparator.comparing(Item::getIndex));
		packageInfo.setSelectedItems(selectedItems);
	}
}
