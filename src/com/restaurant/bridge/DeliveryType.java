package com.restaurant.bridge;

public abstract class DeliveryType {
    protected DeliveryImplementor implementor;

    public DeliveryType(DeliveryImplementor implementor) {
        this.implementor = implementor;
    }

    public abstract void deliverOrder(int orderId);
}
