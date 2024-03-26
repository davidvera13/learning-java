package io.warehouse13.learning.bank;


import io.warehouse13.learning.dto.TransactionDto;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankAccount {
    public enum AccountType {
        SAVINGS, CHECKING;
    }

    private final AccountType accountType;

    private double balance;
    private final Map<Long, TransactionDto> transactions = new LinkedHashMap<>();

    BankAccount(AccountType accountType, double balance) {
        this.accountType = accountType;
        this.balance = balance;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }


    //public Map<Long, TransactionDto> getTransactions() {
    //    return Map.copyOf(transactions);
    //}

    public Map<Long, String> getTransactions() {
        Map<Long, String> transactionsMap = new LinkedHashMap<>();
        for (var transaction: transactions.entrySet())
            transactionsMap.put(transaction.getKey(), transaction.getValue().toString());
        // we can directly return the map
        return transactionsMap;
    }

    // package private, any class in the package can call it
    void commitTransactions(
            int routingNumber,
            long transactionId,
            String customerId,
            double amount) {
        balance += amount;
        transactions.put(
                transactionId,
                new TransactionDto(routingNumber, transactionId, Integer.parseInt(customerId), amount));
    }

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }
}
