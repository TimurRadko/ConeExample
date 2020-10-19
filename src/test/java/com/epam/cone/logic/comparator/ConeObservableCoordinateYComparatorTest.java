package com.epam.cone.logic.comparator;

import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class ConeObservableCoordinateYComparatorTest {
    private static final Point DEFAULT_POINT = new Point(1,1,1);
    private static final double RADIUS = 1;
    private static final double HEIGHT = 1;
    private static final Cone FIRST_CONE = new Cone(DEFAULT_POINT, RADIUS, HEIGHT);
    private static final ConeObservable FIRST_CONE_OBSERVABLE = new ConeObservable(FIRST_CONE);

    private static final Point DEFAULT_UPDATING_POINT = new Point(2,2,2);
    private static final double UPDATING_RADIUS = 2;
    private static final double UPDATING_HEIGHT = 2;
    private static final Cone SECOND_CONE = new Cone(DEFAULT_UPDATING_POINT, UPDATING_RADIUS, UPDATING_HEIGHT);
    private static final ConeObservable SECOND_CONE_OBSERVABLE = new ConeObservable(SECOND_CONE);
    private Comparator<ConeObservable> comparator;

    @Before
    public void createComparator() {
        comparator = new ConeObservableCoordinateYComparator();
    }

    @Test
    public void testCompareShouldReturnCorrectResultWhenFirstObjectLessThenSecond() {
        int result = comparator.compare(FIRST_CONE_OBSERVABLE, SECOND_CONE_OBSERVABLE);
        Assert.assertTrue(result < 0);
    }

    @Test
    public void testCompareShouldReturnCorrectResultWhenFirstObjectEqualsSecond() {
        int result = comparator.compare(FIRST_CONE_OBSERVABLE, FIRST_CONE_OBSERVABLE);
        Assert.assertEquals(0, result);
    }
}
