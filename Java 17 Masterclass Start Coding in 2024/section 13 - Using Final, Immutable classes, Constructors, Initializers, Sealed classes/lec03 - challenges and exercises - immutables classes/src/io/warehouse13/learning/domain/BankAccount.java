package io.warehouse13.learning.domain;




public class BankAccount {
    public enum AccountType {
        SAVINGS, CHECKING;
    }

    private final AccountType accountType;
    private final double balance;

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

    @Override
    public String toString() {
        return "%s $%.2f".formatted(accountType, balance);
    }
}
