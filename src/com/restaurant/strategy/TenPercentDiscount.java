package com.restaurant.strategy;

public class TenPercentDiscount implements PriceStrategy {
    @Override
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9;
    }
}
