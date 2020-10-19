package com.epam.cone.data;

import com.epam.cone.data.reader.DataReader;
import com.epam.cone.data.reader.FileDataReader;
import com.epam.cone.data.validator.LineValidator;
import com.epam.cone.data.validator.Validator;
import com.epam.cone.exception.DataException;
import com.epam.cone.model.Cone;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.*;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

public class ConeDirectorTest {
    private DataReader reader;
    private LineParser parser;
    private Validator<String> validator;
    private ConeCreator creator;
    private static final String FILE_PATH = "src/test/resources/test_director.txt";
    private static final List<String> VALID_LINES = Collections.singletonList("1.5 4.1 2.3 9.1 3.3");
    private static final List<Double> VALID_PARAMETERS = Arrays.asList(1.5, 4.1, 2.3, 9.1, 3.3);
    private static final List<String> INVALID_LINES = Collections.singletonList("k 1.0 1.0 1.0 1.0");
    private static final Point DEFAULT_POINT = new Point(1.5,4.1,2.3);
    private static final double RADIUS = 9.1;
    private static final double HEIGHT = 3.3;
    private static final List<Cone> EXPECTED_LIST = Collections.singletonList(new Cone(DEFAULT_POINT, RADIUS, HEIGHT));
    private static final List<Cone> EMPTY_LIST = new ArrayList<>();

    @Before
    public void prepareDependencies() {
        reader = Mockito.mock(FileDataReader.class);
        parser = Mockito.mock(LineParser.class);
        validator = Mockito.mock(LineValidator.class);
        creator = Mockito.mock(ConeCreator.class);
    }

    @Test
    public void testCreateConeListShouldReturnCorrectListWhenDataIsValid() throws DataException {

        when(reader.readLines(anyString())).thenReturn(VALID_LINES);
        when(validator.isValid(anyString())).thenReturn(true);
        when(parser.parsePoints(VALID_LINES.get(0))).thenReturn(VALID_PARAMETERS);
        when(creator.create(VALID_PARAMETERS)).thenReturn(Optional.of(new Cone(DEFAULT_POINT, RADIUS, HEIGHT)));

        ConeDirector director = new ConeDirector(reader, parser, validator, creator);
        List<Cone> actualConeList = director.createConeList();

        Assert.assertEquals(EXPECTED_LIST, actualConeList);
    }

    @Test
    public void testCreateConeListShouldReturnEmptyListWhenDataIsInvalid() throws DataException {

        when(reader.readLines(anyString())).thenReturn(INVALID_LINES);
        when(validator.isValid(anyString())).thenReturn(false);

        ConeDirector director = new ConeDirector(reader, parser, validator, creator);
        List<Cone> actualConeList = director.createConeList();

        Assert.assertEquals(EMPTY_LIST, actualConeList);
    }
}
