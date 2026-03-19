package com.jiho.calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculator cal = new Calculator();

        //종료 조건
        boolean running = true;

        while (running) {
            System.out.println("첫 번째 숫자를 입력하세요.");
            int n1 = sc.nextInt();

            System.out.println("두 번째 숫자를 입력하세요.");
            int n2 = sc.nextInt();

            System.out.println("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);

            //계산 메서드 호출
            int result = cal.calculate(n1, n2, operator);
            System.out.println("결과: " + result);

            System.out.println("계산 기록 " + cal.getSave());

            System.out.println("더 계산하시겠습니까? (exit 입력 시만 종료)");
            String choose = sc.next();
            if (choose.equals("exit")){
                running = false;
            }
        }

    }
}