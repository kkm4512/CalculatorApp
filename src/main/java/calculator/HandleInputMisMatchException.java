package calculator;

public class HandleInputMisMatchException extends Exception {
    public HandleInputMisMatchException(Object input) {
        super("Error : 당신이 입력한 연산자 값은 [" + input + "]이지만, 연산자 값은 +,-,*,/,% 만 들어올수 있습니다 !");
    }
}
