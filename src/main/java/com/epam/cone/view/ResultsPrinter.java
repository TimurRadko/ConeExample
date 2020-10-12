package com.epam.cone.view;

import com.epam.cone.exception.DataException;
import com.epam.cone.model.Cone;

import java.util.List;

public interface ResultsPrinter {
    void print(List<Cone> coneList) throws DataException;
}
