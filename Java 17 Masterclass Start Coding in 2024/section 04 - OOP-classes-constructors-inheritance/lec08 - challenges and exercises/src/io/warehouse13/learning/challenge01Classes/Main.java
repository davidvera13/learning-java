package io.warehouse13.learning.challenge01Classes;

public class Main {
    public static void main(String[] args) {
        BankAccount walterAccount = new BankAccount();
        walterAccount.setCustomerName("Walter");
        walterAccount.setNumber("123FR345");
        walterAccount.setBalance(12435);
        walterAccount.setEmail("me@me.com");

        System.out.println("Name ? " + walterAccount.getCustomerName());
        System.out.println("Balance ? " + walterAccount.getBalance());
        walterAccount.withdrawal(2500);
        walterAccount.deposit(15000);
        walterAccount.withdrawal(2500);
        walterAccount.withdrawal(2500);
        walterAccount.withdrawal(122500);

    }
}
