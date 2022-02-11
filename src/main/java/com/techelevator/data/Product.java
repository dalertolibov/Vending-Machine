package com.techelevator.data;

public abstract class Product {

    private String name;
    private String price;

    //Constructor
    public Product(String name, String price) {
        this.name = name;
        this.price = price;
    }

    public abstract String getSound();

    public String getName() {
        return name;
    }

    public String getPriceAsString() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getPriceAsIntInPennies() {
        price = price.replace("$", "").replace(".","");
        return Integer.parseInt(price);
    }


}


