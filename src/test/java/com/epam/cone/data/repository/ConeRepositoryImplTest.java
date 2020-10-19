package com.epam.cone.data.repository;

import com.epam.cone.data.specification.IdSpecification;
import com.epam.cone.data.specification.Specification;
import com.epam.cone.logic.comparator.ConeObservableIdComparator;
import com.epam.cone.model.Cone;
import com.epam.cone.model.ConeObservable;
import com.epam.cone.model.Point;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.when;

public class ConeRepositoryImplTest {
    private static final Point DEFAULT_POINT = new Point(1,1,1);
    private static final double RADIUS = 1;
    private static final double HEIGHT = 1;
    private static final Cone EXPECTED_CONE = new Cone(DEFAULT_POINT, RADIUS, HEIGHT);
    private static final ConeObservable EXPECTED_CONE_OBSERVABLE = new ConeObservable(EXPECTED_CONE);

    private static final Point DEFAULT_UPDATING_POINT = new Point(2,2,2);
    private static final double UPDATING_RADIUS = 2;
    private static final double UPDATING_HEIGHT = 2;
    private static final Cone EXPECTED_UPDATING_CONE = new Cone(DEFAULT_UPDATING_POINT, UPDATING_RADIUS, UPDATING_HEIGHT);
    private static final ConeObservable UPDATING_CONE_OBSERVABLE = new ConeObservable(EXPECTED_UPDATING_CONE);
    private ConeRepository repository;
    private Specification specification;
    private static final ConeRepository EMPTY_REPOSITORY = new ConeRepositoryImpl();
    private static final List<Cone> CONES_LIST = Arrays.asList(EXPECTED_CONE, EXPECTED_UPDATING_CONE);
    private static final List<Cone> CONES_LIST_FOR_SORTING = Arrays.asList(EXPECTED_UPDATING_CONE, EXPECTED_CONE);

       @Before
    public void fillingRepository() {
        repository = new ConeRepositoryImpl();
        repository.add(EXPECTED_CONE_OBSERVABLE);
        specification = Mockito.mock(IdSpecification.class);
    }

    @Test
    public void testAddShouldAddConeToRepository() {
        int actualSize = repository.getRepositorySize();
        Assert.assertEquals(1, actualSize);
    }

    @Test
    public void testRemoveShouldRemoveConeWhenRepositoryConsistsCone() {
        Point actualPoint = new Point(1,1,1);
        Cone actualCone = new Cone(actualPoint,1,1);
        ConeObservable actualConeObservable = new ConeObservable(actualCone);
        repository.remove(actualConeObservable);
        int actualSize = repository.getRepositorySize();
        Assert.assertEquals(0, actualSize);
    }

    @Test
    public void testRemoveShouldNotRemoveWhenRepositoryNotConsistsCone() {
        Point actualPoint = new Point(2,1,1);
        Cone actualCone = new Cone(actualPoint,1,1);
        ConeObservable actualConeObservable = new ConeObservable(actualCone);
        repository.remove(actualConeObservable);
        int actualSize = repository.getRepositorySize();
        Assert.assertEquals(1, actualSize);
    }

    @Test
    public void testUpdateShouldUpdateConeWhenRepositoryConsistsCone() {
        Point actualPoint = new Point(2,2,2);
        Cone actualCone = new Cone(actualPoint,2,2);
        ConeObservable actualConeObservable = new ConeObservable(actualCone, 1);
        repository.update(actualConeObservable);
        when(specification.specified(anyObject())).thenReturn(true);
        List<ConeObservable> list = repository.query(specification);
        ConeObservable gettingActualConeObservable = list.get(0);
        Assert.assertEquals(UPDATING_CONE_OBSERVABLE, gettingActualConeObservable);
    }

    @Test
    public void testUpdateShouldNotUpdateConeWhenRepositoryNotConsistsCone() {
        Point actualPoint = new Point(3,2,2);
        Cone actualCone = new Cone(actualPoint,2,2);
        ConeObservable actualConeObservable = new ConeObservable(actualCone, 2);
        EMPTY_REPOSITORY.update(actualConeObservable);
        when(specification.specified(anyObject())).thenReturn(false);
        Assert.assertEquals(0, EMPTY_REPOSITORY.getRepositorySize());
    }

    @Test
    public void testAddConesShouldAddConesToRepository() {
        repository.addCones(CONES_LIST);
        Assert.assertEquals(2, repository.getRepositorySize());
    }

    @Test
    public void testQueryShouldReturnListWhenListConsistsSpecifiedCone() {
        when(specification.specified(anyObject())).thenReturn(true);
        List<ConeObservable> actualList =  repository.query(specification);
        Assert.assertEquals(1, actualList.size());
    }

    @Test
    public void testQueryShouldReturnEmptyListWhenListNotConsistsSpecifiedCone() {
        when(specification.specified(anyObject())).thenReturn(false);
        List<ConeObservable> actualList =  repository.query(specification);
        Assert.assertEquals(0, actualList.size());
    }

    @Test
    public void testSortShouldReturnSortedList() {
        repository.addCones(CONES_LIST_FOR_SORTING);
        Comparator<ConeObservable> comparator = new ConeObservableIdComparator();
        List<ConeObservable> actualList = repository.sort(comparator);
        Assert.assertEquals(EXPECTED_CONE_OBSERVABLE, actualList.get(0));
    }
}
