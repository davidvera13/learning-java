package io.warehouse13.learning;

import io.warehouse13.learning.bank.Bank;
import io.warehouse13.learning.bank.BankAccount;
import io.warehouse13.learning.bank.BankCustomer;
import io.warehouse13.learning.dto.TransactionDto;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank(314156);
        bank.addCustomer("Joe", 500, 10_000);

        BankCustomer joe = bank.getCustomer("000000010000000");
        System.out.println(joe);

        List<BankAccount> accounts = joe.getAccounts();
        System.out.println(accounts);

        System.out.println("After transactions");
        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING, 35)) {
            System.out.println(accounts);
        }
        if (bank.doTransaction(joe.getCustomerId(), BankAccount.AccountType.CHECKING, -535)) {
            System.out.println(accounts);
        }

        BankAccount checkingAccount = joe.getAccount(BankAccount.AccountType.CHECKING);
        var transactions = checkingAccount.getTransactions();
        // not in order ...
        transactions.forEach((k, v) -> System.out.println(k + " : " + v));

        // can we add directly a transaction ?
        // Apparently not: it's expected behavior
        // Exception in thread "main" java.lang.UnsupportedOperationException
        //	at java.base/java.util.ImmutableCollections.uoe(ImmutableCollections.java:142)
        //	at java.base/java.util.ImmutableCollections$AbstractImmutableMap.put(ImmutableCollections.java:1072)
        //	at io.warehouse13.learning.Main.main(Main.java:41)
        //transactions
        //        .put(3L, new TransactionDto(1, 1, Integer.parseInt(joe.getCustomerId()), 125));

        // can we temper single transaction ? It was possible... We modified the getTransactions form Bank Account
        //System.out.println("***********************************");
        //for (var transaction: transactions.values()) {
        //    transaction.setCustomerId(2);
        //    transaction.setAmount(100_000);
        //}
        //transactions.forEach((k, v) -> System.out.println(k + " : " + v));

        // can we clear the data ? We have no compile error but also no side effect
        checkingAccount.getTransactions().clear();
        System.out.println("***********************************");
        joe.getAccount(BankAccount.AccountType.CHECKING)
                .getTransactions()
                .forEach((k, v) -> System.out.println(k + " : " + v));


    }
}
