package com.epam.cone.data.specification;

import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;

public class PointSpecification implements Specification {
    private final Point point;

    public PointSpecification(Point point) {
        this.point = point;
    }

    @Override
    public boolean specified(ConeObservable cone) {
        Point actualPoint = cone.getPoint();
        return point.equals(actualPoint);
    }


}
