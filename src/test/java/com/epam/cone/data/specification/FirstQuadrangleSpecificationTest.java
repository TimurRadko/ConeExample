package com.epam.cone.data.specification;

import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Test;

public class FirstQuadrangleSpecificationTest {
    private static final Point DEFAULT_POINT = new Point(1, 1, 1);
    private static final double RADIUS = 1;
    private static final double HEIGHT = 1;
    private static final Cone EXPECTED_CONE = new Cone(DEFAULT_POINT, RADIUS, HEIGHT);

    private static final Point NEGATIVE_POINT = new Point(-1, -1, -1);
    private static final Cone EXPECTED_NEGATIVE_CONE = new Cone(NEGATIVE_POINT, RADIUS, HEIGHT);

    @Test
    public void testSpecifiedShouldReturnCorrectAnswerWhenListConsistEntity() {
        Specification specification = new FirstQuadrangleSpecification();
        ConeObservable actualCone = new ConeObservable(EXPECTED_CONE);
        Assert.assertTrue(specification.specified(actualCone));
    }

    @Test
    public void testSpecifiedShouldReturnCorrectAnswerWhenListNotConsistEntity() {
        Specification specification = new FirstQuadrangleSpecification();
        ConeObservable actualCone = new ConeObservable(EXPECTED_NEGATIVE_CONE);
        Assert.assertFalse(specification.specified(actualCone));
    }
}
