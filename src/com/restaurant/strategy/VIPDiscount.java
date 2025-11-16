package com.restaurant.strategy;

public class VIPDiscount implements PriceStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.8;
    }
}
