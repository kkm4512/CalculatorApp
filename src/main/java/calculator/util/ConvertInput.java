package calculator.util;

import calculator.exception.HandleInputMisMatchException;

//피연산자가 숫자타입인지 체크, 변환후 return
public class ConvertInput {
    public static <T extends Number> T convertInput(Class<T> argType, String input) throws Exception {
        //input 으로 들어온값이 숫자가 아니라면 에러를 던짐
        if (!checkNumberType(input)) throw new HandleInputMisMatchException(input);
        if (argType == Byte.class) return argType.cast(Byte.parseByte(input));
        if (argType == Short.class) return argType.cast(Short.parseShort(input));
        if (argType == Integer.class) return argType.cast(Integer.parseInt(input));
        if (argType == Long.class) return argType.cast(Long.parseLong(input));
        if (argType == Float.class) return argType.cast(Float.parseFloat(input));
        if (argType == Double.class) return argType.cast(Double.parseDouble(input));
        return null;
    }

    public static boolean checkNumberType(String input){
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
