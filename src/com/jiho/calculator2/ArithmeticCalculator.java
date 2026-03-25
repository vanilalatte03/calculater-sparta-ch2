package com.jiho.calculator2;

import java.util.List;

public class ArithmeticCalculator {
    //계산 메서드
    public double calculate(List<String> tokens){
        double result = Double.parseDouble(tokens.get(0));

        //연산기호 -> 숫자 순
        for(int i = 1; i < tokens.size(); i += 2){
            char operator = tokens.get(i).charAt(0);
            double num = Double.parseDouble(tokens.get(i + 1));

            result = OperatorType.findSymbol(operator).apply(result, num);
        }
        return result;
    }
}
