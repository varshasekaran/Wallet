package com.thoughtworks;

import Exceptions.InsufficientBalanceException;
import Exceptions.InvalidAmountException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    @Test
    void shouldAddMoneyToWalletWhenDeposited() throws InvalidAmountException {
        Wallet wallet = new Wallet();
        double expectedBalance = 748.5;

        wallet.addMoney(10, Currency.USD);
        double actualBalance = wallet.calculateBalance(Currency.RUPEE);

        assertThat(actualBalance, is(equalTo(expectedBalance)));
    }

    @Test
    void shouldNotBeAbleToAddMoneyWhenAmountHasNegativeValue() {
        Wallet wallet = new Wallet();

        assertThrows(InvalidAmountException.class, () -> wallet.addMoney(-10,Currency.USD));
    }

    @Test
    void shouldWithdrawMoneyFromWalletWhenRequested() throws InsufficientBalanceException, InvalidAmountException {
        Wallet wallet = new Wallet();
        double expectedBalance = 64.85;

        wallet.addMoney(1, Currency.USD);
        wallet.withdrawMoney(10, Currency.RUPEE);
        double actualBalance = wallet.calculateBalance(Currency.RUPEE);

        assertThat(actualBalance, is(equalTo(expectedBalance)));
    }

    @Test
    void shouldNotBeAbleToWithdrawMoneyWhenAmountIsMoreThanAvailableBalance() {
        Wallet wallet = new Wallet();

        assertThrows(InsufficientBalanceException.class, () -> wallet.withdrawMoney(1, Currency.USD));
    }

    @Test
    void shouldAbleToCheckBalanceInWalletWhenNeeded() throws InsufficientBalanceException, InvalidAmountException {
        Wallet wallet = new Wallet();
        double expectedBalance = 1;

        wallet.addMoney(2, Currency.USD);
        wallet.withdrawMoney(1, Currency.USD);

        assertThat(wallet.calculateBalance(Currency.USD), is(expectedBalance));
    }

}
