package com.techelevator.data;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    private BankAccount sut;

    @Before
    public void setUp() {
        sut=new BankAccount();
        sut.depositMoney(10);
    }

    @Test
    public void deposit_money_should_return_1500() {
        sut.depositMoney(5);
        Assert.assertEquals(1500,sut.balanceInPennies());
    }

    @Test
    public void withdraw_money_should_return_995() {
        sut.withdrawMoney(5);
        Assert.assertEquals(995,sut.balanceInPennies());
    }

    @Test
    public void balance_in_pennies_should_return_1000_pennies() {
        Assert.assertEquals(1000,sut.balanceInPennies());
    }

    @Test
    public void balance_to_string() {
        sut.depositMoney(20);
        Assert.assertEquals("$30.00",sut.balanceToString());
    }

    @Test
    public void return_change_in_coins_should_return_40_quaters_0_dimes_0_pennies() {

        Assert.assertEquals("Your change is 40 quarters, 0 dimes, and 0 nickels.",sut.returnChangeInCoins(sut.balanceInPennies()));
    }
}