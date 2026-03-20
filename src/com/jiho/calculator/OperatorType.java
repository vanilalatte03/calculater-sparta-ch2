package com.jiho.calculator;

public enum OperatorType {
    PLUS("+") {
        public double apply(double x, double y){
            return x + y;
        }
    },
    MINUS("-") {
        public double apply(double x, double y){
            return x - y;
        }
    },
    MULTI("*") {
        public double apply(double x, double y){
            return x * y;
        }
    },
    DIVIDE("/"){
        public double apply(double x, double y){
            return x / y;
        }
    };

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    public String getSymbol() {
        return symbol;
    }

    public static OperatorType findSymbol(char operator) {
        switch (operator) {
            case '+':
                return PLUS;
            case '-':
                return MINUS;
            case '*':
                return MULTI;
            case '/':
                return DIVIDE;
            default:
                throw new IllegalArgumentException("지원하지 않는 연산자입니다: " + operator);
        }
    }
}
