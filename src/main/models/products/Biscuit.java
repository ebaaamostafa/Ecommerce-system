package main.models.products;

import main.interfaces.Expirable;
import main.interfaces.Shippable;
import main.models.core.Product;

public class Biscuit extends Product implements Shippable, Expirable {
    private double weight;
    private boolean expired;

    public Biscuit(String name, double price, int quantity, double weight, boolean expired) {
        super(name, price, quantity);
        this.weight = weight;
        this.expired = expired;
    }

    @Override
    public boolean isExpired() {
        return expired;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isExpirable(){
        return true;
    }

    @Override
    public boolean isShippable() {
        return true;
    }
}
