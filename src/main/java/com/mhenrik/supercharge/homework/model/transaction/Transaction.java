package com.mhenrik.supercharge.homework.model.transaction;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class Transaction {

    private TransactionType transactionType;
    private BigDecimal amount;
    private LocalDateTime transactionDate;
    private UUID id;
    private BigDecimal balance;

    public Transaction(TransactionType transactionType, BigDecimal amount, BigDecimal balance) {
        this.transactionType = transactionType;
        this.amount = amount;
        this.transactionDate = LocalDateTime.now();
        this.id = UUID.randomUUID();
        this.balance = balance;
    }


    public TransactionType getTransactionType() {
        return transactionType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public LocalDateTime getTransactionDate() {
        return transactionDate;
    }

    public UUID getId() {
        return id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionType=" + transactionType +
                ", amount=" + amount +
                ", transactionDate=" + transactionDate +
                ", id=" + id +
                ", balance=" + balance +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return transactionType == that.transactionType &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(transactionDate, that.transactionDate) &&
                Objects.equals(id, that.id) &&
                Objects.equals(balance, that.balance);
    }

    @Override
    public int hashCode() {

        return Objects.hash(transactionType, amount, transactionDate, id, balance);
    }
}
