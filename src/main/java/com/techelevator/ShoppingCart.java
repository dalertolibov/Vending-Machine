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
        if(inventory.getProducts().get(slot).getCount()>0){
            productsAtShoppingCart.add(inventory.getProducts().get(slot));
            inventory.getProducts().get(slot).setCount(inventory.getProducts().get(slot).getCount()-1);

        }


    }

    public List<Product> getProductsAtShoppingCart() {
        return productsAtShoppingCart;
    }
}
