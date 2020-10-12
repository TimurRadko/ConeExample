package com.epam.cone.data.reader;

import com.epam.cone.exception.DataException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataFileReader implements DataReader {
    private static final Logger LOGGER = LogManager.getLogger();

    @Override
    public List<String> readLines(String filename) throws DataException {
        List<String> lineList = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                lineList.add(line);
            }
        } catch (IOException e) {
            throw new DataException("File not found.");
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    LOGGER.error("Closing has ended with error " + e);
                }
            }
        }
        return lineList;
    }
}
