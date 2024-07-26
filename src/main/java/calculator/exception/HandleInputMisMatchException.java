package calculator.exception;

//피연산자가 숫자가 아닐경우 내보낼 exception
public class HandleInputMisMatchException extends Exception{
    public HandleInputMisMatchException(String input){
        super("에러 : 입력받은 [" + input +"] 값은, 숫자가 아닙니다!");
    }
}
