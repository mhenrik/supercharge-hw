package com.mhenrik.supercharge.homework;

import com.mhenrik.supercharge.homework.model.Account;
import com.mhenrik.supercharge.homework.model.Transaction;
import com.mhenrik.supercharge.homework.model.TransactionType;
import com.mhenrik.supercharge.homework.model.User;
import com.mhenrik.supercharge.homework.service.HistoryService;
import com.mhenrik.supercharge.homework.service.HistoryServiceDefault;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Bank {

    public static void main(String[] args) {

        HistoryService historyService = new HistoryServiceDefault();

        User user1 = new User("user1");
        User user2 = new User("user2");

        Account account1 = new Account(user1);
        Account account2 = new Account(user2);

        account1.deposit(BigDecimal.valueOf(5000));
        account2.deposit(BigDecimal.valueOf(5000));

        account1.transfer(account2, BigDecimal.valueOf(1000));

        System.out.println(account1.getBalance());
        System.out.println(account2.getBalance());

        List<Transaction> transactions = historyService.getHistory(account1, LocalDate.of(2018,4,19), LocalDate.of(2018, 4, 28));

        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
