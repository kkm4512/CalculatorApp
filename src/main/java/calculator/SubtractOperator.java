package calculator;

import calculator.enums.OperatorType;
import calculator.util.GenericConvertOperator;

//나눗셈
//이후 수정 필요
public class SubtractOperator<T extends Number, R extends Number> implements Operate<T, R> {
    private final Class<R> returnType;

    public SubtractOperator(Class<R> returnType) {
        this.returnType = returnType;
    }

    @Override
    public R operate(T x, T y) {
        return GenericConvertOperator.genericOperator(x, OperatorType.SUB, y, returnType);
    }
}
