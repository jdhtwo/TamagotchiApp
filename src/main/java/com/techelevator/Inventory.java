package com.techelevator;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Inventory {


    public static Map<String, Item> inventory() {
        Map<String, Item> map = new TreeMap<>();

        try (Scanner scanner = new Scanner(new File("vendingmachine.csv"))) {
            while (scanner.hasNextLine()) {
                String lineOfText = scanner.nextLine();
                String[] strArray = lineOfText.split("\\|");
                String type = strArray[3];
                Item item = null;
                if (type.equalsIgnoreCase("Chip"))
                    item = new Chip(strArray[1], (int) (Double.valueOf(strArray[2]) * 100), strArray[3], 5);
                if (type.equalsIgnoreCase("Gum"))
                    item = new Gum(strArray[1], (int) (Double.valueOf(strArray[2]) * 100), strArray[3], 5);
                if (type.equalsIgnoreCase("Drink"))
                    item = new Drink(strArray[1], (int) (Double.valueOf(strArray[2]) * 100), strArray[3], 5);
                if (type.equalsIgnoreCase("Candy"))
                    item = new Candy(strArray[1], (int) (Double.valueOf(strArray[2]) * 100), strArray[3], 5);
                map.put(strArray[0], item);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return map;
    }

    public static File createAuditFile() {
        File logFile = null;
        try {
            logFile = new File("log.txt");
            if (logFile.exists())
                logFile.delete();
            logFile.createNewFile();
        } catch (IOException cantCreate) {
            System.out.println(cantCreate.getStackTrace());
        }
        return logFile;
    }

    public static void logTransaction(File logFile, String transactionType, int initialBalance, int updatedBalance) throws IOException {
        try (PrintWriter logWriter = new PrintWriter(new FileWriter(logFile, true))) {
            logWriter.println(LocalDateTime.now() + " " + transactionType + " $" + initialBalance / 100.0 + " $" + updatedBalance / 100.0);
        } catch (Exception g) {
            System.out.println(g.getStackTrace());
        }
    }
}
