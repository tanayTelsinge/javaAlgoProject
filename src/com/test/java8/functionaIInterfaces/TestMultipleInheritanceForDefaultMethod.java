package com.test.java8.functionaIInterfaces;

public class TestMultipleInheritanceForDefaultMethod implements CustomFunctionalInterface, CustomFunctionalInterfaceTwo {
    @Override
    public void printNameAbstract() {

    }

    @Override
    public void printNameDefault() {
        CustomFunctionalInterface.super.printNameDefault();
    }
}
