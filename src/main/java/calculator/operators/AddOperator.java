package calculator.operators;

import calculator.util.GenericConvertOperator;
import calculator.interfaces.Operate;
import calculator.enums.OperatorType;

//T 매개변수 타입
//R return 타입
public class AddOperator<T extends Number, R extends Number> implements Operate<T, R> {
    private final Class<R> returnType;

    public AddOperator(Class<R> returnType) {
        this.returnType = returnType;
    }

    @Override
    public R operate(T x, T y) {
        return GenericConvertOperator.genericOperator(x, OperatorType.PLUS, y, returnType);
    }
}
