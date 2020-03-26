package com.techelevator;

import java.math.BigDecimal;

public class Snacks {
	
	private String name;
	private BigDecimal price;
	private int stock = 5;
	private String button;
	
	public Snacks(String button, String name, BigDecimal price) {
		this.button = button;
		this.name = name;
		this.price = price;
		
	}
	
	public void dispense() {
		stock -= 1;
	}

	public String getName() {
		return name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getStock() {
		return stock;
	}

	public String getButton() {
		return button;
	}
	
}