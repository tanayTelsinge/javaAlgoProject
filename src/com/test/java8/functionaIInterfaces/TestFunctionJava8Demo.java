package com.test.java8.functionaIInterfaces;

import java.util.function.Function;

public class TestFunctionJava8Demo {

    public static void main(String[] args) {
        Function<Integer, Integer> squareMe = i -> i*i;
        System.out.println(squareMe.apply(5));

        //Functional chaining
        Function<Integer, Integer> doubleIt = i -> 2*i;
        Function<Integer, Integer> cubeIt = i -> i*i*i;

        //first double then cube
        System.out.println(doubleIt.andThen(cubeIt).apply(2));
        //first cube then double
        System.out.println(doubleIt.compose(cubeIt).apply(2));
    }


}
