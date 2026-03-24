package com.jiho.calculator2;

public class ArithmeticCalculator {
    //계산 메서드
    public double calculate(double n1, double n2, char operator){
        OperatorType op = OperatorType.findSymbol(operator);
        return op.apply(n1, n2);
    }
}
