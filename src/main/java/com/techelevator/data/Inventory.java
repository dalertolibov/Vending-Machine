package com.techelevator.data;

import java.util.Map;
import java.util.TreeMap;

public class Inventory {

    private FileReaderCSV fileReaderObject;
    private TreeMap<String, Integer> inventoryList = new TreeMap<>();

    public Inventory(FileReaderCSV fileReaderObject) {
        this.fileReaderObject = fileReaderObject;
        parLevelAtStartUp();
    }

    private void parLevelAtStartUp() {
        for (String[] product : fileReaderObject.inventoryArrayList()) {
            int startingStock = 5;
            inventoryList.put(product[0], startingStock);
        }
    }

    public Map<String, Product> vendingMachineStock() {
        return fileReaderObject.mapLocationAndProduct();
    }

    public void subtractFromInventory(String slotLocation) {
        inventoryList.put(slotLocation, inventoryList.get(slotLocation) - 1);
    }

    public int returnCurrentInventory(String slotLocation) {
        return inventoryList.get(slotLocation);
    }

    public Map<String, Integer> returnInventoryMap() {
        return inventoryList;
    }
}








