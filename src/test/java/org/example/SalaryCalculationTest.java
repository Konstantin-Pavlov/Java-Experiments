package org.example;

import org.example.salaryCalculationWithRateEnum.Rate;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SalaryCalculationTest {
    @Test
    public void test0() {
        int hours = 42;
        double tariff = 10.5;
        assertEquals(567.00, Rate.calculateSalary(hours, tariff));
    }

    @Test
    public void test1() {
        int hours = -12;
        double tariff = 34.2;
        Exception exception = assertThrows(Exception.class, () -> {
            Rate.calculateSalary(hours, tariff);
        });

        String expectedMessage = "ERROR";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test2() {
        int hours = 12;
        double tariff = -3;
        Exception exception = assertThrows(Exception.class, () -> {
            Rate.calculateSalary(hours, tariff);
        });

        String expectedMessage = "ERROR";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    public void test3() {
        int hours = 15;
        double tariff = 20.5;
        assertEquals(307.50, Rate.calculateSalary(hours, tariff));
    }

    @Test
    public void test4() {
        int hours = 25;
        double tariff = 14.3;
        assertEquals(393.25, Rate.calculateSalary(hours, tariff));
    }

    @Test
    public void test5() {
        int hours = 60;
        double tariff = 13.4;
        assertEquals(1206.00, Rate.calculateSalary(hours, tariff));
    }
}
