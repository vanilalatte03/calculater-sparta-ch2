package com.jiho.calculator2;

public class App {
    private final ArithmeticCalculator cal;
    private final Repository repository;
    private final InputConsole inputConsole;

    public App(ArithmeticCalculator cal, Repository repository, InputConsole inputConsole) {
        this.cal = cal;
        this.repository = repository;
        this.inputConsole = inputConsole;
    }

    //실행
    public void run() {
        boolean running = true;
        while (running) {
            //숫자 or 연산자 or = 입력
            String token = inputConsole.readToken();
            if(token.equals("=")){
                double result = cal.calculate(repository.getTokens());
                System.out.println("계산 결과: " + result);
                repository.clear();
                //종료 선택
                String choose = inputConsole.readContinue();
                if (choose.equals("exit")) running = false;
            } else {
                repository.save(token);
            }
        }
    }
}
