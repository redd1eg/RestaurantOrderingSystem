package com.restaurant.decorator;

import com.restaurant.factory.Meal;

public class CheeseDecorator extends MealDecorator {

    public CheeseDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String getName() {
        return meal.getName() + " + Cheese";
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 1.25;
    }
}
