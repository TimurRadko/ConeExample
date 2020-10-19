package com.epam.cone.data.specification;

import com.epam.cone.logic.ConeCalculator;
import com.epam.cone.model.ConeObservable;

public class VolumeSpecification implements Specification {
    private final double minVolume;
    private final double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specified(ConeObservable cone) {
        ConeCalculator calculator = new ConeCalculator();
        double volume = calculator.getSurfaceArea(cone);
        return volume >= minVolume && volume <= maxVolume;
    }
}
