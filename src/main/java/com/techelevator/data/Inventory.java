package com.techelevator.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class Inventory {

   private Map<Slot,Product>products=new HashMap<>();
   private Map<Product,Integer>inventoryItemsAndCount=new HashMap<>();






    public void setProducts(Map<Slot, Product> products) {
        this.products = products;
    }

    public Map<Product, Integer> getInventoryCount() {
        return inventoryItemsAndCount;
    }

    public void setInventoryCount(Map<Product, Integer> inventoryCount) {
        this.inventoryItemsAndCount = inventoryCount;
    }

    public Map<Slot,Product> getProducts() {
        return products;
    }

    public void restockInventory(File file){
        fileSplitter(file);
    }







// Splits CSV file and puts values in Product map
    private void fileSplitter(File file){
        try(Scanner scanner = new Scanner(file)){
            while (scanner.hasNextLine()){
                String line=scanner.nextLine();
                String []lines=line.split("\\|");
                if (lines[lines.length-1].equals("Chip")) {
                    products.put(new Slot(lines[0]), new Chip(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]));
                    inventoryItemsAndCount.put(new Chip(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]),5);
                }
                else if (lines[lines.length-1].equals("Candy")) {
                    products.put(new Slot(lines[0]), new Candy(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]));
                    inventoryItemsAndCount.put(new Chip(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]),5);
                }
                else if (lines[lines.length-1].equals("Drink")) {
                    products.put(new Slot(lines[0]),new Beverage(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]));
                    inventoryItemsAndCount.put(new Chip(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]),5);
                }
                if (lines[lines.length-1].equals("Gum")) {
                    products.put(new Slot(lines[0]),new Gum(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]));
                    inventoryItemsAndCount.put(new Chip(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]),5);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");

        }

    }
}
