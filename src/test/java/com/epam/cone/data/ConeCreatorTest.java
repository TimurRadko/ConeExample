package com.epam.cone.data;

import com.epam.cone.model.Cone;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ConeCreatorTest {
    private static final List<Double> VALID_DATA = Arrays.asList(1.0, 1.0, 1.0, 1.0, 1.0);
    private static final List<Double> INVALID_DATA = Arrays.asList(1.0, 1.0, 1.0, -1.0, 1.0);
    private static final Point DEFAULT_POINT = new Point(1,1,1);
    private static final double RADIUS = 1;
    private static final double HEIGHT = 1;
    private static final Cone EXPECTED_CONE = new Cone(DEFAULT_POINT, RADIUS, HEIGHT);
    private static final Optional<Cone> EXPECTED_OPTIONAL = Optional.empty();

    @Test
    public void testCreateShouldCreateCorrectConeWhenDataIsValid() {
        ConeCreator creator = new ConeCreator();
        Optional<Cone> optionalCone = creator.create(VALID_DATA);
        Cone actualCone = optionalCone.get();
        Assert.assertEquals(EXPECTED_CONE, actualCone);
    }

    @Test
    public void testCreateShouldReturnEmptyOptionalWhenDataIsInvalid() {
        ConeCreator creator = new ConeCreator();
        Optional<Cone> optionalCone = creator.create(INVALID_DATA);
        Assert.assertEquals(EXPECTED_OPTIONAL, optionalCone);
    }
}
