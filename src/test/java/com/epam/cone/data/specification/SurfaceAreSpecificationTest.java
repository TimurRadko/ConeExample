package com.epam.cone.data.specification;

import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SurfaceAreSpecificationTest {
    private static final Point DEFAULT_POINT = new Point(1, 1, 1);
    private static final double RADIUS = 1;
    private static final double HEIGHT = 1;
    private static final Cone EXPECTED_CONE = new Cone(DEFAULT_POINT, RADIUS, HEIGHT);
    private static final double CORRECT_MIN_SURFACE_AREA = 0;
    private static final double CORRECT_MAX_SURFACE_AREA = 10;
    private static final double INCORRECT_MIN_SURFACE_AREA = 10;
    private static final double INCORRECT_MAX_SURFACE_AREA = -5;
    private ConeObservable cone;

    @Before
    public void createConeObservable() {
        cone = new ConeObservable(EXPECTED_CONE);
    }

    @Test
    public void testSpecifiedShouldReturnCorrectListWhenListConsistEntity() {
        Specification specification = new SurfaceAreaSpecification(CORRECT_MIN_SURFACE_AREA, CORRECT_MAX_SURFACE_AREA);
        Assert.assertTrue(specification.specified(cone));
    }

    @Test
    public void testSpecifiedShouldReturnEmptyListWhenMinSurfaceAreaLessThanExpected() {
        Specification specification = new SurfaceAreaSpecification(INCORRECT_MIN_SURFACE_AREA, CORRECT_MAX_SURFACE_AREA);
        Assert.assertFalse(specification.specified(cone));
    }

    @Test
    public void testSpecifiedShouldReturnEmptyListWhenMaxSurfaceAreaLessThanExpected() {
        Specification specification = new SurfaceAreaSpecification(CORRECT_MIN_SURFACE_AREA, INCORRECT_MAX_SURFACE_AREA);
        Assert.assertFalse(specification.specified(cone));
    }
}
