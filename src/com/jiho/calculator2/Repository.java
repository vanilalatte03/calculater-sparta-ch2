package com.jiho.calculator2;

import java.util.ArrayList;
import java.util.List;

//저장소
public class Repository {
    private final List<Double> results = new ArrayList<>();

    public void save(double result) {
        this.results.add(result);
    }

    public void removeFirstResult(){
        results.removeFirst();
    }

    public List<Double> getResults(){
        return results;
    }

    //계산 기록 수정
    public void setSave(int index, Double num){
        results.set(index, num);
    }

    public List<Double> getLargeResult(double num){
        return results.stream()
                .filter(value -> value > num)
                .toList();
    }


}
