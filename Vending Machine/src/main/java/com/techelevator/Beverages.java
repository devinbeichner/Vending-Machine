package com.techelevator;

import java.math.BigDecimal;

public class Beverages extends Snacks {

	private String beveragePrint = "Glug Glug, Yum!";

	public Beverages(String button, String name, BigDecimal price) {
		super(button, name, price);
	}

	public String toString() {
		return beveragePrint;
	}

}
