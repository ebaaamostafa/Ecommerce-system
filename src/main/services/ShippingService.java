package main.services;

import main.interfaces.Shippable;
import main.models.core.CartItem;

import java.util.List;

public class ShippingService {
    public void generateShippingNotice(List<CartItem> cartItems) {
        double totalWeight = 0;
        StringBuilder notice = new StringBuilder("** Shipment Notice: **\n");
        for (CartItem item : cartItems) {
            if (item.getProduct() instanceof Shippable) {
                Shippable shippableProduct = (Shippable) item.getProduct();
                double itemWeight = shippableProduct.getWeight() * item.getQuantity();
                totalWeight += itemWeight;

                notice.append(item.getQuantity())
                        .append("x ")
                        .append(item.getProduct().getName())
                        .append(" ")
                        .append(String.format("%.2f", itemWeight))
                        .append(" kg\n");
            }
        }

        if (totalWeight > 0) {
            notice.append("Total package weight: ")
                    .append(String.format("%.2f", totalWeight))
                    .append(" kg\n");
            System.out.println(notice);
        }
    }
}

