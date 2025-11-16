package com.restaurant.strategy;

public class PriceCalculator {
    private PriceStrategy strategy;

    public void setStrategy(PriceStrategy strategy) {
        this.strategy = strategy;
    }

    public double calculate(double basePrice) {
        return strategy.calculatePrice(basePrice);
    }
}
