package com.epam.cone.logic.specification;

import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class IdSpecificationTest {
    private static final Point DEFAULT_POINT = new Point(1,1,1);
    private static final double RADIUS = 1;
    private static final double HEIGHT = 1;
    private static final Cone EXPECTED_CONE = new Cone(DEFAULT_POINT, RADIUS, HEIGHT);
    private static final ConeObservable CONE = new ConeObservable(EXPECTED_CONE, 1);

    @Test
    public void testSpecifiedShouldReturnCorrectListWhenLIstConsistEntity() {
        Specification specification = new IdSpecification(1);
        Assert.assertTrue(specification.specified(CONE));
    }
}
