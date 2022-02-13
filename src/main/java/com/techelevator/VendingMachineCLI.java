package com.techelevator;

import com.techelevator.data.Menu;

import java.awt.*;
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

            System.out.println();
            System.out.println("  _    _ __  __ ____  _____  ______ _      _                  _____ ____  _____  _____  ");
            System.out.println(" | |  | |  \\/  |  _ \\|  __ \\|  ____| |    | |        /\\      / ____/ __ \\|  __ \\|  __ \\");
            System.out.println(" | |  | | \\  / | |_) | |__) | |__  | |    | |       /  \\    | |   | |  | | |__) | |__) |");
            System.out.println(" | |  | | |\\/| |  _ <|  _  /|  __| | |    | |      / /\\ \\   | |   | |  | |  _  /|  ___/ ");
            System.out.println(" | |__| | |  | | |_) | | \\ \\| |____| |____| |____ / ____ \\  | |___| |__| | | \\ \\| |_    ");
            System.out.println("  \\____/|_|  |_|____/|_|  \\_\\______|______|______/_/    \\_\\  \\_____\\____/|_|  \\_\\_(_)   ");
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.print("VVVVVVVV           VVVVVVVVEEEEEEEEEEEEEEEEEEEEEENNNNNNNN        NNNNNNNNDDDDDDDDDDDDD             OOOOOOOOO                      MMMMMMMM               MMMMMMMM               AAA         TTTTTTTTTTTTTTTTTTTTTTTIIIIIIIIII      CCCCCCCCCCCCC          888888888          000000000          000000000     \n");
            System.out.print("V::::::V           V::::::VE::::::::::::::::::::EN:::::::N       N::::::ND::::::::::::DDD        OO:::::::::OO                    M:::::::M             M:::::::M              A:::A        T:::::::::::::::::::::TI::::::::I   CCC::::::::::::C        88:::::::::88      00:::::::::00      00:::::::::00   \n");
            System.out.print("V::::::V           V::::::VE::::::::::::::::::::EN::::::::N      N::::::ND:::::::::::::::DD    OO:::::::::::::OO                  M::::::::M           M::::::::M             A:::::A       T:::::::::::::::::::::TI::::::::I CC:::::::::::::::C      88:::::::::::::88  00:::::::::::::00  00:::::::::::::00 \n");
            System.out.print("V::::::V           V::::::VEE::::::EEEEEEEEE::::EN:::::::::N     N::::::NDDD:::::DDDDD:::::D  O:::::::OOO:::::::O                 M:::::::::M         M:::::::::M            A:::::::A      T:::::TT:::::::TT:::::TII::::::IIC:::::CCCCCCCC::::C     8::::::88888::::::80:::::::000:::::::00:::::::000:::::::0\n");
            System.out.print(" V:::::V           V:::::V   E:::::E       EEEEEEN::::::::::N    N::::::N  D:::::D    D:::::D O::::::O   O::::::O                 M::::::::::M       M::::::::::M           A:::::::::A     TTTTTT  T:::::T  TTTTTT  I::::I C:::::C       CCCCCC     8:::::8     8:::::80::::::0   0::::::00::::::0   0::::::0\n");
            System.out.print("  V:::::V         V:::::V    E:::::E             N:::::::::::N   N::::::N  D:::::D     D:::::DO:::::O     O:::::O                 M:::::::::::M     M:::::::::::M          A:::::A:::::A            T:::::T          I::::IC:::::C                   8:::::8     8:::::80:::::0     0:::::00:::::0     0:::::0\n");
            System.out.print("   V:::::V       V:::::V     E::::::EEEEEEEEEE   N:::::::N::::N  N::::::N  D:::::D     D:::::DO:::::O     O:::::O                 M:::::::M::::M   M::::M:::::::M         A:::::A A:::::A           T:::::T          I::::IC:::::C                    8:::::88888:::::8 0:::::0     0:::::00:::::0     0:::::0\n");
            System.out.print("    V:::::V     V:::::V      E:::::::::::::::E   N::::::N N::::N N::::::N  D:::::D     D:::::DO:::::O     O:::::O --------------- M::::::M M::::M M::::M M::::::M        A:::::A   A:::::A          T:::::T          I::::IC:::::C                     8:::::::::::::8  0:::::0 000 0:::::00:::::0 000 0:::::0\n");
            System.out.print("     V:::::V   V:::::V       E:::::::::::::::E   N::::::N  N::::N:::::::N  D:::::D     D:::::DO:::::O     O:::::O -:::::::::::::- M::::::M  M::::M::::M  M::::::M       A:::::A     A:::::A         T:::::T          I::::IC:::::C                    8:::::88888:::::8 0:::::0 000 0:::::00:::::0 000 0:::::0\n");
            System.out.print("      V:::::V V:::::V        E::::::EEEEEEEEEE   N::::::N   N:::::::::::N  D:::::D     D:::::DO:::::O     O:::::O --------------- M::::::M   M:::::::M   M::::::M      A:::::AAAAAAAAA:::::A        T:::::T          I::::IC:::::C                   8:::::8     8:::::80:::::0     0:::::00:::::0     0:::::0\n");
            System.out.print("       V:::::V:::::V         E:::::E             N::::::N    N::::::::::N  D:::::D     D:::::DO:::::O     O:::::O                 M::::::M    M:::::M    M::::::M     A:::::::::::::::::::::A       T:::::T          I::::IC:::::C                   8:::::8     8:::::80:::::0     0:::::00:::::0     0:::::0\n");
            System.out.print("        V:::::::::V          E:::::E       EEEEEEN::::::N     N:::::::::N  D:::::D    D:::::D O::::::O   O::::::O                 M::::::M     MMMMM     M::::::M    A:::::AAAAAAAAAAAAA:::::A      T:::::T          I::::I C:::::C       CCCCCC     8:::::8     8:::::80::::::0   0::::::00::::::0   0::::::0\n");
            System.out.print("         V:::::::V         EE::::::EEEEEEEE:::::EN::::::N      N::::::::NDDD:::::DDDDD:::::D  O:::::::OOO:::::::O                 M::::::M               M::::::M   A:::::A             A:::::A   TT:::::::TT      II::::::IIC:::::CCCCCCCC::::C     8::::::88888::::::80:::::::000:::::::00:::::::000:::::::0\n");
            System.out.print("          V:::::V          E::::::::::::::::::::EN::::::N       N:::::::ND:::::::::::::::DD    OO:::::::::::::OO                  M::::::M               M::::::M  A:::::A               A:::::A  T:::::::::T      I::::::::I CC:::::::::::::::C      88:::::::::::::88  00:::::::::::::00  00:::::::::::::00 \n");
            System.out.print("           V:::V           E::::::::::::::::::::EN::::::N        N::::::ND::::::::::::DDD        OO:::::::::OO                    M::::::M               M::::::M A:::::A                 A:::::A T:::::::::T      I::::::::I   CCC::::::::::::C        88:::::::::88      00:::::::::00      00:::::::::00   \n");
            System.out.print("            VVV            EEEEEEEEEEEEEEEEEEEEEENNNNNNNN         NNNNNNNDDDDDDDDDDDDD             OOOOOOOOO                      MMMMMMMM               MMMMMMMMAAAAAAA                   AAAAAAATTTTTTTTTTT      IIIIIIIIII      CCCCCCCCCCCCC          888888888          000000000          000000000     \n");
            System.out.println("");
            System.out.println("");

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


