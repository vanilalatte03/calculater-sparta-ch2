package com.jiho.calculator4;

public class CalculatorApp {
    private final ConsoleInputView inputView;
    private final InputValidator validator;
    private final ExpressionRepository repository;
    private final CalculatorService calculatorService;

    public CalculatorApp(
            ConsoleInputView inputView,
            InputValidator validator,
            ExpressionRepository repository,
            CalculatorService calculatorService
    ) {
        this.inputView = inputView;
        this.validator = validator;
        this.repository = repository;
        this.calculatorService = calculatorService;
    }

    public void run() {
        boolean running = true;

        while (running) {
            repository.clear();

            try {
                collectExpression();
                double result = calculatorService.calculate(repository.getTokens());
                inputView.printResult(result);
            } catch (IllegalArgumentException | ArithmeticException e) {
                inputView.printError(e.getMessage());
            }

            running = inputView.askToContinue();
        }
    }

    private void collectExpression() {
        repository.addToken(readNumber("첫 번째 숫자를 입력하세요."));

        while (true) {
            String operatorOrEqual = readOperatorOrEqual();
            if ("=".equals(operatorOrEqual)) {
                return;
            }

            repository.addToken(operatorOrEqual);
            repository.addToken(readNumber("다음 숫자를 입력하세요."));
        }
    }

    private String readNumber(String prompt) {
        while (true) {
            String input = inputView.readLine(prompt);
            if (validator.isNumber(input)) {
                return input;
            }
            inputView.printError("숫자 형식만 입력할 수 있습니다.");
        }
    }

    private String readOperatorOrEqual() {
        while (true) {
            String input = inputView.readLine("연산 기호(+,-,*,/) 또는 = 를 입력하세요.");
            if (validator.isOperatorOrEqual(input)) {
                return input;
            }
            inputView.printError("지원하는 연산 기호 또는 = 만 입력할 수 있습니다.");
        }
    }
}
