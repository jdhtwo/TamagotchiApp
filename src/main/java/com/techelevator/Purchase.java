package com.techelevator;

import java.io.File;
import java.io.IOException;

public class Purchase {
    int balance;
    public String returnChangeAsCoins(int balance) {
        int changeToCoins = balance;
        int totalQuartersToReturn = 0;
        int totalDimesToReturn = 0;
        int totalNickelsToReturn = 0;

        int quarter = 25;
        int dime = 10;
        int nickel = 5;

        while (changeToCoins > 0) {
            if (changeToCoins >= quarter) {
                totalQuartersToReturn++;
                changeToCoins -= quarter;
            } else if (changeToCoins >= dime) {
                totalDimesToReturn++;
                changeToCoins -= dime;
            } else if (changeToCoins >= nickel) {
                totalNickelsToReturn++;
                changeToCoins -= nickel;
            }

        }
        String changeInCoins = "Your change is " + totalQuartersToReturn + " quarters, " + totalDimesToReturn
                + " dimes, " + "and " + totalNickelsToReturn + " nickels.";
        return changeInCoins;
    }
    public int feedMoneyAddToBalance(int money, File logFile) throws IOException {
        System.out.println("Please enter your money into the slot.");
        System.out.println("How much is your bill worth?");
        String c = User.getInputFromUser();
        int moneyInt = Integer.parseInt(c);
        if (moneyInt == 1 || moneyInt == 2 || moneyInt == 5 || moneyInt == 10 || moneyInt == 20 || moneyInt == 50 || moneyInt == 100) {
            Inventory.logTransaction(logFile, "FEED MONEY", money, moneyInt * 100 + money);

            money += moneyInt * 100;
            System.out.println("Thank you. Your current balance is: " + "$" + (double) money / 100);
        } else {
            System.out.println("I'm sorry - that is not a valid entry. Please try again.");
        }
        return money;
    }

    public void makeTransaction(int balance, File logFile, User user) throws IOException {
        Purchase purchase = new Purchase();
        boolean purchaseMenu = true;
        while (purchaseMenu) {
            System.out.println("What would you like to do next?");
            System.out.println("1) Add more money to your balance");
            System.out.println("2) Select a product");
            System.out.println("3) Get change and return to main menu");
            String userSelectionForMainMenu = User.getInputFromUser();

            if (userSelectionForMainMenu.equals("1")) {
                balance = purchase.feedMoneyAddToBalance(balance, logFile);
            } else if (userSelectionForMainMenu.equals("2")) {
                balance = user.transactionUpdatedBalance(balance, logFile, user);
            } else if (userSelectionForMainMenu.equals("3")) {
                Inventory.logTransaction(logFile, "GIVE CHANGE", balance, 0);
                System.out.println(returnChangeAsCoins(balance));
//              System.out.println("Your change is: " + "$" + (double) balance / 100);
                purchaseMenu = false;
            } else {
                System.out.println("Invalid input");
            }
        }
    }
}