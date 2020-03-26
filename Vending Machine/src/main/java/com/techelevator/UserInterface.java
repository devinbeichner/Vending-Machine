package com.techelevator;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;


public class UserInterface {

	Scanner userInput = new Scanner(System.in);

	public int mainMenu() {
	
		System.out.println();
		System.out.println("Welcome To VendoMatic800!  Please Make Your Selection!");
		System.out.println();
		System.out.println("(1) Display Vending Machine Items");
		System.out.println("(2) Purchase");
		System.out.println("(3) Exit");
		System.out.println();

		String userSelection = userInput.nextLine();
		int userSelectionInt = 0;
		
		
		try { 
			userSelectionInt = Integer.parseInt(userSelection);
			
			if(userSelectionInt < 1 || userSelectionInt > 3 ) {
				throw new NumberFormatException();
			}
		}
			catch (NumberFormatException e) {
				System.out.println("Please select a number between 1 and 3...");
				userSelectionInt = this.mainMenu();
			}

		return userSelectionInt;
	}
	
	public int purchaseMenu() {
		System.out.println();
		System.out.println("What do you want to do?");
		System.out.println();
		System.out.println("(1) Feed Money");
		System.out.println("(2) Select Product");
		System.out.println("(3) Finish Transaction");
		System.out.println();
		
		String userSelectionString = userInput.nextLine();
		int userSelection = 0;
		
		try {
			userSelection = Integer.parseInt(userSelectionString);
			
			if(userSelection < 1 || userSelection > 3) {
				throw new NumberFormatException();
			}
		} catch (NumberFormatException e) {
			System.out.println("Please choose a number between 1 and 3...");
			userSelection = this.purchaseMenu();
		}
		
		return userSelection;
		
	}
	
	public BigDecimal feedMoneyOption() {
		System.out.println();
		System.out.println("How much do you want to depost?");
		System.out.println();
		
		String amountToDepositString = userInput.nextLine();
		BigDecimal amountToDeposit = new BigDecimal("0");
		
			if ((amountToDepositString.equals("1") || amountToDepositString.equals("2") || amountToDepositString.equals("5") || amountToDepositString.equals("10") || amountToDepositString.equals("20") || amountToDepositString.equals("50") || amountToDepositString.equals("100"))){
				amountToDeposit = amountToDeposit.add(new BigDecimal(amountToDepositString).multiply(new BigDecimal("1.00")));
			}else if(amountToDepositString.equals("1.00") || amountToDepositString.equals("2.00") || amountToDepositString.equals("5.00") || amountToDepositString.equals("10.00") || amountToDepositString.equals("20.00") || amountToDepositString.equals("50.00") || amountToDepositString.equals("100.00")) {
				amountToDeposit = amountToDeposit.add(new BigDecimal(amountToDepositString));
			} else {
				System.out.println("That's not a bill! (Only accepts 1.00, 2.00, 5.00, 10.00, 20.00, 50.00, or 100.00 dollar bills)");
			}
		
		return amountToDeposit;
	
	}
	
	public String makeSelection(List<Snacks> availableButtons) {
		System.out.println();
		System.out.println("Please make your selection from the above options!");
		String itemSelection = userInput.nextLine().toUpperCase();
		boolean containsButton = false;
		
		for (int i = 0; i < availableButtons.size(); i++) {
			if(availableButtons.get(i).getButton().contains(itemSelection)) {
				containsButton = true;
			}
		}
				
		if(itemSelection.length()> 2 || itemSelection.length()<2 || !containsButton) {
			System.out.println("Please select from the options provided...");
			itemSelection = this.makeSelection(availableButtons);
		}
		
		return itemSelection;
		
	}

}	
