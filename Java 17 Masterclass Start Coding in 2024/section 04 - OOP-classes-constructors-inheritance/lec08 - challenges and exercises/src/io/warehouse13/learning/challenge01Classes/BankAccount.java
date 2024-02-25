package io.warehouse13.learning.challenge01Classes;

public class BankAccount {
    private String customerName;
    private String number;
    private double balance;
    private String email;
    private String phoneNumber;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("Deposit done. New balance is now: " + this.balance);
    }

    public void withdrawal(double amount) {
        if (amount > this.balance) {
            System.out.println("Not authorized");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal is : " + amount);
            System.out.println("New balance is now: " + this.balance);
        }

    }
}