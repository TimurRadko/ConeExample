package com.epam.cone.data.specification;

import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;

public class FirstQuadrangleSpecification implements Specification {

    @Override
    public boolean specified(ConeObservable cone) {
        Point point = cone.getPoint();
        double x = point.getCoordinateX();
        double y = point.getCoordinateY();
        double z = point.getCoordinateZ();

        return x > 0 && y > 0 && z > 0;
    }
}
