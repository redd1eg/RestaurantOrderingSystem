package com.restaurant.bridge;

public class SelfPickupImplementor implements DeliveryImplementor {

    @Override
    public void deliver(int orderId) {
        System.out.println("Order " + orderId + " is ready for self-pickup.");
    }
}
