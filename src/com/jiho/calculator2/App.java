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

    //실행 부분
    public void run() {
        //종료 조건
        boolean running = true;

        while (running) {
            //계산기
            double finalResult = calculator();

            System.out.println("계산 결과: " + finalResult);
            repository.save(finalResult);

            //계산 기록
            manageHistory();
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

    //계산 기록 총괄 메서드
    private void manageHistory() {
        System.out.println("계산 기록 " + repository.getResults());

        editHistory();
        printLargeHistory();
        deleteFirstHistory();
    }

    //계산 기록 수정
    private void editHistory(){
        String choose = inputConsole.readEdit();
        if(choose.equals("y")){
            System.out.println("계산 기록 " + repository.getResults());
            int index = inputConsole.readHistoryIndex();
            double value = inputConsole.readHistoryValue();
            repository.updateAt(index - 1, value);
        }
    }

    //입력값보다 큰 결과값 출력
    private void printLargeHistory() {
        double value = inputConsole.readLargeValue();
        System.out.println("입력값보다 큰 결과: " + repository.getLargeResult(value));
    }

    //첫 번째 계산 기록 삭제
    private void deleteFirstHistory() {
        String value = inputConsole.readDeleteFirstValue();
        if(value.equals("y")){
            repository.removeFirstResult();
        }
    }
}
