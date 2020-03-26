package com.techelevator;

import java.math.BigDecimal;

public class Gum extends Snacks{
	
	private String gumPrint = "Chew Chew, Yum!";
	
	public Gum (String button, String name, BigDecimal price) {
		super(button, name, price);
	}
	
	public String toString() {
		return gumPrint;
	}
}
