package com.epam.cone.data;

public class ConeValidator {
    private static final String STRING_VALIDATE_REGEX = "((-\\d+|\\d+)\\.\\d+\\s*){3}(\\d+\\.\\d+\\s*){2}";

    public boolean isValid(String line) {
        return line.matches(STRING_VALIDATE_REGEX);
    }
}
