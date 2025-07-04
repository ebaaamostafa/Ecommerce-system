package main.models.core;

import main.exceptions.ExpiredProductException;
import main.exceptions.InsufficientStockException;
import main.interfaces.Expirable;
import main.interfaces.Shippable;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<CartItem> items;

    public Cart() {
        items = new ArrayList<CartItem>();
    }

    public void addItem(Product product, int quantity)
            throws IllegalArgumentException, InsufficientStockException, ExpiredProductException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity of " + product.getName() + " must be greater than 0");
        }
        if (quantity > product.getQuantity()) {
            throw new InsufficientStockException("Quantity of " + product.getName() + " exceeds available stock");
        }
        if (product instanceof Expirable) {
            if (((Expirable) product).isExpired()) {
                throw new ExpiredProductException("Product (" + product.getName() + ") is expired");
            }
        }
        items.add(new CartItem(product, quantity));
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public double getShippingCost() {
        double totalWeight = 0;
        for (CartItem item : items) {
            if (item.getProduct() instanceof Shippable) {
                double weight = ((Shippable)item.getProduct()).getWeight();
                totalWeight += weight * item.getQuantity();
            }
        }
        return totalWeight * 50; // assuming a shipping cost of 50 EGP/KG
    }

    public double getSubTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getProduct().getPrice() * item.getQuantity();
        }
        return total;
    }

    public double getTotalCost() {
        return getSubTotal() + getShippingCost();
    }

    public List<CartItem> getItems() {
        return items;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (CartItem item : items) {
            str.append(item.toString()).append('\n');
        }
        return str.toString();
    }

}
