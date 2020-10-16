package com.epam.cone.logic.specification;

import com.epam.cone.model.ConeObservable;

public class IdSpecification implements Specification {
    private final int id;

    public IdSpecification(int id) {
        this.id = id;
    }

    @Override
    public boolean specified(ConeObservable cone) {
        int coneId = cone.getId();
        return id == coneId;
    }
}
