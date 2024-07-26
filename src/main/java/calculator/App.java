package calculator;

import java.util.*;

//진입점
public class App {
    public static void main(String[] args) throws Exception {
        //매개변수타입, return 타입
        Main<Long, Long> main = new Main<>(Long.class, Long.class);
        main.calculatorApp();
    }
}
