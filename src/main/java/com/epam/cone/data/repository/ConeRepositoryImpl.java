package com.epam.cone.data.repository;

import com.epam.cone.data.specification.Specification;
import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConeRepositoryImpl implements ConeRepository {
    private static final Logger LOGGER = LogManager.getLogger(ConeRepositoryImpl.class);
    private final List<ConeObservable> coneList = new ArrayList<>();

    @Override
    public int getRepositorySize() {
        return coneList.size();
    }

    @Override
    public void add(ConeObservable cone) {
        coneList.add(cone);
    }

    @Override
    public void remove(ConeObservable cone) {
        coneList.remove(cone);
    }

    @Override
    public void update(ConeObservable cone) {
        int id = cone.getId();
        int i = 0;
        boolean isUpdated = false;
        while (i < coneList.size()) {
            ConeObservable givenConeObservable = coneList.get(i);
            if (givenConeObservable.getId() == id) {
                remove(givenConeObservable);
                add(cone);
                isUpdated = true;
            }
            i++;
        }
        checkIsUpdated(isUpdated, cone);
    }

    private void checkIsUpdated(boolean isUpdated, ConeObservable cone) {
        if (isUpdated) {
            LOGGER.info(String.format("Updating this cone (%s) is completed.", cone));
        } else {
            LOGGER.info(String.format("This is cone (%s) isn't in repository. Updating isn't completed", cone));
        }
    }

    @Override
    public void addCones(List<Cone> cones) {
        if (cones.isEmpty()) {
            LOGGER.error("You are trying empty list of the Cones");
        }
        for (int i = coneList.size(); i < cones.size(); i++) {
            Cone cone = cones.get(i);
            ConeObservable coneObservable = new ConeObservable(cone);
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
    public List<ConeObservable> sort(Comparator<ConeObservable> comparator) {
        List<ConeObservable> sortedConesObservable = new ArrayList<>(coneList);
        sortedConesObservable.sort(comparator);
        LOGGER.info("The Repository are sorted.");
        return sortedConesObservable;
    }

    @Override
    public String toString() {
        return "ConeRepository consists: coneList= " + coneList;
    }
}
