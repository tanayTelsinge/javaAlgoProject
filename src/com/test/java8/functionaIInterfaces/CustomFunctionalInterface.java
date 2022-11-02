package com.test.java8.functionaIInterfaces;

@FunctionalInterface
public interface CustomFunctionalInterface {

    //only one abstract method allowed
    public void  printNameAbstract();

    public static void printNameStatic(){
        System.out.println("print name static");
    }

    public default void printNameDefault(){
        System.out.println("print name default in base");
    }

}

