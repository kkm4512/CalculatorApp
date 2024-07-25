package calculator;

//뺄셈
//이후 수정 필요
public class DivideOperator<T extends Number, R extends Number> implements Operate<T, R> {

    @Override
    public R operate(T x, T y) {
        return GenericConvertOperator.genericOperator(x, OperatorType.DIV, y);
    }
}
