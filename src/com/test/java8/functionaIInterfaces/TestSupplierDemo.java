package com.test.java8.functionaIInterfaces;

import java.util.Date;
import java.util.function.Supplier;

public class TestSupplierDemo {

    public static void main(String[] args) {
        Supplier<Date> currentDate = () -> new Date();
        System.out.println(currentDate.get());
    }

    public Date fetchCurrentDate(){
        return new Date();
    }
}
