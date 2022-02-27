package com.thoughtworks;

import Exceptions.InsufficientBalanceException;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class WalletTest {

    @Test
    void shouldAddMoneyToWalletWhenDeposited() {
        Wallet wallet = new Wallet(100, Currency.RUPEE);

        double money = 10;
        wallet.addMoney(money, Currency.USD);

        assertThat(wallet.checkIfAdded(Currency.USD), is(equalTo(money)));
    }

    @Test
    void shouldWithdrawMoneyFromWalletWhenRequested() throws InsufficientBalanceException {
        Wallet wallet = new Wallet(1, Currency.RUPEE);
        double amountToWithdraw = 10;

        wallet.addMoney(1, Currency.USD);
        wallet.withdrawMoney(amountToWithdraw, Currency.RUPEE);

        assertThat(wallet.checkIfWithdrawn(Currency.RUPEE), is(equalTo(amountToWithdraw)));
    }

    @Test
    void shouldAbleToCheckBalanceInWalletWhenNeeded() throws InsufficientBalanceException {
        Wallet wallet = new Wallet(1, Currency.RUPEE);
        double expectedBalance = 1;

        wallet.addMoney(1, Currency.USD);
        wallet.withdrawMoney(1, Currency.USD);

        assertThat(wallet.calculateBalance(Currency.RUPEE), is(expectedBalance));
    }

}
