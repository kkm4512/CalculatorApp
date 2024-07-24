package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        Calculator calculator = new Calculator();

        //while 문 제어 초기값
        boolean flag = true;

        while (flag) {
            //첫번째 숫자
            System.out.print("첫 번째 숫자를 입력하세요: ");
            int x = sc.nextInt();

            //연산자
            //nextInt() 같은경우 끝에 개행문자가 포함되기때문에, 바로 nextLine() 찍으면 공백만 찍혀서, 한번 미리 써주고 개행문자 스킵
            sc.nextLine();
            System.out.print("사칙연산 기호를 입력하세요: ");
            String operator = sc.nextLine();

            //두번째 숫자
            System.out.print("두 번째 숫자를 입력하세요: ");
            int y = sc.nextInt();
            sc.nextLine();
            try {
                int result = calculator.calculate(x, operator, y);
                //하나씩 저장
                calculator.setResult(result);
            } finally {
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
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
                }
            }
        }
    }
}
