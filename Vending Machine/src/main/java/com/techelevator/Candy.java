package com.techelevator;

import java.math.BigDecimal;

public class Candy extends Snacks {

	
	private String candyPrint = "Munch Munch, Yum!";
	
	public Candy (String button, String name, BigDecimal price) {
			super(button, name, price);
	}
	
	public String toString() {
		return candyPrint;
	}

}
