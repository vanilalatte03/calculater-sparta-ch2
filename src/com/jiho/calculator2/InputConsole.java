package com.jiho.calculator2;

import java.util.Scanner;

public class InputConsole {
    private final Scanner sc;

    public InputConsole(Scanner sc) {
        this.sc = sc;
    }

    public double readNumber() {
        System.out.println("숫자를 입력하세요.");
        return sc.nextDouble();
    }

    public char readOperator() {
        System.out.println("사칙연산 기호나 =를 입력하세요.");
        return sc.next().charAt(0);
    }

    public String readContinue() {
        System.out.println("더 계산하시겠습니까? (y/exit)");
        return sc.next();
    }

    public String readEdit() {
        System.out.println("계산 기록을 수정하시겠습니까? (y/n))");
        return sc.next();
    }

    public int readHistoryIndex() {
        System.out.println("수정할 순번을 선택해주세요");
        return sc.nextInt();
    }

    public double readHistoryValue() {
        System.out.println("바꿀 번호를 입력해주세요");
        return sc.nextDouble();
    }

    public double readLargeValue() {
        System.out.println("값을 입력해주세요. 더 큰 결과값만 출력됩니다.");
        return sc.nextDouble();
    }

    public String readDeleteFirstValue() {
        System.out.println("첫 번째 계산 기록을 삭제 하시겠습니까? (y/n)");
        return sc.next();
    }

}
