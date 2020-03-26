package com.techelevator;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	VendingMachine vendingMachine;
	
	@Before
	public void create_vending_machine() {
		vendingMachine = new VendingMachine();
	}
	
	
	@Test
	public void make_sure_restock_fills_productNames_list() {
		
		List<Snacks> productNames = new ArrayList<>();
		
		productNames.add(new Chips("A1", "Potato Crisps", new BigDecimal("3.05")));
		productNames.add(new Chips("A2", "Stackers", new BigDecimal("1.45")));
		productNames.add(new Chips("A3", "Grain Waves", new BigDecimal("2.75")));
		productNames.add(new Chips("A4", "Cloud Popcorn", new BigDecimal("3.65")));
		productNames.add(new Candy("B1", "Moonpie", new BigDecimal("1.80")));
		productNames.add(new Candy("B2", "Cowtales", new BigDecimal("1.50")));
		productNames.add(new Candy("B3", "Wonka Bar", new BigDecimal("1.50")));
		productNames.add(new Candy("B4", "Crunchie", new BigDecimal("1.75")));
		productNames.add(new Beverages("C1", "Cola", new BigDecimal("1.25")));
		productNames.add(new Beverages("C2", "Dr. Salt", new BigDecimal("1.50")));
		productNames.add(new Beverages("C3", "Mountain Melter", new BigDecimal("1.50")));
		productNames.add(new Beverages("C4", "Heavy", new BigDecimal("1.50")));
		productNames.add(new Gum("D1", "U-Chews", new BigDecimal("0.85")));
		productNames.add(new Gum("D2", "Little League Chew", new BigDecimal("0.95")));
		productNames.add(new Gum("D3", "Chiclets", new BigDecimal("0.75")));
		productNames.add(new Gum("D4", "Triplemint", new BigDecimal("0.75")));
		
		vendingMachine.restock();
		
		for (int i = 0; i < productNames.size(); i++) {
			Assert.assertEquals(productNames.get(i).getButton(), vendingMachine.getProductList().get(i).getButton());
			Assert.assertEquals(productNames.get(i).getName(), vendingMachine.getProductList().get(i).getName());
			Assert.assertEquals(productNames.get(i).getStock(), vendingMachine.getProductList().get(i).getStock());
			Assert.assertEquals(productNames.get(i).getPrice(), vendingMachine.getProductList().get(i).getPrice());
		}
	}
	
	@Test
	public void feed_money_test_and_get_balance() {
		vendingMachine.feedMoney(new BigDecimal(200.00));
		BigDecimal result = vendingMachine.getCurrentBalance();
		
		Assert.assertEquals(new BigDecimal(200.00), result);
		
	}

}
