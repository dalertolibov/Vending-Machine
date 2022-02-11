package com.techelevator.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class VendingMachine {

    private Inventory vendingMachineInventory;
    private BankAccount vendingMachineBankAccount;
    private FileReaderCSV vendingMachineFileReader;
    private Logger vendingMachineLogger;
    private ShoppingCart vendingMachineShoppingCart;

    public VendingMachine(Inventory vendingMachineInventory) throws IOException {
        this.vendingMachineInventory = vendingMachineInventory;
        vendingMachineFileReader = new FileReaderCSV();
        vendingMachineInventory = new Inventory(vendingMachineFileReader);
        vendingMachineBankAccount = new BankAccount();
        vendingMachineLogger = new Logger();
        vendingMachineShoppingCart = new ShoppingCart();
    }

    public void feedMoney(int billInput) throws IOException {
        vendingMachineBankAccount.depositMoney(billInput);
        String billDisplaysAsString = "$" + billInput + ".00";
        vendingMachineLogger.logEvent("FEED MONEY:", billDisplaysAsString, balanceAsString());
    }

    public void subtractBalance(String slotLocation) {
        int debit = vendingMachineInventory.vendingMachineStock().get(slotLocation).getPriceAsIntInPennies();
        vendingMachineBankAccount.withdrawMoney(debit);

    }

    public int getBalanceInPennies() {
        int balance = vendingMachineBankAccount.balanceInPennies();
        return balance;
    }

    public String balanceAsString() {
        String returnString = vendingMachineBankAccount.balanceToString();
        return returnString;
    }

    public String returnChangeInCoins() throws IOException {
        vendingMachineLogger.logEvent("GIVE CHANGE:", balanceAsString(), "$0.00");
        String returnString = vendingMachineBankAccount.returnChangeInCoins(getBalanceInPennies());
        return returnString;
    }

    public void subtractFromInventory(String slotLocation) {
        vendingMachineInventory.subtractFromInventory(slotLocation);
    }

    public List<String> getInventoryString() {
        TreeMap<String, Product> returnMap = vendingMachineFileReader.mapLocationAndProduct();

        List<String> inventory = new ArrayList<>();

        for (Map.Entry<String, Product> entry : returnMap.entrySet()) {
            String inventoryValueToString = String
                    .valueOf(vendingMachineInventory.returnCurrentInventory(entry.getKey()));

            if (inventoryValueToString.contentEquals("0")) {
                inventoryValueToString = "Sold Out";
            }

            String formattedString = String.format("%-5s %-22s %-5s %-5s", entry.getKey(), entry.getValue().getName(),
                    entry.getValue().getPriceAsString(), inventoryValueToString);
            inventory.add(formattedString);

        }
        return inventory;
    }

    public List<String> returnSounds() {
        return vendingMachineShoppingCart.returnListOfSounds();
    }

    public String purchaseItem(String slotLocation) throws IOException {
        try {
            if (vendingMachineInventory.returnCurrentInventory(slotLocation) == 0) {
                return vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + " Sold Out \n";
            } else if (vendingMachineBankAccount.balanceInPennies() < vendingMachineInventory.vendingMachineStock()
                    .get(slotLocation).getPriceAsIntInPennies()) {
                return "Please Insert Additional Funds \n";
            } else {
                String balanceBeforePurchase = balanceAsString();
                subtractFromInventory(slotLocation);
                subtractBalance(slotLocation);
                String successfulPurchase = "Thank You For Purchasing "
                        + vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + "\n";
                vendingMachineShoppingCart
                        .addSoundToList(vendingMachineInventory.vendingMachineStock().get(slotLocation).getSound());
                vendingMachineLogger.logEvent(
                        vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + "  " + slotLocation,
                        balanceBeforePurchase, balanceAsString());
                return successfulPurchase;
            }

        } catch (NullPointerException e) {
            return "Please Make A Valid Selection \n";
        }
    }


}














