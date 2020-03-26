package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GumTest {

	Gum gum;
	
	@Before
	public void make_new_gum() {
		gum = new Gum("D1", "U-Chews", new BigDecimal(0.85));
	}
	
	@Test
	public void test_get_gum_print() {
		String actual = gum.toString();
		Assert.assertEquals("Chew Chew, Yum!", actual);
	}
}
