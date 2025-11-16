package com.restaurant.factory;

public class Burger implements Meal {
    @Override
    public String getName() {
        return "Burger";
    }

    @Override
    public double getPrice() {
        return 5.49;
    }
}
