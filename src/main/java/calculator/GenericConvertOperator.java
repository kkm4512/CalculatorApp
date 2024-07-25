package calculator;

//정적 메서드에 제네릭 타입을 넣어줘야할떄면, 제네릭은 독립적으로 움직이기떄문에, 따로 설정해줘야해서, 클래스 단에서 제네릭 설정 필요없음
public class GenericConvertOperator {
    public static <T extends Number, R extends Number> R genericOperator(T x, OperatorType operatorType, T y) {
        if (x instanceof Byte) return (R) Short.valueOf((short) (x.byteValue() + y.byteValue()));
        if (x instanceof Short) return (R) Integer.valueOf((int) (x.intValue() + y.intValue()));
        if (x instanceof Integer) return (R) Long.valueOf((long) (x.longValue() + y.longValue()));
        if (x instanceof Long) return (R) Long.valueOf((long) (x.longValue() + y.longValue()));
        if (x instanceof Float) return (R) Double.valueOf((double) (x.floatValue() + y.floatValue()));
        if (x instanceof Double) return (R) Double.valueOf((double) (x.doubleValue() + y.doubleValue()));
        return null;
    }

}
