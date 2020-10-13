package com.epam.cone.data.validator;

public interface Validator<T> {
    boolean isValid(T item);
}
