package calculator;

import java.util.ArrayList;
import java.util.List;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    List<Integer> results = new ArrayList<>();

    public int calculate(int x, String operator, int y) throws Exception {
        //연산자가 잘 들어왔는지, 분모가 0인지 체크후 익셉션처리
        try {
            //연산자 확인
            if (operator.equals("+") && operator.equals("-") && operator.equals("*") && operator.equals("/"))
                throw new HandleInputMisMatchException(operator);
            //분모확인
            if (y == 0) throw new HandleArithmeticException(y);

        } catch (HandleInputMisMatchException e) {
            System.out.println(e.getMessage());
            //깅제 종료
            return -9999;
        } catch (HandleArithmeticException e) {
            System.out.println(e.getMessage());
            //깅제 종료
            return -9999;
        }
        //문제없으면 연산 수행
        int result = 0;
        if (operator.equals("+")) result = x + y;
        else if (operator.equals("-")) result = x - y;
        else if (operator.equals("*")) result = x * y;
        else result = x / y;
        return result;
    }
}
