package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //초기값
        int result = 0;
        //while 문 제어 초기값
        boolean flag = true;
        //첫번째 숫자
        System.out.print("첫 번째 숫자를 입력하세요: ");
        int x = sc.nextInt();

        //연산자
        //nextInt() 같은경우 끝에 개행문자가 포함되기때문에, 바로 nextLine() 찍으면 공백만 찍혀서, 한번 미리 써주고 개행문자 스킵
        sc.nextLine();
        System.out.print("사칙연산 기호를 입력하세요: ");
        char operator = sc.nextLine().charAt(0);

        //두번째 숫자
        System.out.print("두 번째 숫자를 입력하세요: ");
        int y = sc.nextInt();
        sc.nextLine();

        try {
            switch (operator) {
                case '+':
                    result = x + y;
                    System.out.println("결과: " + result);
                    break;
                case '-':
                    result = x - y;
                    System.out.println("결과: " + result);
                    break;
                case '*':
                    result = x * y;
                    System.out.println("결과: " + result);
                    break;
                case '/':
                    result = x / y;
                    System.out.println("결과: " + result);
                    break;
            }
            //분모가 0일떄 내뱉는 에러
        } catch (ArithmeticException  e) {
            System.out.println("나눗셈 연산에서 분모(두번째 정수)에 0이 입력될 수 없습니다.");
        }
    }
}
