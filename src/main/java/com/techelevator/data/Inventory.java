package com.techelevator.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {

   private Map<Slot,Product>products=new HashMap<>();
   private Map<Product,Integer>inventoryCount=new HashMap<>();

   //Constructor INCOMPLETE - Douglas
    public Inventory(FileReaderCSV vendingMachineFileReader) {
    }


    public void setProducts(Map<Slot, Product> products) {
        this.products = products;
    }

    public Map<Product, Integer> getInventoryCount() {
        return inventoryCount;
    }

    public void setInventoryCount(Map<Product, Integer> inventoryCount) {
        this.inventoryCount = inventoryCount;
    }

    public Map<Slot,Product> getProducts() {
        return products;
    }

    public int vendingMachineStock() {
        return 0;//NOT COMPLETE - Douglas
    }




    }





