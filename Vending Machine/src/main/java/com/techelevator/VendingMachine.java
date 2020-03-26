package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class VendingMachine {
	
	List<Snacks> productList = new ArrayList<>();
	BigDecimal currentBalance = new BigDecimal("0");

	public void restock() {
		
		File restockFile = new File("vendingmachine.csv");
		
		try(Scanner restockFileScanner = new Scanner(restockFile)){
			
			while(restockFileScanner.hasNextLine()) {
				String[] productToProcess = restockFileScanner.nextLine().split("[|]");

				if(productToProcess[3].equals("Chip")) {
					Chips chipToProcess = new Chips(productToProcess[0], productToProcess[1], new BigDecimal(productToProcess[2]));
					productList.add(chipToProcess);
					
				} else if(productToProcess[3].equals("Candy")) {
					Candy candyToProcess = new Candy(productToProcess[0], productToProcess[1], new BigDecimal(productToProcess[2]));
					productList.add(candyToProcess);
					
				} else if(productToProcess[3].equals("Drink")) {
					Beverages drinkToProcess = new Beverages(productToProcess[0], productToProcess[1], new BigDecimal(productToProcess[2]));
					productList.add(drinkToProcess);
					
				} else {
					Gum gumToProcess = new Gum(productToProcess[0], productToProcess[1], new BigDecimal(productToProcess[2]));
					productList.add(gumToProcess);
				}
				
				
			}
			
		} catch (FileNotFoundException e) {
			System.out.println("That's not the correct restock file");
		}
			
	}
	
	public void displayItems() {
		System.out.println();
		for(int i = 0; i < productList.size(); i++) {
			if(productList.get(i).getStock() != 0) {
				System.out.println("(" + productList.get(i).getButton() + ") " + productList.get(i).getName() + ":");
				System.out.println("$" + productList.get(i).getPrice());
				System.out.println(productList.get(i).getStock() + " in Stock");
				System.out.println();
			} else {
				System.out.println("(" + productList.get(i).getButton() + ") " + productList.get(i).getName() + ":");
				System.out.println("$" + productList.get(i).getPrice());
				System.out.println("OUT OF STOCK!");
				System.out.println();
			}
		}
	}
	
	public void feedMoney(BigDecimal amountToFeed) {
		currentBalance = currentBalance.add(amountToFeed);	
	}

	public String finishTransaction () {
		BigDecimal balanceToChange = this.getCurrentBalance();
		int quarters = 0;
		int dimes = 0;
		int nickels = 0;
		

		while (balanceToChange.compareTo(new BigDecimal("0")) > 0) {
			if ( balanceToChange.compareTo(new BigDecimal(".25")) >= 0) {
				quarters++;
				balanceToChange = balanceToChange.subtract(new BigDecimal (".25")); 
			}
			else if (balanceToChange.compareTo(new BigDecimal(".10")) >= 0 ) {
				dimes++;
				balanceToChange = balanceToChange.subtract(new BigDecimal(".10"));
			}
			else {
				nickels++;
				balanceToChange = balanceToChange.subtract(new BigDecimal(".05"));
			}
		}
		this.currentBalance = new BigDecimal("0");
		return "Here is your change..  Quarters: " + quarters + " Dimes: " + dimes + " Nickels: " + nickels + ".";
	}
	
	public void dispenseItem(String selection) {
		
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getButton().contains(selection)) {
				System.out.println();
				System.out.println(productList.get(i).getName());
				System.out.println(productList.get(i).getPrice());
				System.out.println(productList.get(i).toString());
				System.out.println();
				
				currentBalance = currentBalance.subtract(productList.get(i).getPrice());
			}
		}
		
	}
		
	public List<Snacks> getProductList() {
		return productList;
	}
	public BigDecimal getCurrentBalance() {
		return currentBalance;
	}
}
	

