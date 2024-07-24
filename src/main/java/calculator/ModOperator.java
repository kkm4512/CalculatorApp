package calculator;

//나머지
public class ModOperator implements Operate {
    @Override
    public int operate(int x, int y) {
        return x % y;
    }
}
