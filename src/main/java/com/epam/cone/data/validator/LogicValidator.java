package com.epam.cone.data.validator;


public class LogicValidator implements Validator<Double> {

    @Override
    public boolean isValid(Double item) {
        return item > 0;
    }
}
