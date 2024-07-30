package calculator.caculators;

import calculator.enums.OperatorType;
import calculator.exception.HandleArithmeticException;
import calculator.exception.HandleOperatorMisMatchException;
import calculator.interfaces.Operate;
import calculator.operators.*;

//사칙연산 계산 클래스
// T extends Number : T는 Number 타입중 하나다
public class ArithmeticCalculator<T extends Number, R extends Number> {
    private final Class<R> returnType;
    private Operate<T,R> operate;
    private final CalculatorFactory<T,R> calculatorFactory = new CalculatorFactory<>();

    //생성자
    public ArithmeticCalculator(Class<R> returnType) {
        this.returnType = returnType;
    }


    //사칙연산 수행
    public R calculate(T x, OperatorType op, T y) throws Exception {
        //연산자가 잘 들어왔는지, 분모가 0인지 체크후 익셉션처리
        try {
            //분모확인
            if ((y.equals(0L) || y.equals(0.0) || y.equals(0F) || y.equals(0)) && op.equals(OperatorType.SUB)) throw new HandleArithmeticException();
        } catch (HandleArithmeticException e) {
            throw e;
        }
        //문제없으면 연산 수행
        //다형성 이용하여 처리
        Operate<T,R> operatorObject = calculatorFactory.getOperatorObject(x, op, y, returnType);
        return operatorObject.operate(x,y);
    }
}
