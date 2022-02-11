package com.techelevator.data;

public class Gum extends Product{

    public Gum(String name, String price) {
        super(name, price);
    }

    @Override
    public String getEatingSound() {
        return "\"Chew Chew, Yum!\"";
    }

}
