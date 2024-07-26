package calculator.caculators;

import calculator.enums.OperatorType;
import calculator.exception.HandleArithmeticException;
import calculator.exception.HandleOperatorMisMatchException;
import calculator.operators.*;

//사칙연산 계산 클래스
// T extends Number : T는 Number 타입중 하나다
public class ArithmeticCalculator<T extends Number, R extends Number> {
    private final Class<R> returnType;
    private final AddOperator<T, R> addOperator;
    private final DivideOperator<T, R> divideOperator;
    private final MultiplyOperator<T, R> multiplyOperator;
    private final SubtractOperator<T, R> subtractOperator;
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
    public R calculate(T x, OperatorType op, T y) throws Exception {
        //try 구문 안에있으니, 스코프 문제로 하단에서 op를 사용하지못함
        //연산자가 잘 들어왔는지, 분모가 0인지 체크후 익셉션처리
        try {
            //분모확인
            if (y.equals(0) && op.equals(OperatorType.SUB)) throw new HandleArithmeticException(y);
        } catch (HandleArithmeticException e) {
            throw e;
        }
        //문제없으면 연산 수행
        R result = null;
        if (op == OperatorType.PLUS) result = addOperator.operate(x, y);
        else if (op == OperatorType.DIV) result = divideOperator.operate(x, y);
        else if (op == OperatorType.MUL) result = multiplyOperator.operate(x, y);
        else if (op == OperatorType.SUB) result = subtractOperator.operate(x, y);
        else if (op == OperatorType.MOD) result = modOperator.operate(x, y);
        return result;
    }
}
