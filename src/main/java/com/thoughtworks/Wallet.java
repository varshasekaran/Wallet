package com.thoughtworks;

public class Wallet {
    private final Currency currency;
    private double previousBalance;
    private double currentBalance;

    public Wallet(double balance, Currency currency) {
        this.currentBalance=balance;
        this.previousBalance=balance;
        this.currency=currency;
    }

    public void addMoney(double money, Currency currency) {
        previousBalance=currentBalance;
        if(currency==this.currency)
            currentBalance+=money;
        currentBalance+=money*currency.getConversionFactor();
    }

    public double checkIfAdded(Currency currency) {
        return (currentBalance-previousBalance)/currency.getConversionFactor();
    }
}
