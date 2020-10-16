package com.epam.cone.view;

import com.epam.cone.data.repository.ConeRepository;
import com.epam.cone.exception.DataException;

public interface ResultsPrinter {
    void print(ConeRepository repository) throws DataException;
}
