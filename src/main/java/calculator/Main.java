package calculator;

import java.util.*;

public class Main<T extends Number, R extends Number> {
    private final Class<T> argType;
    private final Class<R> returnType;

    public Main(Class<T> argType, Class<R> returnType) {
        this.argType = argType;
        this.returnType = returnType;
        getMaxValue = new GetMaxValue<>(returnType);
    }

    public final GetMaxValue<T, R> getMaxValue;

    public void calculatorApp() throws Exception {
        Scanner sc = new Scanner(System.in);
        Calculator<T, R> calculator = new Calculator<>();
        //사칙연산,원의넓이 클래스 인스턴스화
        ArithmeticCalculator<T, R> arithmeticCalculator = new ArithmeticCalculator<>(returnType);
        CircleCalculator circleCalculator = new CircleCalculator();
        System.out.println("원의넓이를 구하시려면 '원의넓이', 사칙연산을 수행하시려면 '사칙연산'을 기재하세요");
        String firstInput = sc.nextLine();

        //while 문 제어 초기값
        boolean flag = true;


        while (flag) {
            if (firstInput.equals("사칙연산")) {
                //첫번째 숫자
                System.out.print("첫 번째 숫자를 입력하세요: ");
                String xInput = sc.nextLine();
                T x = GenericConvertInput.GenericConvertInput(argType, xInput);

                //연산자
                System.out.print("사칙연산 기호를 입력하세요: ");
                String operator = sc.nextLine();

                //두번째 숫자
                System.out.print("두 번째 숫자를 입력하세요: ");
                String yInput = sc.nextLine();
                T y = GenericConvertInput.GenericConvertInput(argType, yInput);
                R result = null;
                try {
                     result = arithmeticCalculator.calculate(x, operator, y);
                    System.out.println("결과: " + result);
                    //하나씩 저장
                    calculator.setResult(result);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
                    System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                    System.out.println("추천 명령어 : remove,inquiry,max");
                    String input = sc.nextLine();
                    switch (input) {
                        case "exit":
                            flag = !flag;
                            break;
                        case "remove":
                            calculator.deleteResult();
                            break;
                        case "inquiry":
                            System.out.println(calculator.getAllResults());
                            break;
                        case "max":
                            System.out.println(getMaxValue.getResultMaxValue(calculator.getAllResults(),result));
                    }
                }
            } else if (firstInput.equals("원의넓이")) {
                //원의 반지름값 기재
                System.out.println("원의 반지름값을 기재해주세요");
                double radius = sc.nextDouble();
                sc.nextLine();

                //반지름값 저장 후, 세팅
                double result = circleCalculator.calculateCircleArea(radius);
                System.out.println("원의 반지름 값 : " + circleCalculator.calculateCircleArea(radius));
                System.out.println(" ");
                calculator.setCircleArea(result);

                System.out.println("더 추가하시겠습니까? (exit 입력 시 종료)");
                System.out.println("추천 명령어 : remove,inquiry,max");
                String input = sc.nextLine();
                switch (input) {
                    case "exit":
                        flag = !flag;
                        break;
                    case "remove":
                        calculator.deleteCircleArea();
                        break;
                    case "inquiry":
                        System.out.println(calculator.getCircleAreas());
                        break;
                    case "max":
                        System.out.println(getMaxValue.getCircleAreaMaxValue(calculator.getCircleAreas(), radius));
                }

            }
        }
    }
}
