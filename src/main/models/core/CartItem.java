package main.models.core;

import main.exceptions.InsufficientStockException;

public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        if (quantity <= 0){
            throw new IllegalArgumentException("Quantity of" + product.getName() + " cannot be negative.");
        }
        if(quantity > product.getQuantity()){
            throw new InsufficientStockException("Quantity of " + product.getName() + " exceeded stock limit.");
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

    public double getTotalCost(){
        return product.getPrice() * quantity;
    }

    @Override
    public String toString() {
        return quantity + "x " + product.getName() + " : " + getTotalCost() + " EGP";
    }
}

