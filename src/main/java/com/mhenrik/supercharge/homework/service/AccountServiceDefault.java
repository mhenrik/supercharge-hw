package com.mhenrik.supercharge.homework.service;

import com.mhenrik.supercharge.homework.model.Account;

import java.math.BigDecimal;

public class AccountServiceDefault implements AccountService {

    @Override
    public void deposit(Account account, BigDecimal amount) {
        account.deposit(amount);
    }

    @Override
    public void withdraw(Account account, BigDecimal amount) {
        account.withdraw(amount);
    }

    @Override
    public void transfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        fromAccount.transfer(toAccount, amount);
    }

    @Override
    public BigDecimal getBalance(Account account) {
        return account.getBalance();
    }
}
