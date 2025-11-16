package com.restaurant.app;

import com.restaurant.factory.Meal;
import com.restaurant.factory.MealFactory;

import com.restaurant.decorator.CheeseDecorator;
import com.restaurant.decorator.MeatDecorator;
import com.restaurant.decorator.ExtraSauceDecorator;

import com.restaurant.observer.*;

import com.restaurant.strategy.*;

import com.restaurant.bridge.*;
import com.restaurant.facade.RestaurantOrderFacade;

public class Main {
    public static void main(String[] args) {


        System.out.println("=== Meal with Toppings (Factory + Decorator) ===");
        MealFactory factory = new MealFactory();

        Meal meal = factory.createMeal("pizza");
        meal = new CheeseDecorator(meal);
        meal = new MeatDecorator(meal);
        meal = new ExtraSauceDecorator(meal);

        System.out.println("Your order: " + meal.getName());
        System.out.println("Price: $" + String.format("%.2f", meal.getPrice()));



        System.out.println("\n=== Order Status Notifications (Observer) ===");

        Order order = new Order();
        order.addObserver(new KitchenObserver());
        order.addObserver(new CustomerObserver());

        order.setStatus(OrderStatus.COOKING);
        order.setStatus(OrderStatus.READY);
        order.setStatus(OrderStatus.COMPLETED);



        System.out.println("\n=== Price with Discount Strategies (Strategy) ===");

        PriceCalculator calculator = new PriceCalculator();

        calculator.setStrategy(new NoDiscount());
        System.out.println("No discount: $" +
                String.format("%.2f", calculator.calculate(meal.getPrice())));

        calculator.setStrategy(new TenPercentDiscount());
        System.out.println("10% discount: $" +
                String.format("%.2f", calculator.calculate(meal.getPrice())));

        calculator.setStrategy(new VIPDiscount());
        System.out.println("VIP discount (20%): $" +
                String.format("%.2f", calculator.calculate(meal.getPrice())));



        System.out.println("\n=== Delivery Options (Bridge) ===");

        DeliveryType dineIn = new DineInDelivery(new TableDeliveryImplementor());
        DeliveryType takeaway = new TakeawayDelivery(new SelfPickupImplementor());
        DeliveryType courier = new CourierDelivery(new CourierImplementor());

        System.out.println("Dine-in delivery:");
        dineIn.deliverOrder(101);

        System.out.println("\nTakeaway delivery:");
        takeaway.deliverOrder(102);

        System.out.println("\nCourier delivery:");
        courier.deliverOrder(103);



        System.out.println("\n=== Final Order via Facade ===");

        RestaurantOrderFacade facade = new RestaurantOrderFacade();

        int finalOrderId = facade.placeOrder(meal, courier);

        System.out.println("\nOrder completed. Final ID = " + finalOrderId);
    }
}
