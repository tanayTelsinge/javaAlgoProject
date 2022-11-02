package com.test.java8.functionaIInterfaces;

import java.util.function.BiConsumer;

public class Solution {

    public static void main(String[] args) {
        //lambda expression
        //Functional Interface
        BiConsumer<Integer, Integer> biConsumer =  (a,b)->System.out.println(a+b);
        biConsumer.accept(1,2);
        TestMultipleInheritanceForDefaultMethod ts = new TestMultipleInheritanceForDefaultMethod();
        ts.printNameDefault();
        CustomFunctionalInterface.printNameStatic();
        //
    }
}
