package com.jiho.calculator2;

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
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            } else {
                return x / y;
            }
        }
    };

    private final String symbol;

    OperatorType(String symbol) {
        this.symbol = symbol;
    }

    public abstract double apply(double x, double y);

    //없어도 될듯? (삭제 보류)
    public String getSymbol() {
        return symbol;
    }

    public static OperatorType findSymbol(char operator) {
        return switch (operator) {
            case '+' -> PLUS;
            case '-' -> MINUS;
            case '*' -> MULTI;
            case '/' -> DIVIDE;
            default -> throw new IllegalArgumentException("지원하지 않는 연산자입니다");
        };
    }
}
