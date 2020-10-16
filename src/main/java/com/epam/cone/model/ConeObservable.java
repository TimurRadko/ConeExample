package com.epam.cone.model;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class ConeObservable extends Cone implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private final int id;

    public ConeObservable(Cone cone) {
        super(cone.getPoint(), cone.getRadius(), cone.getHeight());
        id = COUNTER.getAndIncrement();
    }

    public int getId() {
        return id;
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
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    @Override
    public void setPoint(Point point) {
        super.setPoint(point);
        notifyObservers();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        notifyObservers();
    }

    @Override
    public void setRadius(double radius) {
        super.setRadius(radius);
        notifyObservers();
    }

    @Override
    public String toString() {
        return String.format("The id: %s. ", getId()) + super.toString();
    }
}
