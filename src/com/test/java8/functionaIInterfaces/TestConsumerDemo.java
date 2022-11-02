package com.test.java8.functionaIInterfaces;

import java.util.function.Consumer;

public class TestConsumerDemo {
    public static void main(String[] args) {
        Consumer<Integer> squareMe = i -> System.out.println("Squared as " + (i*i));

        Consumer<Integer> tripleMe = i -> System.out.println("Double as " + (3*i));

        squareMe.andThen(tripleMe).accept(2);
    }
}
