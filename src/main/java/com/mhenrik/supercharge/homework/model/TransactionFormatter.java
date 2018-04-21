package com.mhenrik.supercharge.homework.model;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TransactionFormatter {

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public void printTransaction(Account account, List<Transaction> transactions){
        System.out.printf("Transaction informations about account holder %s: \n", account.getUser().getName());
        for (Transaction transaction : transactions) {
            System.out.printf("Transaction type is %s with an amount of %f. Transaction id is %s. Transaction date is %s. The remaining balance is %f \n",
                    transaction.getTransactionType(), transaction.getAmount(), transaction.getId(), transaction.getTransactionDate().format(formatter), transaction.getBalance());
        }
    }

    public void printBalance(Account account){
        System.out.printf("Account holder %s's balance is %f\n", account.getUser().getName(), account.getBalance());
    }
}
