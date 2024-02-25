package io.warehouse13.learning;

public class BankAccount {
    private String customerName;
    private String number;
    private double balance;
    private String email;
    private String phoneNumber;

    public BankAccount() {
        // using constructor with parameters
        this("John Doe", "0000-0000", 0.0, "nomail@mail.com", "+4400000000000");
        System.out.println("Empty constructor called");
    }

    public BankAccount(String customerName,
                       String number,
                       double balance,
                       String email,
                       String phoneNumber) {
        this.customerName = customerName;
        this.number = number;
        this.balance = balance;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount(String customerName, String email, String phoneNumber) {
        this(customerName, "000-007", 0.0, email, phoneNumber);
        // this.customerName = customerName;
        // this.email = email;
        // this.phoneNumber = phoneNumber;
    }

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
        if(amount > this.balance) {
            System.out.println("Not authorized");
        } else {
            this.balance -= amount;
            System.out.println("Withdrawal is : " + amount);
            System.out.println("New balance is now: " + this.balance);
        }

    }
}
