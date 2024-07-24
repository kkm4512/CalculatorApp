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
    //나머지
    private final ModOperator modOperator = new ModOperator();

    //사칙연산 수행
    public int calculate(int x, String operator, int y) throws Exception {
        //try 구문 안에있으니, 스코프 문제로 하단에서 op를 사용하지못함
        OperatorType op;
        //연산자가 잘 들어왔는지, 분모가 0인지 체크후 익셉션처리
        try {
            //연산자 확인
            op = OperatorType.getOperator(operator);
            //분모확인
            if (y == 0) throw new HandleArithmeticException(y);

        } catch (HandleInputMisMatchException | HandleArithmeticException e) {
            throw e;
        }
        //문제없으면 연산 수행
        int result = 0;
        if (op == OperatorType.PLUS) result = addOperator.operate(x, y);
        else if (op == OperatorType.DIV) result = divideOperator.operate(x, y);
        else if (op == OperatorType.MUL) result = multiplyOperator.operate(x, y);
        else if (op == OperatorType.SUB) result = subtractOperator.operate(x, y);
        else if (op == OperatorType.MOD) result = modOperator.operate(x, y);
        return result;
    }
}
