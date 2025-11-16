package com.restaurant.app;

import com.restaurant.factory.Meal;
import com.restaurant.factory.MealFactory;
import com.restaurant.decorator.CheeseDecorator;
import com.restaurant.decorator.MeatDecorator;
import com.restaurant.decorator.ExtraSauceDecorator;
import com.restaurant.observer.Order;
import com.restaurant.observer.OrderStatus;
import com.restaurant.observer.KitchenObserver;
import com.restaurant.observer.CustomerObserver;

public class Main {
    public static void main(String[] args) {

        // ====== Factory + Decorator ======
        System.out.println("=== Meal with Toppings ===");
        MealFactory factory = new MealFactory();

        Meal meal = factory.createMeal("pizza");
        meal = new CheeseDecorator(meal);
        meal = new MeatDecorator(meal);
        meal = new ExtraSauceDecorator(meal);

        System.out.println("Your order: " + meal.getName());
        System.out.println("Total price: $" + String.format("%.2f", meal.getPrice()));

        // ====== Observer ======
        System.out.println("\n=== Order status notifications ===");

        Order order = new Order();

        order.addObserver(new KitchenObserver());
        order.addObserver(new CustomerObserver());

        order.setStatus(OrderStatus.COOKING);
        order.setStatus(OrderStatus.READY);
        order.setStatus(OrderStatus.COMPLETED);
    }
}
