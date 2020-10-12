package com.epam.cone.data;

import com.epam.cone.model.Cone;
import com.epam.cone.model.Point;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class ConeCreator {
    private static final Logger LOGGER = LogManager.getLogger(ConeCreator.class);
    private static final String DELIMITER = ", ";
    private static final int CENTRAL_POINT_COORDINATE_X = 0;
    private static final int CENTRAL_POINT_COORDINATE_Y = 1;
    private static final int CENTRAL_POINT_COORDINATE_Z = 2;
    private static final int RADIUS = 3;
    private static final int HEIGHT = 4;

    public Cone create(List<Double> parameters) {

        LOGGER.info(String.format("Received Data (%s) is Valid", prepareLogMessage(parameters)));

        Double coordinateX = parameters.get(CENTRAL_POINT_COORDINATE_X);
        Double coordinateY = parameters.get(CENTRAL_POINT_COORDINATE_Y);
        Double coordinateZ = parameters.get(CENTRAL_POINT_COORDINATE_Z);
        Point point = new Point(coordinateX, coordinateY, coordinateZ);

        Double radius = parameters.get(RADIUS);
        Double height = parameters.get(HEIGHT);
        Cone cone = new Cone(point, radius, height);

        LOGGER.info(String.format("%s has created", cone));
        return cone;
    }

    private String prepareLogMessage(List<Double> parameters) {
        StringBuilder builder = new StringBuilder();
        for (Double parameter : parameters) {
            builder.append(parameter).append(DELIMITER);
        }
        String rawString = builder.toString();
        int lengthRawString = rawString.length();
        return rawString.substring(0, lengthRawString - 2);
    }
}
