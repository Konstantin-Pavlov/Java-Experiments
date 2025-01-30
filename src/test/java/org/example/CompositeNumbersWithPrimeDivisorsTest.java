package org.example;

import org.example.algorithms.CompositeNumbersWithPrimeDivisors;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.concurrent.TimeUnit;

public class CompositeNumbersWithPrimeDivisorsTest {

    @DisplayName("positive scenarios")
    @ParameterizedTest
    @CsvSource({
            "1, 9, 2",  // 2 составных числа с простым количеством делителей (10 и 15)
            "10, 20, 1", // 16 имеет 5 делителей, это простое число
            "21, 30, 1", // 25 имеет 3 делителя, это простое число
            "50, 60, 0"  // 0
    })
    @Timeout(value = 1, unit = TimeUnit.SECONDS)  // Проверка на выполнение за 1 секунду
    public void testPositiveScenarios(int L, int R, int expected) {
        int primeDivisors = CompositeNumbersWithPrimeDivisors.countCompositeNumbersWithPrimeDivisors(L, R);
        Assertions.assertEquals(expected, primeDivisors);
    }

    @DisplayName("negative scenarios")
    @ParameterizedTest
    @CsvSource({
            "2, 7, 0",  // Только простые числа
            "15, 15, 5", // Одно составное число, но количество делителей не простое
            "200, 199, 2"  // Невалидный диапазон (L > R)
    })
    @Timeout(value = 1, unit = TimeUnit.SECONDS)  // Проверка на выполнение за 1 секунду
    public void testNegativeScenarios(int L, int R, int expected) {
        int primeDivisors = CompositeNumbersWithPrimeDivisors.countCompositeNumbersWithPrimeDivisors(L, R);
        Assertions.assertNotEquals(expected, primeDivisors, "Failed for range: [" + L + ", " + R + "]");
    }

    @DisplayName("Graceful handling of edge cases")
    @ParameterizedTest
    @CsvSource({
            "-10, -1, 0", // Отрицательные числа
            "0, 0, 0",    // Диапазон из одного числа
            "200, 199, 0" // Перевернутый диапазон
    })
    public void testGracefulHandlingOfEdgeCases(int L, int R, int expected) {
        int result = CompositeNumbersWithPrimeDivisors.countCompositeNumbersWithPrimeDivisors(L, R);
        Assertions.assertEquals(expected, result, "Failed to handle edge case for range: [" + L + ", " + R + "]");
    }

    @RepeatedTest(5)
    @DisplayName("Performance test for large range")
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    public void testPerformanceForLargeRange() {
        Assertions.assertDoesNotThrow(() ->
                CompositeNumbersWithPrimeDivisors.countCompositeNumbersWithPrimeDivisors(1, 100_000)
        );
        Assertions.assertEquals(79, CompositeNumbersWithPrimeDivisors.countCompositeNumbersWithPrimeDivisors(1, 100_000));
    }

}
