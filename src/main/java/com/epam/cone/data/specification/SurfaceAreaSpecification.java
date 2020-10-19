package com.epam.cone.data.specification;

import com.epam.cone.logic.ConeCalculator;
import com.epam.cone.model.ConeObservable;

public class SurfaceAreaSpecification implements Specification {
    private final double minSurfaceArea;
    private final double maxSurfaceArea;

    public SurfaceAreaSpecification(double minSurfaceArea, double maxSurfaceArea) {
        this.minSurfaceArea = minSurfaceArea;
        this.maxSurfaceArea = maxSurfaceArea;
    }

    @Override
    public boolean specified(ConeObservable cone) {
        ConeCalculator calculator = new ConeCalculator();
        double surfaceArea = calculator.getSurfaceArea(cone);
        return surfaceArea >= minSurfaceArea && surfaceArea <= maxSurfaceArea;
    }
}
