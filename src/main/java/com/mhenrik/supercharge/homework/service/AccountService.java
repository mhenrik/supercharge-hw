package com.mhenrik.supercharge.homework.service;

import com.mhenrik.supercharge.homework.model.Account;

import java.math.BigDecimal;

public interface AccountService {

    void deposit(Account account, BigDecimal amount);

    void withdraw(Account account, BigDecimal amount);

    void transfer(Account fromAccount, Account toAccount, BigDecimal amount);

    BigDecimal getBalance(Account account);
}
