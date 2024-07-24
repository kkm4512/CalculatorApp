package calculator;

//나눗셈
public class SubtractOperator implements Operate {

    @Override
    public int operate(int x, int y) {
        return x / y;
    }
}
