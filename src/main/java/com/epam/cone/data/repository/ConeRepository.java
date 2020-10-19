package com.epam.cone.data.repository;

import com.epam.cone.data.specification.Specification;
import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;

import java.util.Comparator;
import java.util.List;

public interface ConeRepository {
    void add(ConeObservable cone);
    void remove(ConeObservable cone);
    void update(ConeObservable cone);
    void addCones(List<Cone> cones);
    List<ConeObservable> sort(Comparator<ConeObservable> comparator);
    List<ConeObservable> query(Specification specification);
    int getRepositorySize();
}
