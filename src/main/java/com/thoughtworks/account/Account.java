package com.thoughtworks.account;

/**
 * Created by David on 4/6/2015.
 */
public class Account {
    private int balance;

    public Account(int starting_balance) {
        balance = starting_balance;
    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void withdraw(int amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
