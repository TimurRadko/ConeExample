package com.epam.cone.logic.specification;

import com.epam.cone.model.ConeObservable;

public class HeightSpecification implements Specification {
    private final Double height;

    public HeightSpecification(Double height) {
        this.height = height;
    }

    @Override
    public boolean specified(ConeObservable cone) {
        Double actualHeight = cone.getHeight();
        return height.equals(actualHeight);
    }
}
