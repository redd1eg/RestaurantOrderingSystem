package com.restaurant.facade;

import com.restaurant.factory.Meal;
import com.restaurant.factory.MealFactory;
import com.restaurant.strategy.PriceStrategy;
import com.restaurant.bridge.DeliveryType;
import com.restaurant.observer.Order;
import com.restaurant.observer.OrderObserver;

import java.util.UUID;
import java.util.logging.Logger;

public class RestaurantOrderFacade {
    private static final Logger logger = Logger.getLogger(RestaurantOrderFacade.class.getName());

    private final MealFactory mealFactory;
    private final PriceStrategy defaultStrategy;

    public RestaurantOrderFacade(MealFactory mealFactory, PriceStrategy defaultStrategy) {
        this.mealFactory = mealFactory;
        this.defaultStrategy = defaultStrategy;
    }

    public String placeOrder(String mealType, DeliveryType delivery, PriceStrategy strategy) {

        Meal meal = mealFactory.createMeal(mealType);
        logger.info("Created meal: " + meal.getName());

        double basePrice = meal.getPrice();
        double finalPrice = (strategy != null ? strategy : defaultStrategy).calculatePrice(basePrice);
        logger.info("Calculated final price: " + finalPrice);

        Order order = new Order(UUID.randomUUID().toString(), meal, finalPrice);

        order.addObserver((order1) -> logger.info("Observer: order " + order1.getId() + " changed status to " + order1.getStatus()));

        delivery.deliverOrder(order.getId());

        return order.getId();
    }
}
