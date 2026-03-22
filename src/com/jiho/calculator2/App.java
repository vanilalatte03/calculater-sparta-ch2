package com.jiho.calculator2;

import java.util.Scanner;
//추가 도전
public class App {
    private final Scanner sc = new Scanner(System.in);
    private final ArithmeticCalculator<Double> cal = new ArithmeticCalculator<>();
    private final Repository repository = new Repository();

    //프로그램 시작
    public static void main(String[] args) {
        new App().run();
    }

    //실행 부분
    public void run() {
        //종료 조건
        boolean running = true;

        while (running) {
            System.out.println("숫자를 입력하세요.");
            double result = sc.nextDouble();

            while(true){
                System.out.println("사칙연산 기호나 =를 입력하세요.");
                char operator = sc.next().charAt(0);

                //등호가 나오면 반복문 종료
                if (operator == '='){
                    break;
                }

                System.out.println("숫자를 입력하세요.");
                double num = sc.nextDouble();

                //계산 메서드 호출
                try {
                    result = cal.calculate(result, num, operator);
                } catch (ArithmeticException | IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            }

            System.out.println("계산 결과: " + result);
            repository.save(result);

            //계산 기록
            history();

            System.out.println("더 계산하시겠습니까? (y/exit)");
            String choose = sc.next();
            if (choose.equals("exit")){
                running = false;
            }
        }
    }

    //계산 기록 관련 메서드
    public void history() {
        //계산 기록 조회
        System.out.println("계산 기록 " + repository.getResults());

        //계산 기록 수정
        System.out.println("계산 기록을 수정하시겠습니까? (y/n))");
        String s1 = sc.next();
        if(s1.equals("y")){
            System.out.println("계산 기록 " + repository.getResults());
            System.out.println("수정할 순번을 선택해주세요");
            int index = sc.nextInt();
            System.out.println("바꿀 번호를 입력해주세요");
            double num = sc.nextDouble();
            repository.setSave(index - 1, num);
        }

        //입력값보다 큰 결과값 출력
        System.out.println("값을 입력해주세요. 더 큰 결과값만 출력됩니다.");
        double value = sc.nextDouble();
        System.out.println("입력값보다 큰 결과: " + repository.getLargeResult(value));

        //첫 번째 계산 기록 삭제
        System.out.println("첫 번째 계산 기록을 삭제 하시겠습니까? (y/n)");
        String s2 = sc.next();
        if(s2.equals("y")){
            repository.removeFirstResult();
        }

    }
}