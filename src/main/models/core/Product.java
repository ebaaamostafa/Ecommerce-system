package main.models.core;

public abstract class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        if (price < 0 || quantity < 0)
            throw new IllegalArgumentException("Price and quantity cannot be negative.");
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void consumeStock(int amount) {
        if (amount > quantity)
            throw new IllegalArgumentException("Insufficient stock to consume.");
        quantity -= amount;
    }

    public boolean isExpirable() { return false; }

    public boolean isShippable() { return false; }

    @Override
    public String toString() {
        return name + " (" + price + " EGP, " + quantity + " in stock)";
    }
}
