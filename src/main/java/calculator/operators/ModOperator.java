package calculator.operators;

import calculator.util.GenericConvertOperator;
import calculator.Operate;
import calculator.OperatorType;

//나머지
//이후 수정 필요
public class ModOperator<T extends Number, R extends Number> implements Operate<T, R> {
    private final Class<R> returnType;

    public ModOperator(Class<R> returnType) {
        this.returnType = returnType;
    }
    @Override
    public R operate(T x, T y) {
        return GenericConvertOperator.genericOperator(x, OperatorType.MOD, y, returnType);
    }
}
