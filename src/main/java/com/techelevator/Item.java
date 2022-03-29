package com.techelevator;

public abstract class Item {
    private String name;
    private int price;
    private String type;
    private int quantity;

    public abstract String GetMessageReturned();

    public Item() {
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item(String name, int price, String type, int quantity) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.quantity = quantity;
    }

}
