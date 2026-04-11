package com.jiho.calculator4;

import java.util.Scanner;

public class ConsoleInputView {
    private final Scanner scanner;

    public ConsoleInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public String readLine(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine().trim();
    }

    public void printResult(double result) {
        System.out.println("계산 결과: " + formatNumber(result));
    }

    public void printError(String message) {
        System.out.println("오류: " + message);
    }

    public boolean askToContinue() {
        String input = readLine("계속 계산하려면 y, 종료하려면 exit를 입력하세요.");
        return !input.equalsIgnoreCase("exit");
    }

    private String formatNumber(double value) {
        if (value == (long) value) {
            return String.valueOf((long) value);
        }
        return String.valueOf(value);
    }
}
