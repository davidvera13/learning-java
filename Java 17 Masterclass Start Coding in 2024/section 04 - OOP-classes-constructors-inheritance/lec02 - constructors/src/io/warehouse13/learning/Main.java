package io.warehouse13.learning;

import javax.crypto.spec.PSource;

public class Main {

    public static void main(String[] args) {
        // create a new class for bank account
        // create members of the class: account number, customer name, email, phone number and balance
        // create getters and setters
        // create 2 methods
        // 1. To allow the customer to deposit funds: this should increment the balance field
        // 2. To allow the customer to withdraw funds. This should deduct from the balance fields

        BankAccount johnAccount = new BankAccount();
        System.out.println("Name ? " + johnAccount.getCustomerName());
        System.out.println("Balance ? " + johnAccount.getBalance());
        johnAccount.withdrawal(2500);
        johnAccount.deposit(15000);
        johnAccount.withdrawal(2500);
        johnAccount.withdrawal(125);
        johnAccount.withdrawal(2500);

        System.out.println("****************************");
        // with constructor ?
        BankAccount paulAccount = new BankAccount("Paul", "1234-456", 1830.25, "mail@mail.com", "+33669430000" );
        paulAccount.withdrawal(2500);
        paulAccount.deposit(15000);
        paulAccount.withdrawal(2500);
        paulAccount.withdrawal(125);
        paulAccount.withdrawal(2500);

        System.out.println("****************************");
        BankAccount georges = new BankAccount("Georges", "georges@mail.com", "+33669000000");
        System.out.println(georges.getCustomerName());
        System.out.println(georges.getBalance());
        System.out.println(georges.getNumber());

        System.out.println("****************************");
        // create a new class VipCustomer
        // the class should contain 3 fields name, creditLimit and email address.
        // create 3 constructors
        // 1st constructor empty should call constructor with all params
        // 2nd constructor should pass on 2 values and set a default value for 3rd param
        // 3rd constructor should contain all params
        // create getters only

        VipCustomer vip1 = new VipCustomer();
        System.out.println(vip1.getName());
        System.out.println(vip1.getCreditLimit());
        System.out.println(vip1.getEmail());

        System.out.println("****************************");
        VipCustomer vip2 = new VipCustomer("Marc", "mc@mail.com");
        System.out.println(vip2.getName());
        System.out.println(vip2.getCreditLimit());
        System.out.println(vip2.getEmail());

        System.out.println("****************************");
        VipCustomer vip3 = new VipCustomer("Cresus", 250000, "dollar@mail.com");
        System.out.println(vip3.getName());
        System.out.println(vip3.getCreditLimit());
        System.out.println(vip3.getEmail());

    }
}
