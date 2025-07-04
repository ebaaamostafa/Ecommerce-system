package main.models.core;

import main.exceptions.InsufficientStockException;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity <= 0){
            throw new IllegalArgumentException("Quantity cannot be negative.");
        }
        if(quantity > product.getQuantity()){
            throw new InsufficientStockException("Quantity exceeded stock limit.");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }
    public int getQuantity() {
        return quantity;
    }

    public double getTotal(){
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + "x " + product.toString() + " : " + getTotal() + " EGP";
    }
}

