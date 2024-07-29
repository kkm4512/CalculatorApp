package calculator.caculators;

import calculator.enums.OperatorType;
import calculator.interfaces.Operate;
import calculator.operators.*;

//현재 다형성의 원리를 제대로 이용하고있지 못하여, 다형성을 황용하여 리팩토링 시도
public class CalculatorFactory<T extends Number, R extends Number> {
    public Operate<T,R> getOperatorObject(T x,OperatorType op,T y ,Class<R> returnType){
        return switch (op) {
            case PLUS -> new AddOperator<T,R>(returnType);
            case DIV -> new DivideOperator<T,R>(returnType);
            case MUL -> new MultiplyOperator<T,R>(returnType);
            case SUB -> new SubtractOperator<T,R>(returnType);
            case MOD -> new ModOperator<T,R>(returnType);
        };
    }
}
