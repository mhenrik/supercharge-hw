package com.mhenrik.supercharge.homework;

import com.mhenrik.supercharge.homework.model.Account;
import com.mhenrik.supercharge.homework.model.TransactionType;
import com.mhenrik.supercharge.homework.model.User;
import com.mhenrik.supercharge.homework.service.BankService;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Bank {

    public static void main(String[] args) {

        User user1 = new User("user1");
        User user2 = new User("user2");

        BankService bankService = new BankService();

        Account account1 = bankService.createAccount(user1);
        Account account2 = bankService.createAccount(user2);

        bankService.deposit(account1, BigDecimal.valueOf(5000));
        bankService.deposit(account2, BigDecimal.valueOf(5000));

        bankService.withdraw(account1, BigDecimal.valueOf(1000));
        bankService.withdraw(account2, BigDecimal.valueOf(2000));

        bankService.transfer(account1, account2, BigDecimal.valueOf(2000));
        bankService.transfer(account2, account1, BigDecimal.valueOf(1000));

        bankService.getBalance(account1);
        bankService.getBalance(account2);


        bankService.getHistory(account1, LocalDate.of(2018,4,19), LocalDate.of(2018, 4, 28));
        bankService.getHistory(account2, TransactionType.TRANSFER);
    }
}
