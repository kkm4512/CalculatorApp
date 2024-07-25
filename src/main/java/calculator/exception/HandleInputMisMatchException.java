package calculator.exception;

//피연산자가 숫자가 아닐경우 내보낼 exception
public class HandleInputMisMatchException extends Exception{
    public HandleInputMisMatchException(){
        super("피연산자의 타입이 숫자가 아닙니다 !");
    }
}
