package com.mhenrik.supercharge.homework.service;

import com.mhenrik.supercharge.homework.model.Account;
import com.mhenrik.supercharge.homework.model.Transaction;
import com.mhenrik.supercharge.homework.model.TransactionType;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HistoryServiceDefault implements HistoryService {

    @Override
    public List<Transaction> getHistory(Account account) {
        return account.getTransactions();
    }

    @Override
    public List<Transaction> getHistory(Account account, TransactionType transactionType) {
        return account.getTransactions().stream()
                .filter(transaction -> transactionType.equals(transaction.getTransactionType()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getHistory(Account account, LocalDate from, LocalDate to) {
        List<LocalDate> range = getRange(from, to);
        boolean inRange = account.getTransactions().stream()
                .anyMatch(transaction -> range.contains(transaction.getTransactionDate().toLocalDate()));

        return account.getTransactions().stream()
                .filter(transaction -> inRange)
                .collect(Collectors.toList());
    }

    @Override
    public List<Transaction> getHistory(Account account, LocalDate from, LocalDate to, TransactionType transactionType) {
        List<LocalDate> range = getRange(from, to);
        boolean inRange = account.getTransactions().stream()
                .anyMatch(transaction -> range.contains(transaction.getTransactionDate().toLocalDate()));
        return account.getTransactions().stream()
                .filter(transaction -> inRange)
                .filter(transaction -> transactionType.equals(transaction.getTransactionType()))
                .collect(Collectors.toList());
    }

    private List<LocalDate> getRange(LocalDate from, LocalDate to) throws IllegalArgumentException {
        long numDaysBetween = ChronoUnit.DAYS.between(from, to);
        if (numDaysBetween <= 0) {
            throw new IllegalArgumentException("Invalid date!");
        } else {
            return IntStream.iterate(0, i -> i + 1)
                    .limit(numDaysBetween)
                    .mapToObj(from::plusDays)
                    .collect(Collectors.toList());
        }
    }
}
