package com.jiho.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator {
    private final List<Double> save = new ArrayList<>();
    //계산 메서드
    public double calculate(int n1, int n2, char operator){

        //enum을 통한 사칙연산
        OperatorType op = OperatorType.findSymbol(operator);
        double result = op.apply(n1, n2);

        save.add(result);
        return result;
    }

    public void removeFirstResult(){
        save.removeFirst();
    }

    public List<Double> getSave(){
        return save;
    }

    //계산 기록 수정
    public void setSave(int index, Double num){
        save.set(index, num);
    }



}
