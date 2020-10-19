package com.epam.cone.data.specification;

import com.epam.cone.model.ConeObservable;

public interface Specification {
    boolean specified(ConeObservable cone);
}
