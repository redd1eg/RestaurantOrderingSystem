package com.restaurant.decorator;

import com.restaurant.factory.Meal;

public abstract class MealDecorator implements Meal {
    protected Meal meal;

    public MealDecorator(Meal meal) {
        this.meal = meal;
    }

    @Override
    public String getName() {
        return meal.getName();
    }

    @Override
    public double getPrice() {
        return meal.getPrice();
    }
}
