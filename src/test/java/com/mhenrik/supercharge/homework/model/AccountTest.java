package com.mhenrik.supercharge.homework.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class AccountTest {

    private Account account;

    private Account account2;

    @Mock
    private User user;

    @Mock
    private User user2;

    @BeforeEach
    public void setup(){
        user = mock(User.class);
        account = new Account(user);
        account2 = new Account(user2);
    }

    @Test
    public void ifAmountIsLessThanZeroThenThrowIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(BigDecimal.valueOf(-1)));
    }

    @Test
    public void ifAmountIsZeroThenThrowIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.deposit(BigDecimal.valueOf(0)));
    }

    @Test
    public void ifAmountIsInTheDeposit(){
        account.deposit(BigDecimal.valueOf(1000));
        assertEquals(account.getBalance(), BigDecimal.valueOf(1000));
    }

    @Test
    public void ifWithdrawLessThanZeroThenThrowIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(-1)));
    }

    @Test
    public void ifWithdrawMoreThanBalanceThenThrowIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(1000)));
    }

    @Test
    public void ifWithdrawChangesBalance() {
        account.deposit(BigDecimal.valueOf(2000));
        account.withdraw(BigDecimal.valueOf(1000));
        assertEquals(account.getBalance(), BigDecimal.valueOf(1000));
    }

    @Test
    public void ifTransferLessThanZeroThenThrowIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(-1)));
    }

    @Test
    public void ifTransferThanBalanceThenThrowIllegalArgumentException() throws IllegalArgumentException {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(BigDecimal.valueOf(1000)));
    }

    @Test
    public void ifTransferChangesBalanceForSenderAccount() {

        account.deposit(BigDecimal.valueOf(2000));
        account.transfer(account2, BigDecimal.valueOf(1000));
        assertEquals(account.getBalance(), BigDecimal.valueOf(1000));
    }

    @Test
    public void ifTransferChangesBalanceForReceiverAccount() {

        account.deposit(BigDecimal.valueOf(2000));
        account.transfer(account2, BigDecimal.valueOf(1000));
        assertEquals(account2.getBalance(), BigDecimal.valueOf(1000));
    }


}