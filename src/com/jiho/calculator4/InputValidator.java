package com.jiho.calculator4;

import java.util.regex.Pattern;

public class InputValidator {
    private static final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+(\\.\\d+)?");

    public boolean isNumber(String input) {
        if (input == null) {
            return false;
        }
        return NUMBER_PATTERN.matcher(input.trim()).matches();
    }

    public boolean isOperatorOrEqual(String input) {
        if (input == null) {
            return false;
        }

        String trimmedInput = input.trim();
        return "=".equals(trimmedInput) || OperatorType.isSupported(trimmedInput);
    }
}
