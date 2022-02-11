package com.techelevator.data;

import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {

    private Scanner keyboard;
    private PrintWriter pw;
    private FileReader

    public Menu(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public String promptMainMenuDisplay() {

        System.out.println();
        System.out.println("Welcome To The Virtual Vending Machine!");
        System.out.println("Review your options below");
        System.out.println();

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println();

        System.out.print("Enter the digit corresponding with your choice: >>> ");
        String optionSelected = keyboard.nextLine();
        String inputMainMenuDisplay = optionSelected.trim().toLowerCase();

        if (inputMainMenuDisplay.equals("1")) {
            return displayVendingItems;
        } else if (inputMainMenuDisplay.equals("2")) {
            return purchasingProcessMenu;
        } else if (inputMainMenuDisplay.equals("3")) {
            return inputMainMenuDisplay;
        } else {
            return "";
        }
    }

    public String promptDisplayVendingMachineItems() {
        return null; //Need Products From Inventory
    }

    public String promptPurchasingProcessMenu() {

        System.out.println();
        System.out.println("Order Coming Up! But First...Choose An Option Below");
        System.out.println("******* NEW CUSTOMERS MUST FIRST FEED MONEY *******");
        System.out.println();

        System.out.println("(1) Feed Money");
        System.out.println("(2) Select Product");
        System.out.println("(3) Finish Transaction");
        System.out.println();

        System.out.print("Enter the digit corresponding with your choice: >>> ");
        String optionSelected = keyboard.nextLine();
        String inputPurchasingProcessMenu = optionSelected.trim().toLowerCase();

        return inputPurchasingProcessMenu;
    }

    public String promptFeedMoney() {
        System.out.println();
        System.out.println("Enter amount to feed: >>> ");
        double amount = keyboard.nextDouble();

    }
}


 */

