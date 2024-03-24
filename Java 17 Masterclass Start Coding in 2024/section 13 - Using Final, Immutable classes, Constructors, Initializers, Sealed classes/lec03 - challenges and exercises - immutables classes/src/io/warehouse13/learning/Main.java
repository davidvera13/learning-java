package io.warehouse13.learning;

import io.warehouse13.learning.domain.BankAccount;
import io.warehouse13.learning.domain.BankCustomer;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        //BankAccount bankAccount = new BankAccount(BankAccount.AccountType.CHECKING, 500);
        //System.out.println(bankAccount);
        BankCustomer joe = new BankCustomer("Joe", 500.00, 10000.00);
        System.out.println(joe);

        List<BankAccount> accounts = joe.getAccounts();
        accounts.clear();
        System.out.println(joe);

        // removing public access to constructor avoid creating bank accounts
        // accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, 15000.00));
        // accounts.add(new BankAccount(BankAccount.AccountType.SAVINGS, 25000.00));
        // System.out.println(joe);
    }
}
