package com.techelevator;

public class Candy extends Item {
    public Candy(String name, int price, String type, int quantity) {
        super(name, price, type, quantity);
    }

    @Override
    public String GetMessageReturned() {
        return "Munch Munch, Yum!";
    }

}
