package com.jiho.calculator3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Repository repository = new Repository();
        ArithmeticCalculator calculator = new ArithmeticCalculator(repository);
        Scanner sc = new Scanner(System.in);
        InputConsole inputConsole = new InputConsole(sc, repository);

        App app = new App(calculator, inputConsole);
        app.run();
    }
}
