package main.services;

import main.exceptions.*;
import main.interfaces.Expirable;
import main.models.core.*;

import java.util.List;

public class CheckoutService {
    private final ShippingService shippingService;

    public CheckoutService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void checkout(Cart cart, Customer customer)
            throws EmptyCartException, InsufficientBalanceException,
            ExpiredProductException, InsufficientStockException {

        if (cart.isEmpty()) {
            throw new EmptyCartException("Cart is empty");
        }

        double totalCost = cart.getTotalCost();
        if (totalCost > customer.getBalance()) {
            throw new InsufficientBalanceException("Insufficient balance to pay for all cart items\n"
                    + "Your balance: " + customer.getBalance() + "\nTotal cost: " + totalCost);
        }

        List<CartItem> cartItems = cart.getItems();

        for (CartItem item : cartItems) {
            Product product = item.getProduct();

            if (product.getQuantity() < item.getQuantity()) {
                throw new InsufficientStockException("Not enough stock for: " + product.getName());
            }

            if (product instanceof Expirable && ((Expirable) product).isExpired()) {
                throw new ExpiredProductException("Product expired: " + product.getName());
            }

            product.consumeStock(item.getQuantity());
        }

        shippingService.generateShippingNotice(cartItems);

        customer.pay(totalCost);

        System.out.println("** Checkout receipt **");
        for (CartItem item : cartItems) {
            System.out.println(item);
        }
        System.out.println("----------------------");
        System.out.println("Subtotal: " + cart.getSubTotal());
        System.out.println("Shipping: " + cart.getShippingCost());
        System.out.println("Amount: " + totalCost);
    }
}
