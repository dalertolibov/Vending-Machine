package com.techelevator.data;

public class Candy extends Product{

    public Candy(String name, String price) {
        super(name, price);
    }

    @Override
    public String getSound() {
        return "\"Munch Munch, Yum!\"";
    }

}
