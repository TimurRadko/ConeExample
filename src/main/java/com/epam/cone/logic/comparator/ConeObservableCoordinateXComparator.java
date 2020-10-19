package com.epam.cone.logic.comparator;

import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;

import java.util.Comparator;

public class ConeObservableCoordinateXComparator implements Comparator<ConeObservable> {

    @Override
    public int compare(ConeObservable firstCone, ConeObservable secondCone) {
        Point firstPoint = firstCone.getPoint();
        Point secondPoint = secondCone.getPoint();
        Double firstPointCoordinateX = firstPoint.getCoordinateX();
        Double secondPointCoordinateX = secondPoint.getCoordinateX();
        return firstPointCoordinateX.compareTo(secondPointCoordinateX);
    }
}
