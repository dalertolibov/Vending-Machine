package com.techelevator;

public class Product {
    private String name;
    private double price;
    private String slot;

    //Constructor

    public Product(String name, double price, String slot) {
        this.name = name;
        this.price = price;
        this.slot = slot;
    }

    //Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }
}


