package com.restaurant.factory;

public class Pasta implements Meal {
    @Override
    public String getName() {
        return "Pasta";
    }

    @Override
    public double getPrice() {
        return 7.25;
    }
}
