package com.restaurant.bridge;

public class TableDeliveryImplementor implements DeliveryImplementor {

    @Override
    public void deliver(int orderId) {
        System.out.println("Order " + orderId + " will be served to the table.");
    }
}
