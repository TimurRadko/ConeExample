package com.epam.cone.model;

import java.util.ArrayList;
import java.util.List;

public class ConeObservable extends Cone implements Observable {
    private final List<Observer> observers = new ArrayList<>();
    private static final IdGenerator ID_GENERATOR = new IdGenerator(1);
    private final int id;

    public ConeObservable(Cone cone) {
        super(cone.getPoint(), cone.getRadius(), cone.getHeight());
        id = ID_GENERATOR.getId();
    }

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
