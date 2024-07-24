package calculator;


public class HandleArithmeticException extends Exception {
    public HandleArithmeticException(Object input) {
        super("Error : 당신이 입력한 분모 값은[" + input + "]이지만, 분모 값은 0이 들어 올 수 없습니다!");
    }
}
