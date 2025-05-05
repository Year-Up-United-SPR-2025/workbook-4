package com.pluralsight;

//Employee
//The Employee class is used to store and calculate payroll information about and
//        employee. It should manage the following information using private variables:
//employeeId, name, department, payRate, hoursWorked.
//Include the following derived getters (you may also include others as necessary):
//getTotalPay
//        getRegularHours
//getOvertimeHours


import java.time.LocalDateTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;

    private Double punchInTime = null;

    public Employee(int employeeId, String name, String department, double payRate, double hoursWorked) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.payRate = payRate;
        this.hoursWorked = hoursWorked;
    }

    public void punchIn(double time) {
        punchInTime = time;
        System.out.printf("%s punched in at %.2f\n", name, time);
    }

    public void punchIn() {
        LocalDateTime now = LocalDateTime.now();
        punchIn(getDecimalTime(now));
    }

    public void punchOut(double time) {
        if (punchInTime == null) {
            System.out.println("Error: Must punch in first.");
            return;
        }
        double worked = time - punchInTime;
        if (worked < 0) {
            System.out.println("Invalid time (punch out before punch in).");
            return;
        }
        hoursWorked += worked;
        System.out.printf("%s punched out at %.2f (%.2f hours worked)\n", name, time, worked);
        punchInTime = null;
    }

    public void punchOut() {
        LocalDateTime now = LocalDateTime.now();
        punchOut(getDecimalTime(now));
    }

    private double getDecimalTime(LocalDateTime dateTime) {
        return dateTime.getHour() + dateTime.getMinute() / 60.0;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getRegularHours() {
        return Math.min(40.0, hoursWorked);
    }

    public double getOvertimeHours() {
        return Math.max(0.0, hoursWorked - 40.0);
    }

    public double getTotalPay() {
        return (getRegularHours() * payRate) + (getOvertimeHours() * payRate * 1.5);
    }

    public String getName() {
        return name;
    }

    public void punchTimeCard(double time) {
    }
}
