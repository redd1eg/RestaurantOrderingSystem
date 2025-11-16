package com.restaurant.factory;

public class MealFactory {

    public Meal createMeal(String type) {
        return switch (type.toLowerCase()) {
            case "pizza" -> new Pizza();
            case "burger" -> new Burger();
            case "pasta"  -> new Pasta();
            default -> null;
        };
    }
}
