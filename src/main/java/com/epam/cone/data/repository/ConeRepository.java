package com.epam.cone.data.repository;

import com.epam.cone.logic.specification.Specification;
import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;

import java.util.List;

public interface ConeRepository {
    void addCone(ConeObservable cone);
    void removeCone(ConeObservable cone);
    void updateCone(ConeObservable cone);
    void addCones(List<Cone> cones);
    int getRepositorySize();
    List<ConeObservable> query(Specification specification);
}
