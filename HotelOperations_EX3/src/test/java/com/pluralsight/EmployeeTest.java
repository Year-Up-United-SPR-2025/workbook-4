package com.pluralsight;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    private Employee emp;

    @BeforeEach
    public void setUp() {
        emp = new Employee(1, "Test User", "Test Dept", 20.0, 0.0);
    }

    @Test
    public void testPunchInAndOutCalculatesHoursWorkedCorrectly() {
        emp.punchIn(9.0);
        emp.punchOut(17.0);
        assertEquals(8.0, emp.getHoursWorked(), 0.01);
    }

    @Test
    public void testPunchOutWithoutPunchInDoesNotAddHours() {
        emp.punchOut(17.0);
        assertEquals(0.0, emp.getHoursWorked(), 0.01);
    }

    @Test
    public void testPunchOutBeforePunchInDoesNotAddHours() {
        emp.punchIn(14.0);
        emp.punchOut(10.0);
        assertEquals(0.0, emp.getHoursWorked(), 0.01);
    }

    @Test
    public void testMultiplePunchesAccumulateHours() {
        emp.punchIn(8.0);
        emp.punchOut(12.0);
        emp.punchIn(13.0);
        emp.punchOut(17.0);
        assertEquals(8.0, emp.getHoursWorked(), 0.01);
    }
}