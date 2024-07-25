package calculator.operators;

import calculator.util.GenericConvertOperator;
import calculator.interfaces.Operate;
import calculator.enums.OperatorType;

//곱셈
//이후 수정 필요
public class MultiplyOperator<T extends Number, R extends Number> implements Operate<T, R> {
    private final Class<R> returnType;

    public MultiplyOperator(Class<R> returnType) {
        this.returnType = returnType;
    }

    @Override
    public R operate(T x, T y) {
        return GenericConvertOperator.genericOperator(x, OperatorType.MUL, y, returnType);
    }
}
