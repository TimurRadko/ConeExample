package com.epam.cone.logic.comparator;

import com.epam.cone.model.ConeObservable;

import java.util.Comparator;

public class ConeObservableIdComparator implements Comparator<ConeObservable> {

    @Override
    public int compare(ConeObservable fistCone, ConeObservable secondCone) {
        int firstId = fistCone.getId();
        int secondId = secondCone.getId();
        return firstId - secondId;
    }
}
