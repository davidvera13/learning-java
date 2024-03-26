package io.warehouse13.learning.bank;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    public final int routingNumber;
    private long lastTransactionId = 1;
    // customer id, customer
    private final Map<String, BankCustomer> customers;

    public Bank(int routingNumber) {
        this.routingNumber = routingNumber;
        this.customers = new HashMap<>();
    }

    public BankCustomer getCustomer(String customerId) {
        return customers.get(customerId);
    }

    public void addCustomer(
            String name,
            double checkingInitialDeposit,
            double savingsInitialDeposit) {
        BankCustomer customer =
                new BankCustomer(name, checkingInitialDeposit, savingsInitialDeposit);
        customers.put(customer.getCustomerId(), customer);
    }

    public boolean doTransaction(
            String customerId,
            BankAccount.AccountType accountType,
            double amount) {
        BankCustomer customer = customers.get(customerId);
        if (customer != null) {
            BankAccount account = customer.getAccount(accountType);
            if(account != null) {
                if (account.getBalance() + amount < 0) {
                    System.out.println("Insufficient funds");
                } else {
                    account.commitTransactions(
                            routingNumber, lastTransactionId++, customerId, amount);
                    return true;
                }
            }
        } else {
            System.out.println("No customer found with id:" + customerId);
        }
        return false;
    }


}
