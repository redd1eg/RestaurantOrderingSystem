package com.restaurant.bridge;

public class CourierDelivery extends DeliveryType {

    public CourierDelivery(DeliveryImplementor implementor) {
        super(implementor);
    }

    @Override
    public void deliverOrder(int orderId) {
        implementor.deliver(orderId);
        System.out.println("Courier delivery selected.");
    }
}
