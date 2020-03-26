package com.techelevator;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class CandyTest {
	
	Candy candy;
	
	@Before
	public void make_new_candy() {
		candy = new Candy("A4", "Moonpie", new BigDecimal("1.80"));
	}

	@Test
	public void get_candy_print_test() {
		String result = candy.toString();
		
		Assert.assertEquals("Munch Munch, Yum!", result);
	}
	
}
