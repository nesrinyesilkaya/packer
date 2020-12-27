package com.mobiquity.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author N.Yesilkaya
 *
 */
public class PackageInfo {

	private int weightLimit;
	private List<Item> items;
	private List<Item> selectedItems;


	public PackageInfo(int weightLimit, List<Item> items) {
		this.weightLimit = weightLimit;
		this.items = items;
		this.selectedItems = new ArrayList<>();
	}

	public int getWeightLimit() {
		return weightLimit;
	}

	public List<Item> getItems() {
		return items;
	}

	public List<Item> getSelectedItems() {
		return selectedItems;
	}

	public void setSelectedItems(List<Item> selectedItems) {
		this.selectedItems = selectedItems;
	}

}
