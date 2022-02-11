package com.techelevator.data;

public class BankAccount {

    public int balance;

    public BankAccount() {
        balance = 0;
    }

    public void depositMoney(int depositAmount) {
        balance+= (depositAmount * 100);
    }

    public void withdrawMoney(int withdrawAmount) {
        balance-= withdrawAmount;
    }

    public int balanceInPennies() {
        return balance;
    }

    public String balanceToString() {
        int currentBalance = balance;
        double balanceDouble = currentBalance / 100.00;
        String balanceString = "$" + String.format("%.2f", balanceDouble);
        return balanceString;
    }

    public String returnChangeInCoins(int balance) {
        int runningBalance = balance;

        int quartersToReturn = 0;
        int dimesToReturn = 0;
        int nickelsToReturn = 0;

        int quarter = 25;
        int dime = 10;
        int nickel = 5;

        while (runningBalance > 0) {
            if (runningBalance >= quarter) {
                quartersToReturn++;
                runningBalance -= quarter;
            } else if (runningBalance >= dime) {
                dimesToReturn++;
                runningBalance -= dime;
            } else if (runningBalance >= nickel) {
                nickelsToReturn++;
                runningBalance-=nickel;
            }
        }

        this.balance = 0;

        String promptChangeToUser = "Your change is " + quartersToReturn + " quarters, " + dimesToReturn +
                " dimes, " + "and " + nickelsToReturn + " nickels.";
        return promptChangeToUser;
    }

}
