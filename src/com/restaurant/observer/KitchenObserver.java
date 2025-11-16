package com.restaurant.observer;

public class KitchenObserver implements Observer {

    @Override
    public void update(OrderStatus status) {
        System.out.println("[Kitchen] New status: " + status);
    }
}
