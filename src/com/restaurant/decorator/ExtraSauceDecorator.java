package com.restaurant.decorator;

import com.restaurant.factory.Meal;

public class ExtraSauceDecorator extends MealDecorator {

    public ExtraSauceDecorator(Meal meal) {
        super(meal);
    }

    @Override
    public String getName() {
        return meal.getName() + " + Extra Sauce";
    }

    @Override
    public double getPrice() {
        return meal.getPrice() + 0.80;
    }
}
