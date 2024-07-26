package calculator.exception;

//맨처음 사칙연산,원의넓이가 아닌 다른 글자가 들어왔을때
public class HandleFirstInputMisMatchException extends Exception {
    public HandleFirstInputMisMatchException(){
        super("에러 : '원의넓이' 또는 '사칙연산' 을 정확히 기재해주세요");
    }
}
