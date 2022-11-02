package com.test.java8.functionaIInterfaces;

import java.util.function.Predicate;

public class TestPredicateDemo {

    public static void main(String[] args) {

        String s1 = "testMyLength";
        String s2 = "test";

        System.out.println(checkLength(s1) + " " + checkLength(s2));

        Predicate<String> checkLength = s -> s.length() > 5;

        //Predicate has single abstract method - test. i.e it is a predefined FI (as Functional Interface has only one abstract method)
        System.out.println(checkLength.test(s1) + " " + checkLength.test(s2));

        //Predicate aggregation or joining
        Predicate <String> checkEven = s -> s.length() % 2 == 0;

        System.out.println(checkLength.or(checkEven).test(s2));
        System.out.println(checkLength.and(checkEven).test(s2));
        //negate returns logical opposite of predicate
        System.out.println(checkEven.negate().test(s2));
    }

    public static boolean checkLength(String s){
        return s.length() >= 5;
    }
}
