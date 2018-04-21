package com.mhenrik.supercharge.homework.service.history;

import com.mhenrik.supercharge.homework.model.transaction.Account;
import com.mhenrik.supercharge.homework.model.transaction.Transaction;
import com.mhenrik.supercharge.homework.model.transaction.TransactionType;

import java.time.LocalDate;
import java.util.List;

public interface HistoryService {

    List<Transaction> getHistory(Account account);

    List<Transaction> getHistory(Account account, TransactionType transactionType);

    List<Transaction> getHistory(Account account, LocalDate from, LocalDate to);

    List<Transaction> getHistory(Account account, LocalDate from, LocalDate to, TransactionType transactionType);


}
