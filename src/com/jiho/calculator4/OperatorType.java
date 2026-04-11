package com.jiho.calculator4;

public enum OperatorType {
    PLUS("+") {
        @Override
        public double apply(double left, double right) {
            return left + right;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double left, double right) {
            return left - right;
        }
    },
    MULTIPLY("*") {
        @Override
        public double apply(double left, double right) {
            return left * right;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double left, double right) {
            if (right == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return left / right;
        }
    };

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double left, double right);

    public static OperatorType fromSymbol(String symbol) {
        for (OperatorType operatorType : values()) {
            if (operatorType.symbol.equals(symbol)) {
                return operatorType;
            }
        }
        throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + symbol);
    }

    public static boolean isSupported(String symbol) {
        for (OperatorType operatorType : values()) {
            if (operatorType.symbol.equals(symbol)) {
                return true;
            }
        }
        return false;
    }
}
