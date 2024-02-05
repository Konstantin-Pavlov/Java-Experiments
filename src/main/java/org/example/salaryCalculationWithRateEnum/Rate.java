package org.example.salaryCalculationWithRateEnum;

public enum Rate {
    REGULAR(20, 1), OVERTIME(40, 1.5), DOUBLE_OVERTIME(Integer.MAX_VALUE, 2);
    private final int hours;
    private final double tariff;

    Rate(int hours, double tariff) {
        this.hours = hours;
        this.tariff = tariff;
    }

    private static Rate getTariff(int workedHours) {
        for (Rate salary : Rate.values()) {
            if (workedHours <= salary.hours) {
                return salary;
            }
        }
        return null;
    }

    public static double calculateSalary(int workedHours, double hourlyRate) {
        if (workedHours < 0 || hourlyRate < 0) {
            throw new IllegalArgumentException("ERROR");
        }
        Rate currentRate = getTariff(workedHours);
        double totalAmount = 0.0;


        switch (currentRate) {
            case REGULAR -> totalAmount = workedHours * hourlyRate * currentRate.tariff;
            case OVERTIME -> {
                int regularHours = currentRate.getHours() - REGULAR.getHours();
                int overtimeHours = workedHours - regularHours;
                totalAmount = (regularHours * hourlyRate) +
                        (overtimeHours * hourlyRate * currentRate.tariff);
            }
            case DOUBLE_OVERTIME -> {
                int regularHoursDouble = REGULAR.getHours();
                int overtimeHoursDouble = OVERTIME.getHours() - REGULAR.getHours();
                int doubleOvertimeHours = workedHours - OVERTIME.getHours();
                totalAmount = (regularHoursDouble * hourlyRate) +
                        (overtimeHoursDouble * hourlyRate * OVERTIME.tariff) +
                        (doubleOvertimeHours * hourlyRate * currentRate.tariff);
            }
            case null, default -> totalAmount = workedHours * hourlyRate;
        }
        return totalAmount;
    }

    private int getHours() {
        return hours;
    }

}
