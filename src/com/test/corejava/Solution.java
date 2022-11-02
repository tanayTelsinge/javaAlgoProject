package com.test.corejava;

import com.test.corejava.comparatorcomparable.Employee;

public class Solution {
    public static void main(String[] args) {
        SingletonClass sc = SingletonClass.getInstance();

        ImmutableClass ic = new ImmutableClass(new Employee(1, 1000, 23));
        ic.getEmployee();

    }
}

