package calculator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Calculator {
    /* 연산 결과를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    //초기화 시켜주는 부분
    private final Queue<Integer> results = new LinkedList<>();
    /* 원의 넓이를 저장하는 컬렉션 타입 필드 선언 및 생성 */
    private final List<Double> circleAreas = new ArrayList<>();

    //조회
    public Queue<Integer> getAllResults() {
        return results;
    }

    //추가
    public void setResult(int result) {
        results.add(result);
    }

    //삭제
    public void deleteResult() {
        results.poll();
    }


    //조회
    public List<Double> getCircleAreas() {
        return circleAreas;
    }

    //추가
    public void setCircleAreas(double circleArea) {
        circleAreas.add(circleArea);
    }

    //사칙연산 수행
    public int calculate(int x, String operator, int y) throws Exception {
        //연산자가 잘 들어왔는지, 분모가 0인지 체크후 익셉션처리
        try {
            //연산자 확인
            if (!operator.equals("+") && !operator.equals("-") && !operator.equals("*") && !operator.equals("/"))
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

    //원의 반지름 넓이 구하기
    //3.14를 곱해야하기때문에 타입 double 선언

    /**
     * static 미선언
     * 1. 이미 App 클래스에서, 사칙연산을 수행하기위해 인스턴스를 생성하였기떄문에, 클래스로드 시점에 사용되는 static 메서드의 이점을 활용 하기 어려움
     * final 선언
     * 1. 오버라이딩을 불가능하게 하여, 하위 클래스들에서도, 동일하게 사용가능하게 하기 위함
     */

    public final double calculateCircleArea(double radius) {
        return 3.14 * Math.pow(radius, 2);
    }
}
