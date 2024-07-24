package calculator;

//상수의 집합
public enum OperatorType {
    PLUS("+"),
    DIV("-"),
    MUL("*"),
    SUB("/"),
    MOD("%");

    private final String operator;

    OperatorType(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }

    public static OperatorType getOperator(String operator) throws Exception {
        for (OperatorType op : OperatorType.values()) {
            if (op.getOperator().equals(operator)) return op;
        }
        throw new HandleInputMisMatchException(operator);
    }
}
