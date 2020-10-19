package com.epam.cone.model;

public class IdGenerator {
    private int initialValue;

    public IdGenerator(int initialValue) {
        this.initialValue = initialValue;
    }

    public final int getId() {
        return initialValue++;
    }
}
