package com.epam.cone.data.repository;

import com.epam.cone.logic.specification.Specification;
import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeRepositoryImpl implements ConeRepository {
    private static final Logger LOGGER = LogManager.getLogger(ConeRepositoryImpl.class);
    private final List<ConeObservable> coneList = new ArrayList<>();

    @Override
    public int getRepositorySize() {
        return coneList.size();
    }

    @Override
    public void addCone(ConeObservable cone) {
        coneList.add(cone);
    }

    @Override
    public void removeCone(ConeObservable cone) {
        coneList.remove(cone);
    }

    @Override
    public void updateCone(ConeObservable cone) {

    }

    @Override
    public void addCones(List<Cone> cones) {
        for (int i = 0; i < cones.size(); i++) {
            Cone cone = cones.get(i);
            ConeObservable coneObservable = new ConeObservable(cone, i + 1);
            coneList.add(coneObservable);
        }
        LOGGER.info(String.format("Cones are added to repository. Repository size: %s", getRepositorySize()));
    }

    @Override
    public List<ConeObservable> query(Specification specification) {
        List<ConeObservable> findingCone = new ArrayList<>();

        for (ConeObservable cone : coneList) {
            if (specification.specified(cone)) {
                findingCone.add(cone);
            }
        }
        return findingCone;
    }

    @Override
    public String toString() {
        return "ConeRepository consists: coneList= " + coneList;
    }
}
