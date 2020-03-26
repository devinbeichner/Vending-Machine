package com.techelevator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {

	private String stringToLog = "";
	
	public String getStringToLog() {
		return stringToLog;
	}

	private File logDoc = new File(".", "Log.txt");
	private FileWriter logFileWriter = null; 
	{ try {
		logFileWriter = new FileWriter(logDoc, true);
	} catch (IOException e) {
		System.out.println("Not a valid file!");
	}
	}

	private PrintWriter logWriter = new PrintWriter(logFileWriter);
	
	
	public void moneyFeedLog(BigDecimal amountFed, BigDecimal currentBalance) {
		String moneyFeeder = "> " + dateTime() + " FEED MONEY: $" + amountFed + " $" + currentBalance + " ";
		stringToLog += moneyFeeder;
	}

	public void purchaseMadeLog(String itemSelection, String itemButton, BigDecimal amountOfPurchase, BigDecimal currentBalance) {
		String purchaseMade = "> " + dateTime() + " " + itemSelection + " " + itemButton + " $"
				+ currentBalance.add(amountOfPurchase) + " $" + currentBalance + " ";
		stringToLog += purchaseMade;
	}

	public void finishTransactionLog(BigDecimal currentBalance) {
		String finishTransaction = "> " + dateTime() + " GIVE CHANGE: $" + currentBalance + " $" + currentBalance.subtract(currentBalance) + " ";
		stringToLog += finishTransaction;
	}

	public void logWriter() {
		logWriter.println("");
		logWriter.println(stringToLog);
		logWriter.flush();
	}

	private String dateTime() {
		LocalDateTime myDateTime = LocalDateTime.now();
		DateTimeFormatter myDateTimeFormat = DateTimeFormatter.ofPattern("MM-dd-yyyy h:mm:ss a");
		String formattedDateTime = myDateTime.format(myDateTimeFormat);
		return formattedDateTime;

        

	}
	

	
		
		


}
