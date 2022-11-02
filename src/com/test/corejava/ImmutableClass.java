package com.test.corejava;

import com.test.corejava.comparatorcomparable.Employee;

//6 steps
//Immutable class means it cannot be extended and no data can be changed once we set it
//1. Make class final
public final class ImmutableClass {

    //2.private (no external access) and
    //3. final variables (can be assigned only once)
    private final Employee employee;

    //4. Initialize fields via Constructor
    public ImmutableClass(Employee emp) {
        //5.Perform deep copy
        this.employee = new Employee(emp.getId(),emp.getSalary(), emp.getAge());
    }

    //6.Getter returns clone instead of original object
    public Employee getEmployee() {
        Employee cloneEmployee = employee.clone();
        return cloneEmployee;
    }
}
