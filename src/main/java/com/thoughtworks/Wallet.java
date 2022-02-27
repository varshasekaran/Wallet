package com.thoughtworks;

import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidAmountException;

public class Wallet {
    private double currentBalance;

    public void addMoney(double money, Currency currency) throws InvalidAmountException {
        if(money<0) {
            throw new InvalidAmountException("");
        }
        currentBalance += money * currency.getConversionFactor();
    }

    public void withdrawMoney(double money, Currency currency) throws InsufficientBalanceException, InvalidAmountException {
        if ((money * currency.getConversionFactor()) > currentBalance) {
            throw new InsufficientBalanceException("");
        }
        if(money<0){
            throw new InvalidAmountException("");
        }
        currentBalance -= money * currency.getConversionFactor();
    }

    public double calculateBalance(Currency currency) {
        if(currency==Currency.RUPEE)
          return currentBalance *= currency.getConversionFactor();
        return currentBalance /= currency.getConversionFactor();
    }
}

