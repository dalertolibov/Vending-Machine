package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    private List<Product> productsAtCart=new ArrayList<>();

    public void addProduct(Product product){
        productsAtCart.add(product);
    }

}
