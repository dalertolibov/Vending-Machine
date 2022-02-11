package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    private Integer quantity;
   private Map<Product,Integer>products=new HashMap<>();

    public Map<Product,Integer> getProducts() {
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
                    products.put(new Chip(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]),quantity);
                }
                else if (lines[lines.length-1].equals("Candy")) {
                    products.put(new Candy(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]),quantity);
                }
                else if (lines[lines.length-1].equals("Drink")) {
                    products.put(new Beverage(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]),quantity);
                }
                if (lines[lines.length-1].equals("Gum")) {
                    products.put(new Gum(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]),quantity);
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");

        }

    }
}
