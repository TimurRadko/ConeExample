package com.epam.cone.logic.specification;

import com.epam.cone.model.ConeObservable;

public class RadiusSpecification implements Specification {
    private final Double radius;

    public RadiusSpecification(Double radius) {
        this.radius = radius;
    }

    @Override
    public boolean specified(ConeObservable cone) {
        Double actualRadius = cone.getRadius();
        return radius.equals(actualRadius);
    }
}
