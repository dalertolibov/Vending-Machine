package com.techelevator.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class VendingMachineTest {

    private Inventory sutInventory;
    private BankAccount sutBankAccount;
    private FileReaderCSV sutFileReaderCSV;
    private VendingMachine sutVendingMachine;

    @Before
    public void setUp() throws IOException {
        sutFileReaderCSV = new FileReaderCSV();
        sutInventory = new Inventory(sutFileReaderCSV);
        sutVendingMachine = new VendingMachine(sutInventory);
        sutBankAccount = new BankAccount();
    }

    @Test
    public void vending_machine_item_out_of_scope_return_null() {
        Assert.assertEquals(null, sutInventory.vendingMachineStock().get("C17"));
    }

    @Test
    public void vending_machine_stock_b2_returns_cowtales() {
        Assert.assertEquals("Cowtales", sutInventory.vendingMachineStock().get("B2").getName());
    }

    @Test
    public void deposit_money_10_dollars_return_1000_balance_in_pennies() {
        sutBankAccount.depositMoney(10);
        Assert.assertEquals(1000, sutBankAccount.balanceInPennies());
    }

    @Test
    public void vending_machine_stock_c4_return_150_balance_in_pennies() {
        Assert.assertEquals(150, sutInventory.vendingMachineStock().get("C4").getPriceInPennies());
    }


    @Test
    public void subtract_balance_returns_correct_balance_in_pennies() throws IOException {
        sutVendingMachine.feedMoney(2);
        sutVendingMachine.subtractBalance("B4");
        Assert.assertEquals(25, sutVendingMachine.getBalanceInPennies());
    }

    @Test
    public void subtract_from_inventory_returns_updated_quantity() {
        sutVendingMachine.subtractFromInventory("A2");
        Assert.assertEquals(4, sutInventory.returnCurrentInventory("A2"));
    }

    @Test
    public void current_balance_to_string() throws IOException {
        sutVendingMachine.feedMoney(5);
        sutVendingMachine.subtractBalance("B2");
        Assert.assertEquals("$3.50", sutVendingMachine.balanceAsString());
    }



}