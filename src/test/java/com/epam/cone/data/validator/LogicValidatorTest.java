package com.epam.cone.data.validator;

import org.junit.Assert;
import org.junit.Test;

public class LogicValidatorTest {
    private static final double VALID_RADIUS = 1;
    private static final double VALID_HEIGHT = 1;
    private static final double INVALID_RADIUS = -1;
    private static final double INVALID_HEIGHT = -1;

    @Test
    public void testIsRadiusAndHeightMOreThanZeroShouldReturnTrueWhenDataIsValid() {
        LogicValidator validator = new LogicValidator();
        boolean actualResult = validator.isValid(VALID_RADIUS);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testIsRadiusAndHeightMOreThanZeroShouldReturnTrueWhenRadiusIsInvalid() {
        LogicValidator validator = new LogicValidator();
        boolean actualResult = validator.isValid(INVALID_RADIUS);
        Assert.assertFalse(actualResult);
    }
}
