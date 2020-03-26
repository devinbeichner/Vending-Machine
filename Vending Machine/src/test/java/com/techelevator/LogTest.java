package com.techelevator;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LogTest {
	
	Log log;
	
	@Before
	public void make_new_log() {
		log = new Log();
	}
	
	@Test
	public void money_feed_returns_string_returns_correctly() {
		log.moneyFeedLog(new BigDecimal("5.00"), new BigDecimal("5.00"));
		
		String actual = log.getStringToLog();
		
		LocalDateTime testDateTime = LocalDateTime.now();
		DateTimeFormatter testDateTimeFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a");
		String formattedTestDateTime = testDateTime.format(testDateTimeFormat);
		
		Assert.assertEquals("> " + formattedTestDateTime + " FEED MONEY: $5.00 $5.00 ", actual);
	}
	
	@Test
	public void purchase_made_log_works_properly() {
		log.purchaseMadeLog("Potato Crisps", "A1", new BigDecimal("3.05"), new BigDecimal("1.95"));
		
		String actual = log.getStringToLog();
		
		LocalDateTime testDateTime = LocalDateTime.now();
		DateTimeFormatter testDateTimeFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a");
		String formattedTestDateTime = testDateTime.format(testDateTimeFormat);
		
		Assert.assertEquals("> " + formattedTestDateTime + " Potato Crisps A1 $5.00 $1.95 ", actual);
	}
	
	@Test
	public void finish_transaction_log_returns_correctly() {
		log.finishTransactionLog(new BigDecimal("5.00"));
		
		String actual = log.getStringToLog();
		
		LocalDateTime testDateTime = LocalDateTime.now();
		DateTimeFormatter testDateTimeFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a");
		String formattedTestDateTime = testDateTime.format(testDateTimeFormat);
		
		Assert.assertEquals("> " + formattedTestDateTime + " GIVE CHANGE: $5.00 $0.00 ", actual);
	}

}
