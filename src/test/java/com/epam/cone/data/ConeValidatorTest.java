package com.epam.cone.data;

import org.junit.Assert;
import org.junit.Test;

public class ConeValidatorTest {
    private static final String CORRECT_DATA = "1.0 1.0 1.0 1.0 1.0";
    private static final String FIRST_THREE_PARAMETERS_LESS_THEN_ZERO = "-1.0 1.0 1.0 1.0 1.0";
    private static final String RADIUS_LESS_THEN_ZERO = "1.0 1.0 1.0 -1.0 1.0";
    private static final String GREATER_DATA = "1.0 1.0 1.0 1.0 1.0 1.0";
    private static final String INCORRECT_DATA = "k 1.0 1.0 1.0 1.0";
    private static final String HEIGHT_LESS_THEN_ZERO = "1.0 1.0 1.0 1.0 -1.0";

    @Test
    public void testIsValidWhenAllParametersIsValid() {
        ConeValidator validator = new ConeValidator();
        Assert.assertTrue(validator.isValid(CORRECT_DATA));
    }

    @Test
    public void testIsValidWhenOneOfThreeFirstParameterLessThenZero() {
        ConeValidator validator = new ConeValidator();
        Assert.assertTrue(validator.isValid(FIRST_THREE_PARAMETERS_LESS_THEN_ZERO));
    }

    @Test
    public void testIsValidWhenRadiusLessThenZero() {
        ConeValidator validator = new ConeValidator();
        Assert.assertFalse(validator.isValid(RADIUS_LESS_THEN_ZERO));
    }

    @Test
    public void testIsValidWhenHeightLessThenZero() {
        ConeValidator validator = new ConeValidator();
        Assert.assertFalse(validator.isValid(HEIGHT_LESS_THEN_ZERO));
    }

    @Test
    public void testIsValidWhenParametersIsMoreThanNecessary() {
        ConeValidator validator = new ConeValidator();
        Assert.assertFalse(validator.isValid(GREATER_DATA));
    }

    @Test
    public void testIsValidWhenOneParameterIsIncorrect() {
        ConeValidator validator = new ConeValidator();
        Assert.assertFalse(validator.isValid(INCORRECT_DATA));
    }
}
