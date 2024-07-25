package calculator.operators;

import calculator.util.GenericConvertOperator;
import calculator.interfaces.Operate;
import calculator.enums.OperatorType;

//뺄셈
//이후 수정 필요
public class DivideOperator<T extends Number, R extends Number> implements Operate<T, R> {
    private final Class<R> returnType;

    public DivideOperator(Class<R> returnType) {
        this.returnType = returnType;
    }

    @Override
    public R operate(T x, T y) {
        return GenericConvertOperator.genericOperator(x, OperatorType.DIV, y, returnType);
    }
}
