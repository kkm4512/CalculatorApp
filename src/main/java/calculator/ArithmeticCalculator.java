package calculator;

//사칙연산 계산 클래스
public class ArithmeticCalculator {
    //덧셈
    private final AddOperator addOperator = new AddOperator();
    //뺄셈
    private final DivideOperator divideOperator = new DivideOperator();
    //곱셈
    private final MultiplyOperator multiplyOperator = new MultiplyOperator();
    //나눗셈
    private final SubtractOperator subtractOperator = new SubtractOperator();

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
        if (operator.equals("+")) result = addOperator.operate(x, y);
        else if (operator.equals("-")) result = divideOperator.operate(x, y);
        else if (operator.equals("*")) result = multiplyOperator.operate(x, y);
        else result = subtractOperator.operate(x, y);
        return result;
    }
}
