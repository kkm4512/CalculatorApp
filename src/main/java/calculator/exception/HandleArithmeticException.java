package calculator.exception;


public class HandleArithmeticException extends Exception {
    public HandleArithmeticException() {
        super("에러 : 당신이 입력한 분모 값은 0 이지만, 분모 값은 0 이 들어 올 수 없습니다!");
    }
}
