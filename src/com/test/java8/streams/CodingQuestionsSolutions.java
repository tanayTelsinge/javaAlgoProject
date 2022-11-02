package com.test.java8.streams;

import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodingQuestionsSolutions {

    public static void main(String[] args) {
        //All solutions using java 8

        int[] arr = {10,20,28,10,87,28,90};
        List<Integer> list = Arrays.asList(10,20,28,10,87,28,90);

        //Q. Find duplicate elements in given integer list using Stream fns.
        Set<Integer> set = new HashSet<>();
        //Collectors.toSet to avoid duplicate of duplicate elements
        list.stream().filter(e->!set.add(e)).collect(Collectors.toSet()).forEach(System.out::println);

        //Q. Program to multiply two numbers using FI
        BiFunction<Integer,Integer,Integer> multiplyTwo = (a,b)-> a*b;
        System.out.println(multiplyTwo.apply(2,3));
        //Q. count no of occurences of words in given string
        String s = "Welcome to the java interview and answer the interview question";

        List<String> list1 = Arrays.asList(s.split(" "));
        //Function.identity takes current element
        Map<String, Long> map = list1.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(map);


        //Q. write Fn to check is Prime

        //logic for prime --> Prime numbers are numbers greater than 1. They only have two factors, 1 and the number itself.

        System.out.println(isPrime(1));
        System.out.println(isPrime(37));

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
        System.out.println("------------Emp list----------");
        System.out.println("------------Emp list---------- Comparator : for id");
        empList.sort(Employee.IdComparator);
        empList.forEach(System.out::println);
        System.out.println("------------Emp list----------");
        //Q.Sort emp list based on salary (i.e. one of the attribute
        //sorted ASC by salary
        empList.stream().sorted((e1, e2) -> (int) (e1.getSalary() - e2.getSalary())).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        //sorted DESC by salary
        empList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        //top 3 salaries
        empList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).limit(3).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        //fetch all employees whose salary is less than 3rd highest salary --> 3rd highest salary
        empList.stream().sorted((e1, e2) -> (int) (e2.getSalary() - e1.getSalary())).skip(3).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();
        //get min , max age
        List<Integer> ages = empList.stream().map(e -> e.getAge()).collect(Collectors.toList());
        System.out.println();
        //map to int can be used to
        IntSummaryStatistics summary = ages.stream().mapToInt(x->x).summaryStatistics();
        System.out.println("Min :: " + summary.getMin() + " " + " Avg :: " + summary.getAverage());;
        //Q. Given a stream how can we slice it
        //eg. [1,2,3,4,5,6,7,8] o/p [2,3,4]
        //solution using skip and limit
        List<Integer> num = Arrays.asList(1,2,3,4,5,6,7,8);
        num.stream().skip(1).limit(3).forEach(System.out::print);

        //Q. Convert List of String to a single String to uppercase and join them  using comma
        List<String> empNames = Arrays.asList("Ram","Shyam","Karan","Arjun","Maya");
        System.out.println();
        String s1 = empNames.stream().reduce((a, b) -> a + "," + b).get().toUpperCase();
        System.out.println(s1);
        //or
        String s2 = empNames.stream().collect(Collectors.joining(",")).toUpperCase();
        System.out.println(s2);
    }

    private static boolean isPrime(int num) {
        return num>1 && IntStream.range(2,num).noneMatch(e-> num%e==0);
    }
}
