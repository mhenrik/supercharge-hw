package com.mhenrik.supercharge.homework.model;

import java.math.BigDecimal;

public class Account {

    private static final BigDecimal OPENING_BALANCE = BigDecimal.ZERO;
    private final User user;
    private BigDecimal balance;

    public Account(User user, BigDecimal balance) {
        this.user = user;
        this.balance = OPENING_BALANCE;
    }


    public void deposit(BigDecimal amount) throws IllegalArgumentException {
        if (checkBalance(amount)){
            this.balance = this.balance.add(amount);
        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    public void withdraw(BigDecimal amount) throws IllegalArgumentException {
        if (checkBalance(amount)){
            this.balance = this.balance.subtract(amount);
        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    public void transfer(Account anotherAccount, BigDecimal amount) throws IllegalArgumentException {
        if(checkBalance(amount) && anotherAccount != null){
            this.balance = this.balance.subtract(amount);
            anotherAccount.balance = anotherAccount.balance.add(amount);
        } else {
            throw new IllegalArgumentException("Invalid parameters!");
        }
    }

    private boolean checkBalance(BigDecimal amount){
        return amount.compareTo(BigDecimal.ZERO) > 0 && (this.getBalance().subtract(amount).compareTo(BigDecimal.ZERO) <= 0);
    }

    public User getUser() {
        return user;
    }

    public BigDecimal getBalance() {
        return balance;
    }
}
