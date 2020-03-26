package com.techelevator;

import java.math.BigDecimal;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ChipsTest {

	Chips chip;

	@Before
	public void setup() {
		chip = new Chips("A1", "Potato Crisps", new BigDecimal(3.05));
	}

	@Test
	public void get_chip_print_test() {
		String getChipPrintTest = chip.toString();
		Assert.assertEquals("Crunch Crunch, Yum!", getChipPrintTest);
	}

}
