package main.models.products;

import main.interfaces.Shippable;
import main.models.core.Product;

public class TV extends Product implements Shippable{
    private double weight;

    public TV(String name, double price, int quantity, double weight) {
        super(name, price, quantity);
        this.weight = weight;
    }


    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public boolean isShippable() {
        return true;
    }

}
