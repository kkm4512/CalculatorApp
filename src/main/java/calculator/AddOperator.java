package calculator;

//덧셈
public class AddOperator implements Operate {

    @Override
    public int operate(int x, int y) {
        return x + y;
    }
}
