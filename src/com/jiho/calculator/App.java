package com.jiho.calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticCalculator<Double> cal = new ArithmeticCalculator();

        //종료 조건
        boolean running = true;

        while (running) {
            System.out.println("첫 번째 숫자를 입력하세요.");
            double n1 = sc.nextInt();
            System.out.println("사칙연산 기호를 입력하세요: ");
            char operator = sc.next().charAt(0);
            System.out.println("두 번째 숫자를 입력하세요.");
            double n2 = sc.nextInt();

            //계산 메서드 호출
            double result = cal.calculate(n1, n2, operator);
            System.out.println("결과: " + result);

            //계산 기록 조회 (getter)
            System.out.println("계산 기록 " + cal.getSave());

            //계산 기록 수정 (setter)
            System.out.println("계산 기록을 수정하시겠습니까? (y/n))");
            String s1 = sc.next();
            if(s1.equals("y")){
                System.out.println("계산 기록 " + cal.getSave());
                System.out.println("수정할 순번을 선택해주세요");
                int index = sc.nextInt();
                System.out.println("바꿀 번호를 입력해주세요");
                double num = sc.nextInt();
                cal.setSave(index - 1, num);
            }

            //첫 번째 계산 기록 삭제
            System.out.println("첫 번째 계산 기록을 삭제 하시겠습니까? (y/n)");
            String s2 = sc.next();
            if(s2.equals("y")){
                cal.removeFirstResult();
            }

            System.out.println("더 계산하시겠습니까? (y/exit)");
            String choose = sc.next();
            if (choose.equals("exit")){
                running = false;
            }
        }

    }
}