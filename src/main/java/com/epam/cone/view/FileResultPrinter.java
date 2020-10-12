package com.epam.cone.view;

import com.epam.cone.exception.DataException;
import com.epam.cone.model.Cone;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FileResultPrinter implements ResultsPrinter {
    private static final Logger LOGGER = LogManager.getLogger(FileResultPrinter.class);
    private final String filename;

    public FileResultPrinter(String filename) {
        this.filename = filename;
    }

    @Override
    public void print(List<Cone> coneList) throws DataException {
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(filename));
            writeConeToFile(coneList, writer);
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

    private void writeConeToFile(List<Cone> coneList, BufferedWriter writer) throws IOException {
        for (Cone cone : coneList) {
            String coneToString = String.format("%s\n",cone.toString());
            writer.write(coneToString);
        }
    }
}
