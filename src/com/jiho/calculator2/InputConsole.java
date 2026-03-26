package com.jiho.calculator2;

import java.util.Scanner;

public class InputConsole {
    private final Scanner sc;
    private final Repository repository;

    public InputConsole(Scanner sc, Repository repository) {
        this.sc = sc;
        this.repository = repository;
    }

    public String readToken() {
        System.out.println("숫자, 사칙연산 기호, = 중 하나를 입력하세요.");
        String token = sc.nextLine();
        if(!token.equals("=")){
            repository.save(token);
        }
        return token;
    }

    public String readContinue() {
        System.out.println("더 계산하시겠습니까? (y/exit)");
        return sc.nextLine();
    }
}
