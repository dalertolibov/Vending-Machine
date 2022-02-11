package com.techelevator;

import java.util.ArrayList;
import java.util.List;

public class Order{


    private Product product;
    private Inventory inventory;
    private BankAccount bankAccount;

    public Order(Inventory inventory,BankAccount bankAccount){

        this.bankAccount=bankAccount;
        this.inventory=inventory;
    }

    public void addProduct(Slot slot){


    }


}
