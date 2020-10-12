package com.epam.cone.data;

import com.epam.cone.data.reader.DataFileReader;
import com.epam.cone.data.reader.DataReader;
import com.epam.cone.exception.DataException;
import com.epam.cone.model.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ConeDirector {
    private final DataReader reader = new DataFileReader();
    private final ConeParser parser = new ConeParser();
    private final ConeValidator validator = new ConeValidator();
    private static final Logger LOGGER = LogManager.getLogger(ConeDirector.class);

    public List<Cone> createConeList(String filename) throws DataException {
        List<String> lines = reader.readLines(filename);
        ConeCreator creator = new ConeCreator();
        List<Cone> coneList = new ArrayList<>();

        for (String line : lines) {
            if (validator.isValid(line)) {
                List<Double> parameters = parser.parsePoints(line);
                Cone cone = creator.create(parameters);
                coneList.add(cone);
                LOGGER.info("The cone has added to List");
            } else {
                LOGGER.warn(String.format("Received Data (%s) is not Valid", line));
            }
        }
        return coneList;
    }
}
