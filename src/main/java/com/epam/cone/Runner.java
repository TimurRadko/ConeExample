package com.epam.cone;

import com.epam.cone.data.ConeDirector;
import com.epam.cone.data.factory.ConeDirectorFactory;
import com.epam.cone.data.factory.ConeDirectorFactoryImpl;
import com.epam.cone.data.repository.ConeRepository;
import com.epam.cone.data.repository.ConeRepositoryImpl;
import com.epam.cone.exception.DataException;
import com.epam.cone.logic.ConeCalculator;
import com.epam.cone.logic.specification.IdSpecification;
import com.epam.cone.logic.specification.Specification;
import com.epam.cone.model.*;
import com.epam.cone.view.FileResultPrinter;
import com.epam.cone.view.ResultsPrinter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

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

        Observer observer = ConeObserver.getInstance();
        ConeRepository repository = new ConeRepositoryImpl();
        repository.addCones(coneList);

        ResultsPrinter printer = new FileResultPrinter(OUTPUT_FILE_PATH);
        printer.print(repository);

        Specification specification = new IdSpecification(1);

        List<ConeObservable> observables = repository.query(specification);
        ConeObservable coneObservable = observables.get(0);
        coneObservable.addObserver(observer);

        ConeCalculator calculator = new ConeCalculator();
        calculator.getSurfaceArea(coneObservable);
        calculator.getVolume(coneObservable);

        coneObservable.setRadius(5);
        printer.print(repository);
    }
}
