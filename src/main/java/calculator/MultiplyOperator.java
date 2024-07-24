package calculator;

//곱셈
public class MultiplyOperator implements Operate {

    @Override
    public int operate(int x, int y) {
        return x * y;
    }
}
