package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //초기값
        int result = 0;
        //while 문 제어 초기값
        boolean flag = true;
        //results 배열에 하나씩 집어넣기 위한 idx
        int i = 0;
        // 10개를 초과하는 경우 가장 먼저 저장된결과를 삭제하고 새로운 연산결과가 저장 되어야하기때문에 FIFO 구조인 queue구조 선택
        Queue queue = new LinkedList<>();

        while (flag) {
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
            } finally {
                queue.add(result);
                System.out.println("더 계산하시겠습니까? (exit 입력 시 종료)");
                String input = sc.nextLine();
                if (input.equals("exit")) flag = !flag;
                else if (input.equals("remove")) queue.poll();
            }
        }
        //queue 배열 내부
        System.out.println(queue);
    }
}
