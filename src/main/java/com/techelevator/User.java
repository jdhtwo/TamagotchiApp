package com.techelevator;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class User {

    Map<String, Item> inventoryMap = Inventory.inventory();
public static int newQuantity;
    public int transactionUpdatedBalance(int balance, File logFile, User user) throws IOException {
        System.out.println("Please enter the slot position of your product (e.g. \"C4\": )");
        for (Map.Entry<String, Item> keys : inventoryMap.entrySet()) {
            System.out.println(keys.getKey() + " " + keys.getValue().getName() + " $" + keys.getValue().getPrice() / 100.0);
        }
        String slotNumber = getInputFromUser();
        Item stockedItem = inventoryMap.get(slotNumber);
        if (stockedItem != null) {
            if (balance >= stockedItem.getPrice()) {
                if (stockedItem.getQuantity() != 0) {
                    Inventory.logTransaction(logFile, stockedItem.getName() + " " + slotNumber, balance, balance - stockedItem.getPrice());
                    balance = balance - stockedItem.getPrice();
                    stockedItem.setQuantity(stockedItem.getQuantity() - 1);
                    inventoryMap.put(slotNumber, stockedItem);
                    newQuantity=stockedItem.getQuantity();
                    System.out.println(stockedItem.getName() + " $" + stockedItem.getPrice() / 100.0 + " $" + balance / 100.0 + " " + stockedItem.GetMessageReturned());
                } else System.out.println("Item Is Out OF Stock Chose Different Product!");
            } else {
                System.out.println("Not sufficient funds, add more money!");
            }
        } else {
            System.out.println("Not a valid slotID");
        }
        return balance;
    }

    public static String getInputFromUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        return scanner.nextLine().trim();
    }
}
