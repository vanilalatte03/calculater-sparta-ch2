package com.jiho.calculator2;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    //계산 메서드
    public double calculate(T n1, T n2, char operator){
        //enum을 통한 사칙연산
        OperatorType op = OperatorType.findSymbol(operator);
        return op.apply(n1.doubleValue(), n2.doubleValue());
    }
}
