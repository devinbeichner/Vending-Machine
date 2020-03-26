package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeverageTest {

	Beverages beverage;

	@Before
	public void setup() {
		beverage = new Beverages("C1", "Cola", new BigDecimal(1.25));
	}

	@Test
	public void get_beverage_print_test() {
		String getBeveragePrintTest = beverage.toString();
		Assert.assertEquals("Glug Glug, Yum!", getBeveragePrintTest);
	}
}
