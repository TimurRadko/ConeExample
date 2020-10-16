package com.epam.cone.model;

import java.util.ArrayList;
import java.util.List;

public class ConeObservable extends Cone implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    private final int id;

    public ConeObservable(Cone cone, int id) {
        super(cone.getPoint(), cone.getRadius(), cone.getHeight());
        this.id = id;
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
    public String toString() {
        return String.format("The id: %s. ", getId()) + super.toString();
    }
}
