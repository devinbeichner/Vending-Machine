package com.techelevator;

import java.math.BigDecimal;

public class VendoMatic800 {

	public static void main(String[] args) {
		
		
		Log log = new Log();
		
		
		VendingMachine newVendingMachine = new VendingMachine();
		newVendingMachine.restock();
		
		UserInterface newUser = new UserInterface();
		int userSelection = newUser.mainMenu();
		boolean killswitch1 = true;
		
		while(killswitch1) {
			if (userSelection == 1 ) {
				newVendingMachine.displayItems();
				userSelection = newUser.mainMenu();
			} else if (userSelection == 2){
				int purchaseSelection = newUser.purchaseMenu();
				
				if(purchaseSelection == 1) {
					BigDecimal amountToDeposit = newUser.feedMoneyOption();
					newVendingMachine.feedMoney(amountToDeposit);
					log.moneyFeedLog(amountToDeposit, newVendingMachine.getCurrentBalance());
					System.out.println("New balance is: $" + newVendingMachine.getCurrentBalance());
				}
				else if (purchaseSelection == 2 ) {
					newVendingMachine.displayItems();
					boolean killswitch2 = true;
					
					while(killswitch2) {
						String selection = newUser.makeSelection(newVendingMachine.getProductList());
							
						for (int i = 0; i < newVendingMachine.getProductList().size(); i++) {
							
							if (newVendingMachine.getProductList().get(i).getButton().contains(selection)) {
								if(newVendingMachine.currentBalance.subtract(newVendingMachine.getProductList().get(i).getPrice()).compareTo(new BigDecimal("0.00")) >= 0 && newVendingMachine.getProductList().get(i).getStock() > 0) {
									newVendingMachine.getProductList().get(i).dispense();
									newVendingMachine.dispenseItem(selection);
									System.out.println("New balance is: $" + newVendingMachine.getCurrentBalance());
									log.purchaseMadeLog(newVendingMachine.getProductList().get(i).getName(), newVendingMachine.getProductList().get(i).getButton(), newVendingMachine.getProductList().get(i).getPrice(), newVendingMachine.getCurrentBalance());
									killswitch2 = false;
									break;
								} else if (newVendingMachine.currentBalance.subtract(newVendingMachine.getProductList().get(i).getPrice()).compareTo(new BigDecimal("0.00")) < 0){
									System.out.println("Come back when you got some money, buddy!");
									killswitch2 = false;
									break;
								} else {
									System.out.println("OUT OF STOCK!");
									killswitch2 = false;
									break;
								}
							}
						}
					}
					
				}
				else {
					log.finishTransactionLog(newVendingMachine.getCurrentBalance());
					System.out.println(newVendingMachine.finishTransaction());
					userSelection = newUser.mainMenu();
				}
				
			}else {
				log.logWriter();
				System.out.println();
				System.out.println("Thank you for using the VendoMatic 800!!!");
				System.exit(0);
				
			}
		}
		
	}

}
