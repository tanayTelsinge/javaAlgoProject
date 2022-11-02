package com.test.corejava.comparatorcomparable;

import com.test.corejava.comparatorcomparable.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {

        List<Employee> empList = new ArrayList<>();
        empList.add(new Employee(1,500,22));
        empList.add(new Employee(3,1000,34));
        empList.add(new Employee(2,870,40));
        empList.add(new Employee(4,600,29));
        empList.add(new Employee(7,2600,51));
        empList.add(new Employee(5,2600,41));
        empList.add(new Employee(6,2600,31));

        System.out.println("------------Emp list---------- Comparable : salary and then age");
        empList.sort(null);
        empList.forEach(System.out::println);
        System.out.println();
        System.out.println("------------Emp list---------- Comparator : for id");
        empList.sort(new IdComparator());
        empList.forEach(System.out::println);
        System.out.println("------------Emp list----------");
    }
}
