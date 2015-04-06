package com.thoughtworks.accountbalance;

import com.thoughtworks.account.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AccountTests {

    private Account accountWith100Dollars;
    private Account accountWith50Dollars;

    @Before
    public void setUp() {
        accountWith100Dollars = new Account(100);
        accountWith50Dollars = new Account(50);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        // when
        accountWith100Dollars.deposit(50);
        // then
        assertThat(accountWith100Dollars.balance(), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        // when
        accountWith100Dollars.withdraw(50);
        // then
        assertThat(accountWith100Dollars.balance(), is(50));

    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        // when
        accountWith50Dollars.withdraw(100);
        // then
        assertThat(accountWith50Dollars.balance(), is(50));
    }
}
