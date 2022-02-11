package com.techelevator.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReaderCSV {

    private String vendingMachineFile = "vendingmachine.csv";
    private File vendingInventoryFile = new File(vendingMachineFile);

    private List<String> listAllProductData() {
        List<String>  listInputFileLines = new ArrayList<>();
        try(Scanner fileScanner = new Scanner(vendingInventoryFile)) {
            while (fileScanner.hasNextLine()) {
                listInputFileLines.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
        }
        return listInputFileLines;

    }

    public List<String[]> inventoryArrayList() {

        List<String[]> inventoryArray = new ArrayList<>();

        for (String line : listAllProductData()) {
            inventoryArray.add(line.split("\\|"));
        }
        return inventoryArray;
    }

    public TreeMap<String, Product> mapLocationAndProduct() {
        TreeMap<String, Product> inventoryProductMap = new TreeMap<String, Product>();
        for (String line : listAllProductData()) {
            String[] defineProductCategory = line.split("\\|");
            if (defineProductCategory[3].equals("Candy")) {
                Candy candy = new Candy(defineProductCategory[1], defineProductCategory[2]);
                inventoryProductMap.put(defineProductCategory[0], candy);
            } else if (defineProductCategory[3].equals("Chip")) {
                Chip chip = new Chip(defineProductCategory[1], defineProductCategory[2]);
                inventoryProductMap.put(defineProductCategory[0], chip);
            } else if (defineProductCategory[3].equals("Drink")) {
                Drink drink = new Drink(defineProductCategory[1], defineProductCategory[2]);
                inventoryProductMap.put(defineProductCategory[0], drink);
            } else if (defineProductCategory[3].equals("Gum")) {
                Gum gum = new Gum(defineProductCategory[1], defineProductCategory[2]);
                inventoryProductMap.put(defineProductCategory[0], gum);
            }
        }
        return inventoryProductMap;
    }

        }





