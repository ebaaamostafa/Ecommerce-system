package main;

import main.models.core.*;
import main.models.products.*;
import main.services.CheckoutService;
import main.services.ShippingService;

public class Main {
    public static void main(String[] args) {
        Cheese cheese = new Cheese("Cheese", 100, 5, 0.2, false);
        Biscuit biscuit = new Biscuit("Biscuits", 150, 3, 0.7, false);
        TV tv = new TV("TV", 10000, 3, 8.0);
        ScratchCard scratchCard = new ScratchCard("Scratch Card", 50, 10);

        Customer customer = new Customer("Ebaa", 1000);
        Cart cart = new Cart();

        try {
            cart.addItem(cheese, 2);
            cart.addItem(biscuit, 1);
            cart.addItem(scratchCard, 1);
            cart.addItem(tv, 1);

            CheckoutService checkout = new CheckoutService(new ShippingService());
            checkout.checkout(cart, customer);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
