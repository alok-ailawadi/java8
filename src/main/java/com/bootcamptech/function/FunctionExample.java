package com.bootcamptech.function;

import java.util.function.Function;

public class FunctionExample {

    static Function<Integer, Double> halfIt = value -> value / 2.0;

    static Function<Integer, Integer> tripleIt = value -> value * 3;

    static Function<Integer, Double> tripleAndhalf = tripleIt.andThen(halfIt);

    static Function<Integer, Double> composeIt = halfIt.compose(tripleIt);

    public static void main(String[] args) {

        System.out.println(tripleIt.apply(5)); // 15
        /******* and then ********/
        System.out.println(halfIt.apply(5 * 3)); // 15 / 2.0 = 7.5

        /***** is equivalent to ******/
        System.out.println(tripleAndhalf.apply(5)); // 7.5

        /***** is equivalent to ****/
        System.out.println(tripleIt.andThen(halfIt).apply(5));// 7.5

        /***** is equivalent to ****/
        System.out.println(composeIt.apply(5));

        /***** is equivalent to ****/
        System.out.println(halfIt.compose(tripleIt).apply(5));

    }
}
