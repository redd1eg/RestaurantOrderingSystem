package com.restaurant.decorator;

import com.restaurant.factory.Meal;

public class MeatDecorator extends MealDecorator {

    public MeatDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String getName() {
        return meal.getName() + " + Meat";
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 1.75;
    }
}
