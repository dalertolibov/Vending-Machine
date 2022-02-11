package com.techelevator;

public class BankAccount {
    public double getBalance() {
        return balance;
    }

    private double balance=0;

    public void depositMoney(double amount){
        balance+=amount;
    }
}
