package com.epam.cone.view;

import com.epam.cone.data.repository.ConeRepository;
import com.epam.cone.exception.DataException;
import com.epam.cone.logic.specification.IdSpecification;
import com.epam.cone.logic.specification.Specification;
import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileResultPrinter implements ResultsPrinter {
    private static final Logger LOGGER = LogManager.getLogger(FileResultPrinter.class);
    private final String filename;

    public FileResultPrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void print(ConeRepository repository) throws DataException {
        List<ConeObservable> coneList = getListFromRepository(repository);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename, true));
            writeConeToFile(coneList, writer);
            LOGGER.info("Repository is printed.");
        } catch (IOException e) {
            throw new DataException("File not found", e);
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    private void writeConeToFile(List<ConeObservable> coneList, BufferedWriter writer) throws IOException {
        for (Cone cone : coneList) {
            String coneToString = prepareStringToPrint(cone.toString());
            LOGGER.info(String.format("%s",coneToString));
            writer.write(String.format("%s",coneToString));
        }
    }

    private List<ConeObservable> getListFromRepository(ConeRepository repository) {
        List<ConeObservable> cones = new ArrayList<>();
        for (int i = 0; i < repository.getRepositorySize(); i++) {
            Specification specification = new IdSpecification(i + 1);
            List<ConeObservable> observables = repository.query(specification);
            ConeObservable coneObservable = observables.get(0);
            cones.add(coneObservable);
        }
        return cones;
    }

    private String prepareStringToPrint(String value) {
        int length = value.length();
        return value.substring(0, length - 1);
    }
}
