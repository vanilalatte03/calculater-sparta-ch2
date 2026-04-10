package com.jiho.calculator3;

public class App {
    private final ArithmeticCalculator cal;
    private final InputConsole inputConsole;

    public App(ArithmeticCalculator cal, InputConsole inputConsole) {
        this.cal = cal;
        this.inputConsole = inputConsole;
    }

    //실행
    public void run() {
        boolean running = true;
        while (running) {
            //숫자 or 연산자 or = 입력
            String token = inputConsole.readToken();
            if(token.equals("=")) {
                double result = cal.calculate();
                System.out.println("계산결과: " + result);
                //종료 선택
                String choose = inputConsole.readContinue();
                if (choose.equals("exit")) {
                    running = false;
                }
            }
        }
    }

}
