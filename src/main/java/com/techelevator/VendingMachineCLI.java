package com.techelevator;

import com.techelevator.data.Menu;

import java.io.IOException;

public class VendingMachineCLI {

    private static final String MENU_DISPLAY_ITEMS = "Display Vending Machine Items";
    private static final String MENU_PURCHASE = "Purchase";
    private static final String[] MAIN_MENU_OPTIONS = {MENU_DISPLAY_ITEMS, MENU_PURCHASE};

    private static final String PURCHASE_MENU_FEED_MONEY = "Feed Money";
    private static final String PURCHASE_MENU_SELECT_PRODUCT = "Select Product";
    private static final String PURCHASE_MENU_FINISH_TRANSACTION = "Finish Transaction";
    private static final String[] PURCHASE_MENU_OPTIONS = {PURCHASE_MENU_FEED_MONEY,
            PURCHASE_MENU_SELECT_PRODUCT, PURCHASE_MENU_FINISH_TRANSACTION};

    private Menu menu;

    public VendingMachineCLI(Menu menu) {
        this.menu = menu;
    }

    public void run() throws IOException {

        while (true) {
            String optionOne = (String) menu.getChoiceFromOptions(MAIN_MENU_OPTIONS);

            if (optionOne.equals(MENU_DISPLAY_ITEMS)) {
                menu.displayInventory();


            } else if (optionOne.equals(MENU_PURCHASE)) {

                while (true) {
                    String optionTwo = (String) menu.getChoiceFromOptionsPurchaseMenu(PURCHASE_MENU_OPTIONS);

                    if (optionTwo.equals(PURCHASE_MENU_FEED_MONEY)) {
                        menu.feedMoney();

                    } else if (optionTwo.equals(PURCHASE_MENU_SELECT_PRODUCT)) {
                        menu.selectProduct();
                    } else if (optionTwo.equals(PURCHASE_MENU_FINISH_TRANSACTION)) {
                        menu.finishTransaction();
                        menu.returnSoundMessages();
                        break;
                    }
                }

            }
        }
    }


    public static void main(String[] args) throws IOException {
        Menu menu = new Menu(System.in, System.out);
        VendingMachineCLI cli = new VendingMachineCLI(menu);
        cli.run();
    }
}


