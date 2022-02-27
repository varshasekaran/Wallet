package com.thoughtworks;

import Exceptions.InsufficientBalanceException;

public class Wallet {
    private Currency currency;
    private double previousBalance;
    private double currentBalance;

    public Wallet(double balance, Currency currency) {
        if(currency==Currency.RUPEE)
        {
            this.currentBalance = balance;
            this.previousBalance = balance;
            this.currency = Currency.RUPEE;
        }
        if(currency==Currency.USD){
            this.currentBalance=balance*currency.getConversionFactor();
            this.previousBalance=balance* currency.getConversionFactor();
            this.currency=Currency.RUPEE;
        }
    }

    public void addMoney(double money, Currency currency) {
        previousBalance = currentBalance;
        currentBalance += money * currency.getConversionFactor();
    }

    public void withdrawMoney(double money, Currency currency) throws InsufficientBalanceException {
        if ((money * currency.getConversionFactor()) > currentBalance) {
            throw new InsufficientBalanceException("");
        }
        previousBalance = currentBalance;
        currentBalance -= money * currency.getConversionFactor();
    }

    public double checkIfAdded(Currency currency) {
        if(this.currency==currency)
            return currentBalance-previousBalance;
        return (currentBalance - previousBalance) / currency.getConversionFactor();
    }

    public double checkIfWithdrawn(Currency currency) {
        if(this.currency==currency)
            return previousBalance - currentBalance;
        return (previousBalance - currentBalance) / currency.getConversionFactor();
    }

    public double calculateBalance(Currency currency) {
        return currentBalance *= currency.getConversionFactor();
    }
}

