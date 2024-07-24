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


}


