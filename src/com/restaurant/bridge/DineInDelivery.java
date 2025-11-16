package com.restaurant.bridge;

public class DineInDelivery extends DeliveryType {

    public DineInDelivery(DeliveryImplementor implementor) {
        super(implementor);
    }

    @Override
    public void deliverOrder(int orderId) {
        implementor.deliver(orderId);
        System.out.println("Dine-in service selected.");
    }
}
