package com.restaurant.observer;

import com.restaurant.factory.Meal;
import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {

    private List<Observer> observers = new ArrayList<>();

    private int orderId;
    private Meal meal;
    private OrderStatus status;

    public Order() {
        this.status = OrderStatus.CREATED;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Meal getMeal() {
        return meal;
    }

    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
        notifyObservers();
    }

    public OrderStatus getStatus() {
        return status;
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer obs : observers) {
            obs.update(status);
        }
    }
}
