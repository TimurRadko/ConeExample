package com.epam.cone.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class LineParserTest {
    private static final String LINE = "1.0 1.0 1.0 1.0 1.0";
    private static final int EXPECTED_SIZE = 5;
    private static final double EXPECTED_VALUE = 1.0;
    private static final double DELTA = 0.01;

    @Test
    public void testParsePointShouldCorrectParseWhenStringNotNull() {
        LineParser parser = new LineParser();
        List<Double> parameters = parser.parsePoints(LINE);
        Assert.assertEquals(EXPECTED_SIZE, parameters.size());
        double actualValue = parameters.get(0);
        Assert.assertEquals(EXPECTED_VALUE, actualValue, DELTA);
    }
}
