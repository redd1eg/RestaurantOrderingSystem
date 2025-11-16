package com.restaurant.bridge;

public class TakeawayDelivery extends DeliveryType {

    public TakeawayDelivery(DeliveryImplementor implementor) {
        super(implementor);
    }

    @Override
    public void deliverOrder(int orderId) {
        implementor.deliver(orderId);
        System.out.println("Takeaway selected.");
    }
}
