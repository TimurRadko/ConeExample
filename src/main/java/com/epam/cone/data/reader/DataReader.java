package com.epam.cone.data.reader;

import com.epam.cone.exception.DataException;

import java.util.List;

public interface DataReader {
    List<String> readLines(String filename) throws DataException;
}
