package io.warehouse13.learning.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BankCustomer {
    private static int lastCustomerId=10_000_000;
    private final int customerId;
    private final String name;
    private final List<BankAccount> accounts  = new ArrayList<>();

    public BankCustomer(String name, double checkingAmount, double savingAmount) {
        this.name = name;
        this.customerId = lastCustomerId++;
        accounts.add(new BankAccount(BankAccount.AccountType.CHECKING, checkingAmount));
        accounts.add(new BankAccount(BankAccount.AccountType.SAVINGS, savingAmount));
    }

    public String getName() {
        return name;
    }

    public List<BankAccount> getAccounts() {
        return new ArrayList<>(accounts);
    }

    @Override
    public String toString() {
        String[] accountString = new String[accounts.size()];
        Arrays.setAll(accountString, i ->accounts.get(i).toString());
        return "Customer: %s (id: %015d)%n\t%s%n".formatted(name, customerId, String.join("\n\t", accountString));
    }
}
