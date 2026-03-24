package com.jiho.calculator2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArithmeticCalculator calculator = new ArithmeticCalculator();
        Repository repository = new Repository();
        Scanner sc = new Scanner(System.in);
        InputConsole inputConsole = new InputConsole(sc);
        HistoryManager historyManager = new HistoryManager(repository, inputConsole);

        App app = new App(calculator, historyManager, inputConsole);
        app.run();
    }
}
