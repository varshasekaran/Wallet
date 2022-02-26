package com.thoughtworks;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WalletTest {

    @Test
    void shouldAddMoneyToBalanceWhenDeposited() {
        Wallet wallet = new Wallet(100, Currency.RUPEE);

        double money = 10;
        wallet.addMoney(money, Currency.USD);

        assertThat(wallet.checkIfAdded(Currency.USD), is(equalTo(money)));
    }

    @Test
    void shouldWithdrawMoneyWhenRequested() {
        Wallet wallet = new Wallet(100, Currency.RUPEE);

        double amountToWithdraw = 500;
        wallet.addMoney(10, Currency.USD);
        wallet.withdrawMoney(amountToWithdraw, Currency.RUPEE);

        assertThat(wallet.checkIfWithdrawn(Currency.RUPEE), is(equalTo(amountToWithdraw)));
    }

}
