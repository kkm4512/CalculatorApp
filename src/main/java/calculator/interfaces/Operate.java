package calculator.interfaces;

public interface Operate<T, R> {
    R operate(T x, T y);
}
