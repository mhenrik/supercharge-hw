package com.mhenrik.supercharge.homework.model.transaction;

import com.mhenrik.supercharge.homework.model.user.User;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Account {

    private static final BigDecimal OPENING_BALANCE = BigDecimal.ZERO;
    private final User user;
    private BigDecimal balance;
    private List<Transaction> transactions;

    public Account(User user) {
        this.user = user;
        this.balance = OPENING_BALANCE;
        this.transactions = new ArrayList<>();
    }


    public void deposit(BigDecimal amount) throws IllegalArgumentException {
        if (checkAmount(amount)) {
            this.balance = this.balance.add(amount);
            Transaction transaction = new Transaction(TransactionType.DEPOSIT, amount, this.balance);
            this.addToTransactions(transaction);
        } else {
            throw new IllegalArgumentException("You can't deposit less than 0!");
        }

    }

    public void withdraw(BigDecimal amount) throws IllegalArgumentException {
        if (checkAmount(amount) && checkBalance(amount)){
            this.balance = this.balance.subtract(amount);
            Transaction transaction = new Transaction(TransactionType.WITHDRAWAL, amount, this.balance);
            this.addToTransactions(transaction);
        } else {
            throw new IllegalArgumentException("Invalid amount!");
        }

    }

    public void transfer(Account anotherAccount, BigDecimal amount) throws IllegalArgumentException {
        if (checkBalance(amount) && checkAmount(amount) && anotherAccount != null){
            this.balance = this.balance.subtract(amount);
            anotherAccount.balance = anotherAccount.balance.add(amount);
            Transaction transaction1 = new Transaction(TransactionType.TRANSFER, amount, this.getBalance());
            Transaction transaction2 = new Transaction(TransactionType.TRANSFER, amount, anotherAccount.getBalance());
            this.addToTransactions(transaction1);
            anotherAccount.addToTransactions(transaction2);
        } else {
            throw new IllegalArgumentException("Invalid argument!");
        }

    }

    private void addToTransactions(Transaction transaction){
        this.transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    private boolean checkAmount(BigDecimal amount){
        if(amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }
        return true;
    }

    private boolean checkBalance(BigDecimal amount){
        if(this.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }
        return true;
    }
}
