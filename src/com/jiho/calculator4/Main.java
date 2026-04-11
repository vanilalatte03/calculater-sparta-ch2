package com.jiho.calculator4;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ConsoleInputView inputView = new ConsoleInputView(scanner);
        InputValidator validator = new InputValidator();
        ExpressionRepository repository = new ExpressionRepository();
        CalculatorService calculatorService = new CalculatorService();

        CalculatorApp app = new CalculatorApp(inputView, validator, repository, calculatorService);
        app.run();
    }
}
