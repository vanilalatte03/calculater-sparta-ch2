package com.jiho.calculator2;

public class App {
    private final ArithmeticCalculator cal;
    private final HistoryManager historyManager;
    private final InputConsole inputConsole;

    public App(ArithmeticCalculator cal, HistoryManager historyManager, InputConsole inputConsole) {
        this.cal = cal;
        this.historyManager = historyManager;
        this.inputConsole = inputConsole;
    }

    //실행 부분
    public void run() {
        //종료 조건
        boolean running = true;

        while (running) {
            //계산기
            double finalResult = calculator();

            //계산 결과 저장
            System.out.println("계산 결과: " + finalResult);
            historyManager.saveResult(finalResult);

            //계산 기록
            historyManager.manageHistory();
            String choose = inputConsole.readContinue();
            if (choose.equals("exit")){
                running = false;
            }
        }
    }

    //계산기 입력
    private double calculator() {
        double result = inputConsole.readNumber();
        while(true){
            char operator = inputConsole.readOperator();
            //등호가 나오면 반복문 종료
            if (operator == '='){
                break;
            }

            double num = inputConsole.readNumber();
            //계산 메서드 호출
            try {
                result = cal.calculate(result, num, operator);
            } catch (ArithmeticException | IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return result;
    }

}
