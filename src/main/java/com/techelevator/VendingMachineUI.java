package com.techelevator;

import java.util.Scanner;

public class VendingMachineUI {

    private Scanner keyboard;

    public VendingMachineUI(Scanner keyboard) {
        this.keyboard = keyboard;
    }

    public String promptMainMenuDisplay() {

        System.out.println("Welcome to the virtual cafe!");
        System.out.println("Review your options below");
        System.out.println();

        System.out.println("(1) Display Vending Machine Items");
        System.out.println("(2) Purchase");
        System.out.println("(3) Exit");
        System.out.println();

        System.out.print("Enter the digit corresponding with your choice: >>> ");
        String optionSelected = keyboard.nextLine();

        if (optionSelected.equals("1")) {
            return "display";
        } else if (optionSelected.equals("2")) {
            return "purchase";
        } else if (optionSelected.equals("3")) {
            return "exit";
        } else {
            return "";
        }
        }

    }


