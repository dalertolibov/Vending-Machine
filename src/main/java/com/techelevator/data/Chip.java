package com.techelevator.data;

public class Chip extends Product{

    public Chip(String name, String price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "\"Crunch Crunch, Yum!\"";
    }

}
