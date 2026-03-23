# JAVA 계산기

### 프로젝트 소개
간단한 자바 콘솔 계산기입니다.

## 진행 목표
- 사칙연산 기능을 구현한다.
- 연산 결과 저장, 조회, 수정, 삭제 기능을 구현한다.
- enum, 제네릭, 스트림, 람다를 활용한 리팩토링을 진행한다.
- 예외 처리를 한다.

## 파일 구조
```text
/calculator2
├── App.java
├── ArithmeticCalculator.java
├── OperatorType.java 
└── Repository.java
```
- `App` : 프로그램 실행과 사용자 입력 흐름 담당
- `ArithmeticCalculator` : 계산 로직 담당
- `OperatorType` : 연산자별 기능을 enum으로 관리
- `Repository` : 연산 결과 저장 및 조회 담당
 
## 구현 내용
- 사칙연산과 '='가 나올 때 까지 순차적 연산 기능
- 연산 결과 저장, 조회, 수정, 삭제 기능
- enum, 제네릭, 스트림, 람다를 활용한 리팩토링
- 예외 처리
- 저장소 클래스 분리
- 기능 별 메서드 분류

## 실행 환경
- Java 17
- IntelliJ IDEA

## 최종 결과
<img width="439" height="874" alt="image" src="https://github.com/user-attachments/assets/591a92ee-d950-4252-bc48-e7b98dca1a82" />




