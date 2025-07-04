package main.models.core;

import main.exceptions.InsufficientBalanceException;

public class Customer {
    private String name;
    private double balance;

    public Customer(String name, double balance) {
        if (balance < 0) {
            throw new IllegalArgumentException("Balance cannot be negative.");
        }
        this.name = name;
        this.balance = balance;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }

    public boolean canPay(double amount) {
        return balance  >= amount;
    }

    public void pay(double amount) throws InsufficientBalanceException {
        if(!canPay(amount)) {
            throw new InsufficientBalanceException("Insufficient balance to pay " + amount + ".");
        }
        balance -= amount;
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", balance=" + balance + "]";
    }
}
