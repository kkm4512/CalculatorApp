package calculator.util;

import calculator.enums.OperatorType;

//정적 메서드에 제네릭 타입을 넣어줘야할떄면, 제네릭은 독립적으로 움직이기떄문에, 따로 설정해줘야해서, 클래스 단에서 제네릭 설정 필요없음
public class GenericConvertOperator {
    public static <T extends Number, R extends Number> R genericOperator(T x, OperatorType operatorType, T y, Class<R> returnType) {
        //덧셈
        if (OperatorType.PLUS.equals(operatorType) ) {
            if (x instanceof Byte) return returnType.cast(Short.parseShort(x.toString()) + Short.parseShort(y.toString()));
            if (x instanceof Short) return returnType.cast(Integer.parseInt(x.toString()) + Integer.parseInt(y.toString()));
            if (x instanceof Integer) return returnType.cast(Long.parseLong(x.toString()) + Long.parseLong(y.toString()));
            if (x instanceof Long) return returnType.cast(Long.parseLong(x.toString()) + Long.parseLong(y.toString()));
            if (x instanceof Float) return returnType.cast(Double.parseDouble(x.toString()) + Double.parseDouble(y.toString()));
            if (x instanceof Double) return returnType.cast(Double.parseDouble(x.toString()) + Double.parseDouble(y.toString()));
        }
        //뺄셈
        if (OperatorType.DIV.equals(operatorType) ) {
            if (x instanceof Byte) return returnType.cast(Short.parseShort(x.toString()) - Short.parseShort(y.toString()));
            if (x instanceof Short) return returnType.cast(Integer.parseInt(x.toString()) - Integer.parseInt(y.toString()));
            if (x instanceof Integer) return returnType.cast(Long.parseLong(x.toString()) - Long.parseLong(y.toString()));
            if (x instanceof Long) return returnType.cast(Long.parseLong(x.toString()) - Long.parseLong(y.toString()));
            if (x instanceof Float) return returnType.cast(Double.parseDouble(x.toString()) - Double.parseDouble(y.toString()));
            if (x instanceof Double) return returnType.cast(Double.parseDouble(x.toString()) - Double.parseDouble(y.toString()));
        }
        //곱셈
        if (OperatorType.MUL.equals(operatorType) ) {
            if (x instanceof Byte) return returnType.cast(Short.parseShort(x.toString()) * Short.parseShort(y.toString()));
            if (x instanceof Short) return returnType.cast(Integer.parseInt(x.toString()) * Integer.parseInt(y.toString()));
            if (x instanceof Integer) return returnType.cast(Long.parseLong(x.toString()) * Long.parseLong(y.toString()));
            if (x instanceof Long) return returnType.cast(Long.parseLong(x.toString()) * Long.parseLong(y.toString()));
            if (x instanceof Float) return returnType.cast(Double.parseDouble(x.toString()) * Double.parseDouble(y.toString()));
            if (x instanceof Double) return returnType.cast(Double.parseDouble(x.toString()) * Double.parseDouble(y.toString()));
        }
        //나눗셈
        if (OperatorType.SUB.equals(operatorType) ) {
            if (x instanceof Byte) return returnType.cast(Short.parseShort(x.toString()) / Short.parseShort(y.toString()));
            if (x instanceof Short) return returnType.cast(Integer.parseInt(x.toString()) / Integer.parseInt(y.toString()));
            if (x instanceof Integer) return returnType.cast(Long.parseLong(x.toString()) / Long.parseLong(y.toString()));
            if (x instanceof Long) return returnType.cast(Long.parseLong(x.toString()) / Long.parseLong(y.toString()));
            if (x instanceof Float) return returnType.cast(Double.parseDouble(x.toString()) / Double.parseDouble(y.toString()));
            if (x instanceof Double) return returnType.cast(Double.parseDouble(x.toString()) / Double.parseDouble(y.toString()));
        }
        //나머지
        if (OperatorType.MOD.equals(operatorType) ) {
            if (x instanceof Byte) return returnType.cast(Short.parseShort(x.toString()) % Short.parseShort(y.toString()));
            if (x instanceof Short) return returnType.cast(Integer.parseInt(x.toString()) % Integer.parseInt(y.toString()));
            if (x instanceof Integer) return returnType.cast(Long.parseLong(x.toString()) % Long.parseLong(y.toString()));
            if (x instanceof Long) return returnType.cast(Long.parseLong(x.toString()) % Long.parseLong(y.toString()));
            if (x instanceof Float) return returnType.cast(Double.parseDouble(x.toString()) % Double.parseDouble(y.toString()));
            if (x instanceof Double) return returnType.cast(Double.parseDouble(x.toString()) % Double.parseDouble(y.toString()));
        }

        return null;
    }

}
