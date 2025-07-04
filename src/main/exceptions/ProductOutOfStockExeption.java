package main.exceptions;

public class ProductOutOfStockExeption extends RuntimeException {
    public ProductOutOfStockExeption(String message) {
        super(message);
    }
}
