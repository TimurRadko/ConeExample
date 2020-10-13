package com.epam.cone.data.validator;

public class LineValidator implements Validator<String> {
    private static final String STRING_VALIDATE_REGEX = "(-?\\d\\.\\d+\\s*){3}(\\d+\\.\\d+\\s*){2}";

    @Override
    public boolean isValid(String line) {
        return line.matches(STRING_VALIDATE_REGEX);
    }
}
