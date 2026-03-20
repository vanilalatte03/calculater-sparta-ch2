package com.jiho.calculator;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticCalculator<T extends Number> {
    private final List<Double> save = new ArrayList<>();
    //계산 메서드
    public double calculate(T n1, T n2, char operator){
        double result = 0.0;
        //enum을 통한 사칙연산
        try {
            OperatorType op = OperatorType.findSymbol(operator);
            result = op.apply(n1.doubleValue(), n2.doubleValue());
            save.add(result);
        } catch (ArithmeticException | IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
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

    public List<Double> getLargeResult(double num){
        return save.stream()
                .filter(value -> value > num)
                .toList();
    }



}
