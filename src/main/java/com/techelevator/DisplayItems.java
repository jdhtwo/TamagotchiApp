//package com.techelevator;
//
//import java.io.*;
//import java.sql.SQLOutput;
//import java.util.Scanner;
//
//public class DisplayItems {
//
//    public void displayItems(String[] args) {
//        System.out.println("Here are the possible selections:");
//        System.out.println("");
//        try (Scanner scanner = new Scanner(new File("vendingmachine.csv"))) {
//            scanner.useDelimiter(",");
//            while (scanner.hasNext()) {
//                System.out.print(scanner.next());
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("I'm sorry but we could not find that file.");
//        }
//        System.out.println();
//        System.out.println("Press \"ENTER\" to continue...");
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("What would you like to do next?");
//
//
//    }
//
//}
