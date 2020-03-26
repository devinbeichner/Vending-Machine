package com.techelevator;

import java.math.BigDecimal;

public class Chips extends Snacks{

	private String chipPrint = "Crunch Crunch, Yum!";
	
	public Chips(String button, String name, BigDecimal price) {
		super(button, name, price);
	}
	
	public String toString() {
		return chipPrint;
	}
	
}
