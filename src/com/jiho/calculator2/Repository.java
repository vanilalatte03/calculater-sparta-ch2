package com.jiho.calculator2;

import java.util.ArrayList;
import java.util.List;

//저장소
public class Repository {
    private final List<Double> results = new ArrayList<>();

    //저장
    public void save(double result) {
        results.add(result);
    }

    //첫번째 기록 삭제
    public void removeFirstResult(){
        results.removeFirst();
    }

    //기록 반환
    public List<Double> getResults(){
        return new ArrayList<>(results);
    }

    //계산 기록 수정
    public void updateAt(int index, double value) {
        results.set(index, value);
    }

    //입력값보다 큰 숫자 반환
    public List<Double> getLargeResult(double num){
        return results.stream()
                .filter(value -> value > num)
                .toList();
    }


}
