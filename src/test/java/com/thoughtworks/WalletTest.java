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
        Wallet wallet = new Wallet(100, Currency.RUPEE);
        double money = 10;

        wallet.addMoney(money, Currency.USD);

        assertThat(wallet.checkIfAdded(Currency.USD), is(equalTo(money)));
    }

    @Test
    void shouldNotBeAbleToAddMoneyWhenAmountHasNegativeValue() {
        Wallet wallet = new Wallet(1, Currency.RUPEE);

        assertThrows(InvalidAmountException.class, () -> wallet.addMoney(-10,Currency.USD));
    }

    @Test
    void shouldWithdrawMoneyFromWalletWhenRequested() throws InsufficientBalanceException, InvalidAmountException {
        Wallet wallet = new Wallet(1, Currency.RUPEE);
        double amountToWithdraw = 10;

        wallet.addMoney(1, Currency.USD);
        wallet.withdrawMoney(amountToWithdraw, Currency.RUPEE);

        assertThat(wallet.checkIfWithdrawn(Currency.RUPEE), is(equalTo(amountToWithdraw)));
    }

    @Test
    void shouldNotBeAbleToWithdrawMoneyWhenAmountMoreThanAvailableBalance() {
        Wallet wallet = new Wallet(1, Currency.RUPEE);

        assertThrows(InsufficientBalanceException.class, () -> wallet.withdrawMoney(1, Currency.USD));
    }

    @Test
    void shouldAbleToCheckBalanceInWalletWhenNeeded() throws InsufficientBalanceException, InvalidAmountException {
        Wallet wallet = new Wallet(1, Currency.RUPEE);
        double expectedBalance = 1;

        wallet.addMoney(1, Currency.USD);
        wallet.withdrawMoney(1, Currency.USD);

        assertThat(wallet.calculateBalance(Currency.RUPEE), is(expectedBalance));
    }

}
