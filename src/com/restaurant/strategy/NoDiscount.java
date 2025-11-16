package com.restaurant.strategy;

public class NoDiscount implements PriceStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice;
    }
}
