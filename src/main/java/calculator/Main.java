package calculator;

import calculator.caculators.ArithmeticCalculator;
import calculator.caculators.Calculator;
import calculator.caculators.CircleCalculator;
import calculator.enums.OperatorType;
import calculator.exception.HandleFirstInputMisMatchException;
import calculator.util.ConvertInput;
import calculator.util.GetMaxValue;

import java.util.*;

public class Main<T extends Number, R extends Number>  {
    private final Class<T> argType;
    private final Class<R> returnType;

    public Main(Class<T> argType, Class<R> returnType) {
        this.argType = argType;
        this.returnType = returnType;
        getMaxValue = new GetMaxValue<>(returnType);
    }

    public final GetMaxValue<T, R> getMaxValue;

    public void calculatorApp() throws Exception  {
        Scanner sc = new Scanner(System.in);
        Calculator<T, R> calculator = new Calculator<>();
        //사칙연산,원의넓이 클래스 인스턴스화
        ArithmeticCalculator<T, R> arithmeticCalculator = new ArithmeticCalculator<>(returnType);
        //값저장,getter,setter 등 있는 클래스 인스턴스화
        CircleCalculator circleCalculator = new CircleCalculator();
        String firstInput = null;
        while (true) {
            try {
                System.out.println("원의넓이를 구하시려면 '원의넓이', 사칙연산을 수행하시려면 '사칙연산'을 기재하세요");
                firstInput = sc.nextLine();
                if (!firstInput.equals("사칙연산") && !firstInput.equals("원의넓이")) throw new HandleFirstInputMisMatchException();
                else break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        /**
         * 1. 사칙연산,원의넓이 글자를 제외하곤 전부 exception 처리해야함
         */


        //while 문 제어 초기값
        boolean flag = true;

        while (flag) {
            if (firstInput.equals("사칙연산")) {
                //try내에 선언하면 스코프 문제로 하단의 catch, finally 구문에서 잡히지 않아서 상단에 선언
                R result = null;
                try {
                    //첫번째
                    System.out.print("첫 번째 숫자를 입력하세요: ");
                    String xInput = sc.nextLine();
                    // 체크 및 선언
                    T x = ConvertInput.convertInput(argType, xInput);

                    //연산자
                    System.out.print("사칙연산 기호를 입력하세요: ");
                    String operator = sc.nextLine();
                    // 체크 및 선언
                    OperatorType op = OperatorType.getOperator(operator);

                    //두번째
                    System.out.print("두 번째 숫자를 입력하세요: ");
                    String yInput = sc.nextLine();
                    // 체크 및 선언
                    T y = ConvertInput.convertInput(argType, yInput);

                    result = arithmeticCalculator.calculate(x, op, y);
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
                            calculator.removeResult();
                            break;
                        case "inquiry":
                            System.out.println(calculator.getResults());
                            break;
                        case "max":
                            System.out.println(getMaxValue.getResultMaxValue(calculator.getResults(), result));
                    }
                }
            } else if (firstInput.equals("원의넓이")) {
                //try내에 선언하면 스코프 문제로 하단의 catch, finally구문에서 잡히지 않아서 상단에 선언
                double result = 0;
                try {
                    //원의 반지름값 기재
                    System.out.println("원의 반지름값을 기재해주세요");
                    /**
                     * 1. 차라리 여기서 String 형태로 받고
                     * 2. 메서드를 호출해서 radius 를 Double 로 테스트해봐서 오류가 터지면
                     * 3. 그 메서드 안에서 throw 해서 에러가 던져지면
                     * 4. 그걸 여기서 받고, 그 에러를 출력해주는 느낌이 괜찮을듯?
                     * 5. 만약 에러가 안나면 double 타입으로 만들어서 돌려줍시다 ㅇㅇ;
                     */
                     String radiusInput = sc.nextLine();
                    double radius = ConvertInput.convertInput(Double.class,radiusInput);

                    //반지름값 저장 후, 세팅
                    result = circleCalculator.calculateCircleArea(radius);
                    System.out.println("원의 반지름 값 : " + circleCalculator.calculateCircleArea(radius));
                    System.out.println(" ");
                    calculator.setCircleArea(result);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                } finally {
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
                            System.out.println(getMaxValue.getCircleAreaMaxValue(calculator.getCircleAreas(), result));
                    }
                }



            }
        }
    }
}
