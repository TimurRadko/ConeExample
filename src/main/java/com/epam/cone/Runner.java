package com.epam.cone;

import com.epam.cone.data.ConeCreator;
import com.epam.cone.data.ConeDirector;
import com.epam.cone.data.LineParser;
import com.epam.cone.data.factory.ConeDirectorFactory;
import com.epam.cone.data.factory.ConeDirectorFactoryImpl;
import com.epam.cone.data.reader.DataReader;
import com.epam.cone.data.reader.FileDataReader;
import com.epam.cone.data.validator.LineValidator;
import com.epam.cone.exception.DataException;
import com.epam.cone.logic.ConeCalculator;
import com.epam.cone.model.Cone;
import com.epam.cone.view.FileResultPrinter;
import com.epam.cone.view.ResultsPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class Runner {
    private static final String FILE_PATH = "data/input.txt";
    private static final String OUTPUT_FILE_PATH = "data/output.txt";
    private static final Logger LOGGER = LogManager.getRootLogger();

    public static void main(String[] args) {

        try {
            runProgram();
        } catch (DataException e) {
            LOGGER.error("Error " + e);
        }
    }

    private static void runProgram() throws DataException {
        ConeDirectorFactory factory = new ConeDirectorFactoryImpl();
        ConeDirector director = factory.create();
        List<Cone> coneList = director.createConeList(FILE_PATH);

        ResultsPrinter printer = new FileResultPrinter(OUTPUT_FILE_PATH);
        printer.print(coneList);

        ConeCalculator calculator = new ConeCalculator();

        double surfaceArea = calculator.getSurfaceArea(coneList.get(0));
        double volume = calculator.getVolume(coneList.get(0));
        double volumeRationAfterTruncated = calculator.volumeRatioAfterTruncated(coneList.get(0), 5);
    }
}
