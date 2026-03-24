package com.jiho.calculator2;

public class HistoryManager {
    private final Repository repository;
    private final InputConsole inputConsole;

    public HistoryManager(Repository repository, InputConsole inputConsole) {
        this.repository = repository;
        this.inputConsole = inputConsole;
    }

    public void saveResult(double result) {
        repository.save(result);
    }

    //계산 기록 총괄 메서드
    public void manageHistory() {
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
