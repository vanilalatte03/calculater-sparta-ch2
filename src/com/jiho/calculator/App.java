package com.jiho.calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("첫 번째 숫자를 입력하세요.");
        int n1 = sc.nextInt();
        System.out.println("두 번째 숫자를 입력하세요.");
        int n2 = sc.nextInt();

        System.out.println("사칙연산 기호를 입력하세요: ");
        char Operator = sc.next().charAt(0);

        int result = 0;
        switch (Operator) {
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
                    return;
                }
                break;
            default:
                System.out.println("알맞은 사칙연산 기호를 입력해주세요.");
                return;
        }

        System.out.println("결과: " + result);

    }
}