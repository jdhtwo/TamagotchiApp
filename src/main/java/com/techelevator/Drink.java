package com.techelevator;

public class Drink extends Item implements YumYumInterface {
    public Drink(String name, int price, String type, int quantity) {
        super(name, price, type, quantity);
    }

    @Override
    public String GetMessageReturned() {
        return "Glug Glug, Yum!";
    }
}
