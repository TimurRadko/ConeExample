package com.epam.cone.data;

import com.epam.cone.data.reader.DataReader;
import com.epam.cone.data.validator.Validator;
import com.epam.cone.exception.DataException;
import com.epam.cone.model.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ConeDirector {
    private static final Logger LOGGER = LogManager.getLogger(ConeDirector.class);
    private final DataReader reader;
    private final LineParser parser;
    private final Validator<String> validator;
    private final ConeCreator creator;

    public ConeDirector(DataReader reader, LineParser parser, Validator<String> validator, ConeCreator creator) {
        this.reader = reader;
        this.parser = parser;
        this.validator = validator;
        this.creator = creator;
    }

    public List<Cone> createConeList(String filename) throws DataException {
        List<Cone> coneList = new ArrayList<>();
        List<String> lines = reader.readLines(filename);
        for (String line : lines) {
            if (validator.isValid(line)) {
                List<Double> coneParameters = parser.parsePoints(line);
                Optional<Cone> optionalCone = creator.create(coneParameters);
                if (optionalCone.isPresent()) {
                    Cone cone = optionalCone.get();
                    coneList.add(cone);
                    LOGGER.info("The cone has added to List");
                }
            } else {
                LOGGER.warn(String.format("Received Data (%s) is not Valid", line));
            }
        }
        return coneList;
    }
}