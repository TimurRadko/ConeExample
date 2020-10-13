package com.epam.cone.data;

import java.util.ArrayList;
import java.util.List;

public class LineParser {
    private static final String SEPARATOR = "\\s";

    public List<Double> parsePoints(String line) {
        String[] points = line.split(SEPARATOR);
        List<Double> parameters = new ArrayList<>();
        for (String value : points) {
            Double doubleValue = Double.parseDouble(value);
            parameters.add(doubleValue);
        }
        return parameters;
    }
}
