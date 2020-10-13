package com.epam.cone.data.reader;

import com.epam.cone.exception.DataException;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FileDataReaderTest {
    private static final String CORRECT_FILE_PATH = "src/test/resources/correct_input.txt";
    private static final String EXPECTED_LINE = "[1.0 1.0 1.0 1.0 1.0]";
    private static final String FAILED_FILE_PATH = "src/test/resources/fail.txt";

    @Test
    public void testReadLineShouldCorrectReadDataIfFileExists() throws DataException {
        DataReader reader = new FileDataReader();
        List<String> actualDataList = reader.readLines(CORRECT_FILE_PATH);
        Assert.assertEquals(EXPECTED_LINE, actualDataList.toString());
    }

    @Test(expected = DataException.class)
    public void testReadLineShouldThrowDataExceptionIfFileNotExists() throws DataException {
        FileDataReader reader = new FileDataReader();
        List<String> actualDataList = reader.readLines(FAILED_FILE_PATH);
    }
}
