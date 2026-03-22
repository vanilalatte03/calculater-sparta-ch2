package com.jiho.calculator2;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {

    //계산 메서드
    public double calculate(T n1, T n2, char operator){
        double result = 0.0;
        //enum을 통한 사칙연산
        try {
            OperatorType op = OperatorType.findSymbol(operator);
            result = op.apply(n1.doubleValue(), n2.doubleValue());
        } catch (ArithmeticException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        return result;
    }
}
