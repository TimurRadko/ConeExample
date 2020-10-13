package com.epam.cone.data.validator;

import org.junit.Assert;
import org.junit.Test;

public class LogicValidatorTest {
    private static final double VALID_RADIUS = 1;
    private static final double INVALID_RADIUS = -1;

    @Test
    public void testIsRadiusAndHeightMoreThanZeroShouldReturnTrueWhenDataIsValid() {
        LogicValidator validator = new LogicValidator();
        boolean actualResult = validator.isValid(VALID_RADIUS);
        Assert.assertTrue(actualResult);
    }

    @Test
    public void testIsRadiusAndHeightMoreThanZeroShouldReturnFalseWhenOneParametersIsInvalid() {
        LogicValidator validator = new LogicValidator();
        boolean actualResult = validator.isValid(INVALID_RADIUS);
        Assert.assertFalse(actualResult);
    }
}
