package com.pluralsight;

//Employee
//The Employee class is used to store and calculate payroll information about and
//        employee. It should manage the following information using private variables:
//employeeId, name, department, payRate, hoursWorked.
//Include the following derived getters (you may also include others as necessary):
//getTotalPay
//        getRegularHours
//getOvertimeHours


public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }
    
}
