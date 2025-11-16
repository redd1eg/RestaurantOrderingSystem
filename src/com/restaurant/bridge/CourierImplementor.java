package com.restaurant.bridge;

public class CourierImplementor implements DeliveryImplementor {

    @Override
    public void deliver(int orderId) {
        System.out.println("Order " + orderId + " is being delivered by a courier.");
    }
}
