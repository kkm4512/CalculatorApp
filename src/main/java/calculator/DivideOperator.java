package calculator;

//뺄셈
public class DivideOperator implements Operate {

    @Override
    public int operate(int x, int y) {
        return x - y;
    }
}
