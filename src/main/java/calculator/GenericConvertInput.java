package calculator;

public class GenericConvertInput {
    public static <T extends Number> T GenericConvertInput(Class<T> argType, String x) {
        if (argType == Byte.class) return argType.cast(Byte.parseByte(x));
        if (argType == Short.class) return argType.cast(Short.parseShort(x));
        if (argType == Integer.class) return argType.cast(Integer.parseInt(x));
        if (argType == Long.class) return argType.cast(Long.parseLong(x));
        if (argType == Float.class) return argType.cast(Float.parseFloat(x));
        if (argType == Double.class) return argType.cast(Double.parseDouble(x));
        throw new IllegalArgumentException("올바른 매개 변수가 들어오지 않았습니다");
    }

}
