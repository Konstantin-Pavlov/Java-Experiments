package org.example;

import org.example.algorithms.AddingBigNumbers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AddingBigNumbersTest {
    @Test
    public void test1() {
        // Arrange
        String a = "";
        String b = "";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("", result, "Expected empty string when both inputs are empty");
    }

    @Test
    public void test2() {
        // Arrange
        String a = "";
        String b = "12345";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("12345", result, "Expected non-empty string when one input is empty");
    }

    @Test
    public void test3() {
        // Arrange
        String a = "123";
        String b = "456";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("579", result);
    }

    @Test
    public void test4() {
        // Arrange
        String a = "888";
        String b = "222";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("1110", result);
    }

    @Test
    public void test5() {
        // Arrange
        String a = "1372";
        String b = "69";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("1441", result);
    }

    @Test
    public void test6() {
        // Arrange
        String a = "12";
        String b = "456";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("468", result);
    }

    @Test
    public void test7() {
        // Arrange
        String a = "100";
        String b = "101";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("201", result);
    }

    @Test
    public void test8() {
        // Arrange
        String a = "63829983432984289347293874";
        String b = "90938498237058927340892374089";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("91002328220491911630239667963", result);
    }

    @Test
    public void test9() {
        // Arrange
        String a = null;
        String b = "0589";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("0589", result);
    }

    @Test
    public void test10() {
        Assertions.assertNull(AddingBigNumbers.add(null, null));
    }

    @Test
    public void test11() {
        // Arrange
        String a = "1f00";
        String b = "101";

        // Assert
        Assertions.assertThrows(IllegalArgumentException.class, () -> AddingBigNumbers.add(a, b));
    }

    @Test
    public void test12() {
        // Arrange
        String a = "0589";

        // Act
        String result = AddingBigNumbers.add(a, null);

        // Assert
        Assertions.assertEquals("0589", result);

        Assertions.assertEquals("59", AddingBigNumbers.add("59", ""));
    }

    @Test
    public void test13() {
        Assertions.assertEquals("59", AddingBigNumbers.add("59", ""));
    }

    @Test
    public void test14() {
        // Arrange
        String a = "01731525124805491925600101605346";
        String b = "54891249900560641";

        // Act
        String result = AddingBigNumbers.add(a, b);

        // Assert
        Assertions.assertEquals("1731525124805546816850002165987", result);
    }
}
