package calculator.enums;

import calculator.exception.HandleOperatorMisMatchException;

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
        /**
         *     PLUS("+"),
         *     DIV("-"),
         *     MUL("*"),
         *     SUB("/"),
         *     MOD("%");
         *     이것들을 하나씩 순회함
         */
        for (OperatorType op : OperatorType.values()) {
            if (op.getOperator().equals(operator)) return op;
        }
        throw new HandleOperatorMisMatchException(operator);
    }
}
