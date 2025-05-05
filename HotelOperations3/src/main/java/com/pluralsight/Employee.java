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
    private Double startTime = null; // using object type to track punch-in

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public void punchTimeCard(double time) {
        if (startTime == null) {
            startTime = time;
            System.out.println(name + " punched in at " + time);
        } else {
            if (time < startTime) {
                System.out.println("Error: Punch-out time cannot be before punch-in.");
                return;
            }
            double worked = time - startTime;
            hoursWorked += worked;
            System.out.printf("%s punched out at %.2f. Hours worked: %.2f%n", name, time, worked);
            startTime = null;
        }
    }

    public double getRegularHours() {
        return Math.min(40, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0, hoursWorked - 40);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public double getPayRate() {
        return payRate;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }
}
