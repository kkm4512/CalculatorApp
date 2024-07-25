package calculator;

//T 매개변수 타입
//R return 타입
public class AddOperator<T extends Number, R extends Number> implements Operate<T, R> {
    @Override
    public R operate(T x, T y) {
        return GenericConvertOperator.genericOperator(x, OperatorType.PLUS, y);
    }
}
