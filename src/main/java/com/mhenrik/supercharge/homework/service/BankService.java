package com.mhenrik.supercharge.homework.service;

import com.mhenrik.supercharge.homework.model.Account;
import com.mhenrik.supercharge.homework.model.Transaction;
import com.mhenrik.supercharge.homework.model.TransactionType;
import com.mhenrik.supercharge.homework.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BankService implements HistoryService, AccountService {

    private AccountService accountService;
    private HistoryService historyService;

    public BankService() {
        this.accountService = new AccountServiceDefault();
        this.historyService = new HistoryServiceDefault();
    }

    public Account createAccount(User user){
        return new Account(user);
    }

    @Override
    public void deposit(Account account, BigDecimal amount) {
        accountService.deposit(account, amount);
    }

    @Override
    public void withdraw(Account account, BigDecimal amount) {
        accountService.withdraw(account, amount);
    }

    @Override
    public void transfer(Account fromAccount, Account toAccount, BigDecimal amount) {
        accountService.transfer(fromAccount, toAccount, amount);

    }

    @Override
    public BigDecimal getBalance(Account account) {
        return accountService.getBalance(account);
    }

    @Override
    public List<Transaction> getHistory(Account account) {
        return historyService.getHistory(account);
    }

    @Override
    public List<Transaction> getHistory(Account account, TransactionType transactionType) {
        return historyService.getHistory(account, transactionType);
    }

    @Override
    public List<Transaction> getHistory(Account account, LocalDate from, LocalDate to) {
        return historyService.getHistory(account, from, to);
    }

    @Override
    public List<Transaction> getHistory(Account account, LocalDate from, LocalDate to, TransactionType transactionType) {
        return historyService.getHistory(account, from, to, transactionType);
    }
}
