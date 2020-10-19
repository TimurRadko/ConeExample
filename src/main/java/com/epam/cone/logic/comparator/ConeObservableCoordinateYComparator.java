package com.epam.cone.logic.comparator;

import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;

import java.util.Comparator;

public class ConeObservableCoordinateYComparator implements Comparator<ConeObservable> {

    @Override
    public int compare(ConeObservable firstCone, ConeObservable secondCone) {
        Point firstPoint = firstCone.getPoint();
        Point secondPoint = secondCone.getPoint();
        Double firstPointCoordinateY = firstPoint.getCoordinateY();
        Double secondPointCoordinateY = secondPoint.getCoordinateY();
        return firstPointCoordinateY.compareTo(secondPointCoordinateY);
    }
}
