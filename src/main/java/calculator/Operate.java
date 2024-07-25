package calculator;

public interface Operate<T, R> {
    R operate(T x, T y);
}
