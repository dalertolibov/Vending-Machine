package com.techelevator;

public class CustomerAccount {
    double amount;
    double balance=0;

    public void deposit(double amount){
        balance+=amount;
    }
    public double getBalance(){
        return balance;
    }
}
