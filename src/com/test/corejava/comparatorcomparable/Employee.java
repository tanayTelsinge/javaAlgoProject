package com.test.corejava.comparatorcomparable;

import java.util.Comparator;

public class Employee implements Comparable<Employee>, Cloneable{
    private int age;
    private int id;
    private long salary;

    public Employee(int id, long salary, int age) {
        this.id = id;
        this.salary = salary;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", salary=" + salary +
                ", age =" + age +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Employee o) {
        //sort by salary and if salary is common sort by age
        int salaryValue = (int) (this.getSalary() - o.getSalary());
        if(salaryValue == 0){
            return this.getAge() - o.getAge();
        }else{
            return salaryValue;
        }
    }

    public static Comparator<Employee> IdComparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {
            return o1.getId() - o2.getId();
        }
    };

    @Override
    public Employee clone() {
        try {
            Employee clone = (Employee) super.clone();
            // TODO: copy mutable state here, so the clone can't change the internals of the original
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
