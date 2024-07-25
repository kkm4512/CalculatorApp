package calculator;

//나머지
//이후 수정 필요
public class ModOperator<T extends Number, R extends Number> implements Operate<T, R> {
    @Override
    public R operate(T x, T y) {
        return GenericConvertOperator.genericOperator(x, OperatorType.MOD, y);
    }
}
