package calculator;

import java.util.*;

//스캐너로 입력받은갓보다 더 큰값을 배열에서 찾아서 주기
public class GetMaxValue<T extends Number,R extends  Number> {
    private final Class<R> returnType;
    public GetMaxValue(Class<R> returnType) {
        this.returnType = returnType;
    }

    /**
     * 1. 일단 배열을 받아야함
     * 2. 그리고 람다식으로 순회해서 가장 큰것 "들을" return 해주자!
     * 3. results
     */
    public Queue<R> getResultMaxValue(Queue<R> results, R result){
        //Byte
        Queue<R> maxValues = new LinkedList<>();
        if (returnType == Byte.class)  {
            for ( R e : results ) {
                if ( e.longValue() > result.longValue() ) maxValues.add(e);
            }
        }

        if (returnType == Short.class)  {
            for ( R e : results ) {
                if ( e.intValue() > result.intValue() ) maxValues.add(e);
            }
        }
        if (returnType == Integer.class)  {
            for ( R e : results ) {
                if ( e.longValue() > result.longValue() ) maxValues.add(e);
            }
        }
        if (returnType == Long.class)  {
            for ( R e : results ) {
                if ( e.longValue() > result.longValue() ) maxValues.add(e);
            }
        }
        if (returnType == Float.class)  {
            for ( R e : results ) {
                if ( e.doubleValue() > result.doubleValue() ) maxValues.add(e);
            }
        }
        if (returnType == Double.class)  {
            for ( R e : results ) {
                if ( e.doubleValue() > result.doubleValue() ) maxValues.add(e);
            }
        }
        return maxValues;
    }

    /**
     * 1. 일단 배열을 받아야함
     * 2. 그리고 람다식으로 순회해서 가장 큰걸 return 해주자!
     * 3. circleAreas
     */

    public Queue<Double> getCircleAreaMaxValue(Queue<Double> circleAreas, double circleArea){
        Queue<Double> maxValues = new LinkedList<>();
        for ( double d : circleAreas ) {
            if (d > circleArea) maxValues.add(d);
        }
        return maxValues;
    }
}
