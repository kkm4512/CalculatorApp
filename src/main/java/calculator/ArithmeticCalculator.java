package calculator;

import calculator.exception.HandleArithmeticException;
import calculator.exception.HandleInputMisMatchException;
import calculator.operators.AddOperator;
import calculator.operators.DivideOperator;
import calculator.operators.ModOperator;
import calculator.operators.MultiplyOperator;

//사칙연산 계산 클래스
// T extends Number : T는 Number 타입중 하나다
public class ArithmeticCalculator<T extends Number, R extends Number> {
    private final Class<R> returnType;
    //덧셈
    private final AddOperator<T, R> addOperator;
    //뺄셈
    private final DivideOperator<T, R> divideOperator;
    //곱셈
    private final MultiplyOperator<T, R> multiplyOperator;
    //나눗셈
    private final SubtractOperator<T, R> subtractOperator;
    //나머지
    private final ModOperator<T, R> modOperator;

    //생성자
    public ArithmeticCalculator(Class<R> returnType) {
        this.returnType = returnType;
        addOperator = new AddOperator<>(this.returnType);
        divideOperator = new DivideOperator<>(this.returnType);
        multiplyOperator  = new MultiplyOperator<>(this.returnType);
        subtractOperator   = new SubtractOperator<>(this.returnType);
        modOperator = new ModOperator<>(this.returnType);
    }


    //사칙연산 수행
    public R calculate(T x, String operator, T y) throws Exception {
        //try 구문 안에있으니, 스코프 문제로 하단에서 op를 사용하지못함
        OperatorType op;
        //연산자가 잘 들어왔는지, 분모가 0인지 체크후 익셉션처리
        try {
            //연산자 확인
            op = OperatorType.getOperator(operator);
            //분모확인
            if (y.equals(0) && operator.equals("/")) throw new HandleArithmeticException(y);

        } catch (HandleInputMisMatchException | HandleArithmeticException e) {
            throw e;
        }
        //문제없으면 연산 수행
        R result = null;
        if (op == OperatorType.PLUS) result = addOperator.operate(x, y);
        else if (op == OperatorType.DIV) result = divideOperator.operate(x, y);
        else if (op == OperatorType.MUL) result = multiplyOperator.operate(x, y);
        else if (op == OperatorType.SUB) result = subtractOperator.operate(x, y);
        else if (op == OperatorType.MOD) result = modOperator.operate(x, y);
//        return result;
        return result;
    }
}
