package com.restaurant.observer;

public class CustomerObserver implements Observer {

    @Override
    public void update(OrderStatus status) {
        System.out.println("[Customer] Your order is now: " + status);
    }
}
