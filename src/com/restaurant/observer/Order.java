package com.restaurant.observer;

import java.util.ArrayList;
import java.util.List;

public class Order implements Subject {

    private List<Observer> observers = new ArrayList<>();
    private OrderStatus status;

    public Order() {
        this.status = OrderStatus.CREATED;
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
