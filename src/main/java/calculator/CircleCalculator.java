package calculator;

//원의넓이 계산 클래스
public class CircleCalculator {
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
