package com.techelevator;

import java.math.BigDecimal;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SnacksTest {
	
	Snacks snack;
	
	@Before
	public void setup() {
		snack = new Snacks("A1", "Potato Crisps", new BigDecimal(3.05) );
	}
	
	@Test
	public void get_name_returns_name() {
	String returnsName = snack.getName();
	Assert.assertEquals("Potato Crisps", returnsName);
	}
	
	@Test
	public void get_price_returns_price() {
	BigDecimal returnsPrice = snack.getPrice();
	Assert.assertEquals(new BigDecimal(3.05), returnsPrice);
	}
	
	@Test
	public void get_stock_returns_stock() {
	int returnsStock = snack.getStock();
	Assert.assertEquals(5, returnsStock);
	}
	
	@Test
	public void get_button_returns_button() {
	String returnsButton = snack.getButton();
	Assert.assertEquals("A1", returnsButton);
	}
	
	@Test
	public void dispense_reduceds_stock_by_one() {
		snack.dispense();
		int actual = snack.getStock();
		Assert.assertEquals(4, actual);
	}
	
}
