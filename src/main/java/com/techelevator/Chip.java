package com.techelevator;

public class Chip extends Item implements YumYumInterface {
    public Chip(String name, int price, String type, int quantity) {
        super(name, price, type, quantity);
    }

    @Override
    public String GetMessageReturned() {
        return "Crunch Crunch, Yum!";
    }
}
