package io.warehouse13.learning;

public class VipCustomer {
    private final String name;
    private final double creditLimit;
    private final String email;

    public VipCustomer(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public VipCustomer() {
        this("John Doe", 1000000.00, "jd@mail.com");
    }

    public VipCustomer(String name, String email) {
        this(name, 2500000, email);
        // this.name = name;
        // this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
