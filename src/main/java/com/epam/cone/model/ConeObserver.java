package com.epam.cone.model;

import com.epam.cone.logic.ConeCalculator;

import java.util.HashMap;
import java.util.Map;

public class ConeObserver implements Observer {
    private final Map<Integer, Parameters> map = new HashMap<>();
    private final ConeCalculator calculator;
    private static final ConeObserver CONE_OBSERVER = new ConeObserver();

    private ConeObserver() {
        calculator = new ConeCalculator();
    }

    /*package-friendly*/ ConeObserver(ConeCalculator calculator) {
        this.calculator = calculator;
    }

    public void update(ConeObservable cone) {
        double surfaceArea = calculator.getSurfaceArea(cone);
        double volume = calculator.getVolume(cone);
        int id = cone.getId();
        Parameters parameters = new Parameters(surfaceArea, volume);
        map.put(id, parameters);
    }

    public static ConeObserver getInstance() {
        return CONE_OBSERVER;
    }
}
