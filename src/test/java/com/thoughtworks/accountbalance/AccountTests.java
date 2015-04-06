package com.thoughtworks.accountbalance;

import com.thoughtworks.account.Account;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

public class AccountTests {

    private Account account;

    @Before
    public void setUp() {
        account = new Account(100);
    }

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
        // when
        account.deposit(50);
        // then
        assertThat(account.balance(), is(equalTo(150)));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        // when
        account.withdraw(50);
        // then
        assertThat(account.balance(), is(equalTo(50)));

    }

//    @Test
//    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
//
//    }
}
