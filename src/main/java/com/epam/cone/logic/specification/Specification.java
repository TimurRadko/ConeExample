package com.epam.cone.logic.specification;

import com.epam.cone.model.ConeObservable;

public interface Specification {
    boolean specified(ConeObservable cone);
}
