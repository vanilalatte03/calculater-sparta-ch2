package com.jiho.calculator2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        Repository repository = new Repository();
        Scanner sc = new Scanner(System.in);
        InputConsole inputConsole = new InputConsole(sc);

        App app = new App(calculator, repository, inputConsole);
        app.run();
    }
}
