package com.techelevator;

public class Product {
    private String name;
    String category;
    private double price;
    private String slot;
    private int quantity;

    //Constructor

    public Product(String slot,String name, double price, String category) {
        this.name = name;
        this.category=category;
        this.price = price;
        this.slot = slot;

        this.quantity=5;
    }

    //Getters and Setters


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

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

    public String toString(){
        return this.slot+" "+this.name+" "+this.price+" "+this.quantity;
    }
}


