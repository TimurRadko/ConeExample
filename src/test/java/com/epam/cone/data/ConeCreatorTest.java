package com.epam.cone.data;

import com.epam.cone.model.Cone;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class ConeCreatorTest {
    private ConeCreator coneCreator;
    private static final String CORRECT_DATA = "1.0 1.0 1.0 1.0 1.0";
    private static final int SIZE_FOR_TWO_CORRECT_PARAMETERS = 2;

//    @Before
//    public void createEntities() {
//        ConeParser parser = new ConeParser();
//        ConeValidator validator = new ConeValidator();
//        coneCreator = new ConeCreator(parser, validator);
//    }
//
//    @Test
//    public void testCreateShouldCreateCorrectSizeConeList() {
//        List<String> actualDataList = Arrays.asList(CORRECT_DATA, CORRECT_DATA);
//        List<Cone> actualConeList = coneCreator.create(actualDataList);
//        Assert.assertEquals(SIZE_FOR_TWO_CORRECT_PARAMETERS, actualConeList.size());
//    }
}
