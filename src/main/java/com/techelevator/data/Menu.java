package com.techelevator.data;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {

    private Scanner keyboard;
    private PrintWriter pw;
    private FileReaderCSV vendingMachineFileReader = new FileReaderCSV();
    private Inventory inventory = new Inventory(vendingMachineFileReader);
    private VendingMachine vendingMachine = new VendingMachine(inventory);

    public Menu(InputStream input, OutputStream output)throws IOException {
        this.pw = new PrintWriter(output);
        this.keyboard = new Scanner(input);
        inventory.vendingMachineStock();

    }

    public Object getChoiceFromOptions(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptions(options);
            choice = getChoiceFromUserInput(options);
        }
        return choice;
    }

    private Object getChoiceFromUserInput(Object[] options) {
        Object choice = null;
        String userInput = keyboard.nextLine();
        try {
            int selectedOption = Integer.valueOf(userInput);
            if (selectedOption > 0 && selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }
        } catch (NumberFormatException e) {
        }
        if (choice == null) {
            pw.println("\n*** " + userInput + " is not a valid option ***\n");
        }
        return choice;
    }

    private void displayMenuOptions(Object[] options) {
        pw.println();
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            pw.println(optionNum + ") " + options[i]);
        }
        pw.print("\nPlease choose an option >>> ");
        pw.flush();
    }

    public Object getChoiceFromOptionsPurchaseMenu(Object[] options) {
        Object choice = null;
        while (choice == null) {
            displayMenuOptionsPurchaseMenu(options);
            choice = getChoiceFromUserInputPurchaseMenu(options);
        }
        return choice;
    }

    private Object getChoiceFromUserInputPurchaseMenu(Object[] options) {
        Object choice = null;
        String userInput = keyboard.nextLine();
        try {
            int selectedOption = Integer.valueOf(userInput);
            if (selectedOption > 0 && selectedOption <= options.length) {
                choice = options[selectedOption - 1];
            }
        } catch (NumberFormatException e) {
            // eat the exception, an error message will be displayed below since choice will
            // be null
        }
        if (choice == null) {
            pw.println("\n*** " + userInput + " is not a valid option ***\n");
        }
        return choice;
    }

    private void displayMenuOptionsPurchaseMenu(Object[] options) {
        for (int i = 0; i < options.length; i++) {
            int optionNum = i + 1;
            pw.println(optionNum + ") " + options[i]);
        }
        pw.println("Current Money Provided: " + displayCurrentBalance());
        pw.print("\nPlease choose an option >>> ");
        pw.flush();

    }

    public void displayInventory() {
        for (String eachLine : vendingMachine.getInventoryString()) {
            System.out.println(eachLine);
        }
    }

    public void feedMoney() throws IOException {
        System.out.println("Please Insert U.S. Dollar Bills");
        try {
            int moneyInserted = keyboard.nextInt();
            keyboard.nextLine();
            if (moneyInserted == 1 || moneyInserted == 2 || moneyInserted == 5 || moneyInserted == 10
                    || moneyInserted == 20 || moneyInserted == 50 || moneyInserted == 100) {
                vendingMachine.feedMoney(moneyInserted);
                System.out.println("Thank You For inserting $" + moneyInserted + ".00");
            } else {
                System.out.println("Please Insert Valid Currency");
            }
        } catch (InputMismatchException e) {
            System.out.println("Please Insert Valid Currency");
        }

    }

    public void selectProduct() throws IOException {
        System.out.println("Please Select Product");
        String userSelection =keyboard.nextLine();         //to be created-Douglas
        String returnString = vendingMachine.purchaseItem(userSelection);
        System.out.println(returnString);

    }

    public String displayCurrentBalance() {
        return vendingMachine.getBalanceAsString();

    }

    public void finishTransaction() throws IOException {
        System.out.println(vendingMachine.returnChangeInCoins());
    }

    public void returnSoundMessages() {
        for (String eachLine : vendingMachine.soundMessages()) {
            System.out.println(eachLine);
        }
    }


    public String purchaseItem(String slotLocation) throws IOException {
        try {
            if (vendingMachineInventory.returnCurrentInventory(slotLocation) == 0) {
                return vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + " Sold Out \n";
            } else if (vendingMachineCoinBox.getBalanceInPennies() < vendingMachineInventory.vendingMachineStock()
                    .get(slotLocation).getPriceAsIntInPennies()) {
                return "Please Insert Additional Funds \n";
            } else {
                String balanceBeforePurchase = getBalanceAsString();
                subtractFromInventory(slotLocation);
                subtractMoney(slotLocation);
                String successfulPurchase = "Thank You For Purchasing "
                        + vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + "\n";
                vendingMachineShoppingCart
                        .addSoundToList(vendingMachineInventory.vendingMachineStock().get(slotLocation).getSound());
                vendingMachineLogger.logEvent(
                        vendingMachineInventory.vendingMachineStock().get(slotLocation).getName() + "  " + slotLocation,
                        balanceBeforePurchase, getBalanceAsString());
                return successfulPurchase;
            }

        } catch (NullPointerException e) {
            return "Please Make A Valid Selection \n";
        }
        }


    public String soundMessage() {
        return ""; //INCOMPLETE - Douglas
    }
}






