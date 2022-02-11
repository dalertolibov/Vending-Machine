package com.techelevator.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;

public class FileReaderCSV {

    //Instantiate
    private String vendingMachineFile = "vendingmachine.csv";
    private File inventoryFile = new File(vendingMachineFile);

    private List<String> listAllProductData() {
        List<String>  listInputFileLines = new ArrayList<>();
        try(Scanner fileScanner = new Scanner(inventoryFile)) {
            while (fileScanner.hasNextLine()) {
                listInputFileLines.add(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
        }
        return listInputFileLines;

    }

    public List<String[]> inventoryArrayList() {

        List<String[]> inventoryArray   =   new ArrayList<String[]>();

        for (String line : listAllProductData()) {
            inventoryArray.add(line.split("\\|"));
        }
        return inventoryArray;
    }

    public TreeMap<String, Product> mapLocationAndProduct() {
        TreeMap<String, Product> inventoryMap = new TreeMap<String, Product>();
        for (String line : listAllProductData()) {
            String[] defineProductCategory = line.split("\\|");
            if (defineProductCategory[3].equals("Candy")) {
                Candy candy = new Candy(defineProductCategory[1], defineProductCategory[2]);
                inventoryMap.put(defineProductCategory[0], candy);
            } else if (defineProductCategory[3].equals("Chip")) {
                Candy candy = new Candy(defineProductCategory[1], defineProductCategory[2]);
                inventoryMap.put(defineProductCategory[0], candy);
            } else if (defineProductCategory[3].equals("Drink")) {
                Candy candy = new Candy(defineProductCategory[1], defineProductCategory[2]);
                inventoryMap.put(defineProductCategory[0], candy);
            } else if (defineProductCategory[3].equals("Gum")) {
                Candy candy = new Candy(defineProductCategory[1], defineProductCategory[2]);
                inventoryMap.put(defineProductCategory[0], candy);
            }
        }
        return inventoryMap;
    }

        }





