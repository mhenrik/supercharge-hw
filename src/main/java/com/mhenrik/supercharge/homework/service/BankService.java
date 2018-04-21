package com.mhenrik.supercharge.homework.service;

import com.mhenrik.supercharge.homework.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class BankService implements HistoryService, AccountService {

    private AccountService accountService;
    private HistoryService historyService;
    private TransactionFormatter transactionFormatter;

    public BankService() {
        this.accountService = new AccountServiceDefault();
        this.historyService = new HistoryServiceDefault();
        this.transactionFormatter = new TransactionFormatter();
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
        transactionFormatter.printBalance(account);
        return accountService.getBalance(account);
    }

    @Override
    public List<Transaction> getHistory(Account account) {
        transactionFormatter.printTransaction(account, historyService.getHistory(account));
        return historyService.getHistory(account);
    }

    @Override
    public List<Transaction> getHistory(Account account, TransactionType transactionType) {
        transactionFormatter.printTransaction(account, historyService.getHistory(account, transactionType));
        return historyService.getHistory(account, transactionType);
    }

    @Override
    public List<Transaction> getHistory(Account account, LocalDate from, LocalDate to) {
        transactionFormatter.printTransaction(account, historyService.getHistory(account, from, to));
        return historyService.getHistory(account, from, to);
    }

    @Override
    public List<Transaction> getHistory(Account account, LocalDate from, LocalDate to, TransactionType transactionType) {
        transactionFormatter.printTransaction(account, historyService.getHistory(account, from, to, transactionType));
        return historyService.getHistory(account, from, to, transactionType);
    }
}
