package com.jiho.calculator4;

import java.util.List;

public class CalculatorService {
    public double calculate(List<String> tokens) {
        validateExpression(tokens);

        double result = Double.parseDouble(tokens.get(0));

        for (int index = 1; index < tokens.size(); index += 2) {
            String operator = tokens.get(index);
            double nextNumber = Double.parseDouble(tokens.get(index + 1));
            result = OperatorType.fromSymbol(operator).apply(result, nextNumber);
        }

        return result;
    }

    private void validateExpression(List<String> tokens) {
        if (tokens.isEmpty()) {
            throw new IllegalArgumentException("계산할 수식이 없습니다.");
        }

        if (tokens.size() % 2 == 0) {
            throw new IllegalArgumentException("수식 형식이 올바르지 않습니다.");
        }
    }
}
