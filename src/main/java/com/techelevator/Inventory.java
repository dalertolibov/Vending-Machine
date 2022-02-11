package com.techelevator;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Inventory {
    Map<String,Product>products=new HashMap<>();

    public Map<String, Product> getProducts() {
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
                    products.put(lines[0],new Chip(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]));
                }
                else if (lines[lines.length-1].equals("Candy")) {
                    products.put(lines[0],new Candy(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]));
                }
                else if (lines[lines.length-1].equals("Drink")) {
                    products.put(lines[0],new Beverage(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]));
                }
                if (lines[lines.length-1].equals("Gum")) {
                    products.put(lines[0],new Gum(lines[0],lines[1],Double.parseDouble(lines[2]),lines[3]));
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");

        }

    }
}
