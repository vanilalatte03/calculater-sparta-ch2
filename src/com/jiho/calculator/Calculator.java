package com.jiho.calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    private final List<Integer> save = new ArrayList<>();

    int result = 0;
    //계산 메서드
    public int calculate(int n1, int n2, char operator){

        switch (operator) {
            case '+' :
                result = n1 + n2;
                break;
            case '-' :
                result = n1 - n2;
                break;
            case '*' :
                result = n1 * n2;
                break;
            case '/' :
                if(n2 != 0){
                    result = n1 / n2;
                } else{
                    System.out.println("니눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
                    break;
                }
                break;
            default:
                System.out.println("알맞은 사칙연산 기호를 입력해주세요.");
                break;
        }

        save.add(result);
        // System.out.println(save); 값 저장 확인용
        return result;
    }

    public void removeFirstResult(){
        save.removeFirst();
    }

    public List<Integer> getSave(){
        return save;
    }

    //계산 기록 수정
    public void setSave(int index, int num){
        save.set(index, num);
    }



}
