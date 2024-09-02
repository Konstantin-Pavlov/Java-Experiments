package utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;

public class GetDuration {
    private GetDuration() {
    }

    public static void toSummer() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime summerStuart = LocalDateTime.of(2025, Month.JUNE, 1, 0, 0, 0);
        Duration duration = Duration.between(now, summerStuart);
        Period period = Period.between(now.toLocalDate(), summerStuart.toLocalDate());

        long days = duration.toDays();
        long hours = duration.toHours() % 24;
        long minutes = duration.toMinutes() % 60;
        long seconds = duration.getSeconds() % 60;


        System.out.println("to summer (June 1st): "
                + period.getMonths() + " months, "
                + period.getDays() + " days, "
                + hours + " hours, "
                + minutes + " minutes, "
                + seconds + " seconds.");

        System.out.println();
        System.out.printf("%-15s %d%n", "days:", days);
        System.out.printf("%-15s %d%n", "hours:", duration.toHours());
        System.out.printf("%-15s %d%n", "minutes:", duration.toMinutes());
        System.out.printf("%-15s %d%n", "seconds:", duration.toSeconds());
        System.out.printf("%-15s %d%n", "milliseconds:", duration.toMillis());
        System.out.printf("%-15s %d%n", "nanoseconds:", duration.toNanos());
    }
}
