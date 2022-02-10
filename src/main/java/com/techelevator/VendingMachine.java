package com.techelevator;

import java.util.Scanner;

public class VendingMachine {

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        VendingMachineUI ui = new VendingMachineUI(keyboard);

        String display = ui.promptMainMenuDisplay();
    }
}
