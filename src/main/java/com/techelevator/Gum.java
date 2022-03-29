package com.techelevator;

public class Gum extends Item implements YumYumInterface {
    public Gum(String name, int price, String type, int quantity) {
        super(name, price, type, quantity);
    }


    private void run(){
        createGum();
    }

    static void createGum(){

    }

    @Override
    public String GetMessageReturned() {
        return "Chew Chew, Yum!";
    }
}
