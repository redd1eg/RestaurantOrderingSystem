package com.restaurant.facade;

import com.restaurant.factory.Meal;
import com.restaurant.observer.Order;
import com.restaurant.observer.OrderStatus;
import com.restaurant.observer.CustomerObserver;
import com.restaurant.observer.KitchenObserver;
import com.restaurant.bridge.DeliveryType;

public class RestaurantOrderFacade {

        public int placeOrder(Meal meal, DeliveryType delivery) {

                // Создаем заказ (Observer)
                Order order = new Order();
                order.addObserver(new KitchenObserver());
                order.addObserver(new CustomerObserver());

                // Присваиваем ID заказа
                int orderId = (int)(Math.random() * 10000);
                order.setOrderId(orderId);
                order.setMeal(meal);

                // Статусы заказа
                order.setStatus(OrderStatus.COOKING);
                order.setStatus(OrderStatus.READY);
                order.setStatus(OrderStatus.COMPLETED);

                // Доставка (Bridge)
                delivery.deliverOrder(orderId);

                return orderId;
        }
}
