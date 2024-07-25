package calculator;

import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        //매개변수타입, return 타입
        Main<Long, Long> main = new Main<>(Long.class);
        main.calculatorApp();
    }
}
