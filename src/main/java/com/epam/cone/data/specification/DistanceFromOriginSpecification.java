package com.epam.cone.data.specification;

import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;

public class DistanceFromOriginSpecification implements Specification {
    private final double defaultDistance;

    public DistanceFromOriginSpecification(double defaultDistance) {
        this.defaultDistance = defaultDistance;
    }

    @Override
    public boolean specified(ConeObservable cone) {
        Point point = cone.getPoint();
        double distance = distanceFromOrigin(point);
        return distance > defaultDistance;
    }

    private double distanceFromOrigin(Point point) {
        double x = point.getCoordinateX();
        double y = point.getCoordinateY();
        double z = point.getCoordinateZ();
        return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
    }
}
