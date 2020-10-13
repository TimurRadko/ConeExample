package com.epam.cone.data.factory;

import com.epam.cone.data.ConeCreator;
import com.epam.cone.data.ConeDirector;
import com.epam.cone.data.LineParser;
import com.epam.cone.data.reader.DataReader;
import com.epam.cone.data.reader.FileDataReader;
import com.epam.cone.data.validator.LineValidator;
import com.epam.cone.data.validator.Validator;

public class ConeDirectorFactoryImpl implements ConeDirectorFactory {
    private final DataReader reader = new FileDataReader();
    private final LineParser parser = new LineParser();
    private final Validator<String> validator = new LineValidator();
    private final ConeCreator creator = new ConeCreator();

    @Override
    public ConeDirector create() {
        return new ConeDirector(reader, parser, validator, creator);
    }
}
