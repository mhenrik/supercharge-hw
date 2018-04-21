package com.mhenrik.supercharge.homework.service;

import com.mhenrik.supercharge.homework.model.Account;
import com.mhenrik.supercharge.homework.model.Transaction;
import com.mhenrik.supercharge.homework.model.TransactionType;

import java.time.LocalDate;
import java.util.List;

public interface HistoryService {

    List<Transaction> getHistory(Account account);

    List<Transaction> getHistory(Account account, TransactionType transactionType);

    List<Transaction> getHistory(Account account, LocalDate from, LocalDate to);

    List<Transaction> getHistory(Account account, LocalDate from, LocalDate to, TransactionType transactionType);


}
