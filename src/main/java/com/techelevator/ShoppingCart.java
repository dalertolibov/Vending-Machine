package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {


    private List<Product> productsAtShoppingCart=new ArrayList<>();
    private Inventory inventory;

    public ShoppingCart(Inventory inventory){
        this.inventory=inventory;
    }

    public void addProduct(String slot){

    }

    public List<Product> getProductsAtShoppingCart() {
        return productsAtShoppingCart;
    }
}
