package com.epam.cone.data.repository;

import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class ConeRepositoryImplTest {
    private static final Point DEFAULT_POINT = new Point(1,1,1);
    private static final double RADIUS = 1;
    private static final double HEIGHT = 1;
    private static final Cone EXPECTED_CONE = new Cone(DEFAULT_POINT, RADIUS, HEIGHT);
    private static final ConeObservable CONE = new ConeObservable(EXPECTED_CONE);

    @Test
    public void testAddConeShouldAddConeToRepository() {
        ConeRepository repository = new ConeRepositoryImpl();
        repository.addCone(CONE);
        int actualSize = repository.getRepositorySize();
        Assert.assertEquals(1, actualSize);
    }
}
