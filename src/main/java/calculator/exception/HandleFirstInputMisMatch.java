package calculator.exception;

//맨처음 사칙연산,원의넓이가 아닌 다른 글자가 들어왔을때
public class HandleFirstInputMisMatch extends Exception {
    public HandleFirstInputMisMatch(){
        super("'원의넓이' 또는 '사칙연산' 을 정확히 기재해주세요");
    }
}
