package com.techelevator.data;

public class Drink extends Product {

    public Drink(String name, String price) {
        super(name, price);
    }

    @Override
    public String getEatingSound() {
        return "\"Glug Glug, Yum!\"";
    }

}
