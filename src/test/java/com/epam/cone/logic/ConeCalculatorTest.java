package com.epam.cone.logic;

import com.epam.cone.model.Cone;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ConeCalculatorTest {
    private static final double DELTA = 0.01;
    private static final double EXPECTED_ZERO = 0;
    private static final double DEFAULT_RADIUS = 1;
    private static final double DEFAULT_HEIGHT = 1;
    private static final Point ZERO_POINT = new Point(0,0,0);
    private static final Point DEFAULT_POINT = new Point(1,1,1);
    private static final Cone DEFAULT_CONE = new Cone(DEFAULT_POINT,DEFAULT_RADIUS,DEFAULT_HEIGHT);
    private static final Cone ON_THE_AXIS_CONE = new Cone(ZERO_POINT, DEFAULT_RADIUS,DEFAULT_HEIGHT);
    private static final Cone ZERO_CONE = new Cone(ZERO_POINT,0,0);
    private ConeCalculator calculator;

    @Before
    public void createConeCalculator() {
        calculator = new ConeCalculator();
    }

    @Test
    public void testGetSurfaceAreaShouldReturnZeroWhenParametersConeIsZero() {
        double actualResult = calculator.getSurfaceArea(ZERO_CONE);
        Assert.assertEquals(EXPECTED_ZERO, actualResult, DELTA);
    }

    @Test
    public void testGetVolumeShouldReturnZeroWhenParametersConeIsZero() {
        double actualResult = calculator.getVolume(ZERO_CONE);
        Assert.assertEquals(EXPECTED_ZERO, actualResult, DELTA);
    }

    @Test
    public void testCheckConeBaseLieOnAxisXZShouldReturnTrueWhenConeLieOnAxis() {
        Assert.assertTrue(calculator.checkConeBaseLieOnAxisXZ(ON_THE_AXIS_CONE));
    }

    @Test
    public void testVolumeRatioAfterTruncatedShouldReturnCorrect() {
        double actualResult = calculator.volumeRatioAfterTruncated(DEFAULT_CONE, 1);
        Assert.assertEquals(1, actualResult, DELTA);
    }
}
