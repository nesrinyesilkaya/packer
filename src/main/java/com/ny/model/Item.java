package com.ny.model;

import java.math.BigDecimal;

/**
 * @author N.Yesilkaya
 *
 */
public class Item {

	private int index;
	private Double weight;
	private BigDecimal cost;

	public Item(int index, Double weight, BigDecimal cost) {
		this.index = index;
		this.weight = weight;
		this.cost = cost;
	}

	public int getIndex() {
		return index;
	}

	public Double getWeight() {
		return weight;
	}

	public BigDecimal getCost() {
		return cost;
	}

	@Override
	public String toString() {
		return "Item [index=" + index + ", weight=" + weight + ", cost=" + cost + "]";
	}

}
