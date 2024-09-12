package org.example.algorithms;

/**
 * The {@code AddingBigNumbers} class provides a method to add two large numbers represented as strings.
 * This class handles the addition of numbers that are too large to be represented by standard numeric types in Java.
 * <p>
 * The main functionality includes:
 * <ul>
 *     <li>Adding two numeric strings and returning the result as a string.</li>
 *     <li>Padding numeric strings with leading zeros to ensure they are of the same length.</li>
 *     <li>Checking if a character is a valid digit and converting it to its numeric value.</li>
 *     <li>Removing leading zeros from the result string.</li>
 * </ul>
 * </p>
 * <p>
 * Example usage:
 * <pre>
 * {@code
 * String result = AddingBigNumbers.add("123", "4567");
 * System.out.println(result); // Outputs "4690"
 * }
 * </pre>
 * </p>
 * <p>
 * This class is designed to handle only non-negative integers represented as strings.
 * </p>
 *
 * @since 1.0
 */
public class AddingBigNumbers {
    /**
     * Adds two large numbers represented as strings and returns the result as a string.
     *
     * @param a the first number as a string
     * @param b the second number as a string
     * @return the sum of the two numbers as a string, or {@code null} if both inputs are {@code null}
     * @throws IllegalArgumentException if either input contains non-digit characters
     */
    public static String add(String a, String b) {
        if (a == null && b == null) {
            return null;
        }
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        int remain = 0;
        int maxLength = Math.max(a.length(), b.length());
        a = padWithLeadingZeros(a, maxLength);
        b = padWithLeadingZeros(b, maxLength);
        StringBuilder result = new StringBuilder();
        for (int i = maxLength - 1; i >= 0; i--) {

            int first = getNumberOrThrow(a.charAt(i));
            int second = getNumberOrThrow(b.charAt(i));
            int sum = first + second;
            int sumPlusRemain = sum + remain;

            result.append(sumPlusRemain % 10);
            remain = sumPlusRemain / 10;
        }
        if (remain != 0) {
            result.append(remain);
        }

        removeLeadingZeros(result.reverse());
        return result.toString();
    }

    /**
     * Converts a character to its numeric value.
     *
     * @param number the character to convert
     * @return the numeric value of the character
     * @throws IllegalArgumentException if the character is not a digit
     */
    private static int getNumberOrThrow(char number) {
        if (Character.isDigit(number)) {
            return Integer.parseInt(number + "");
        }
        throw new IllegalArgumentException("Character is not a digit: " + number);
    }

    /**
     * Pads a string with leading zeros to ensure it is of the specified length.
     *
     * @param s         the string to pad
     * @param maxLength the desired length of the string
     * @return the padded string
     */
    private static String padWithLeadingZeros(String s, int maxLength) {
        if (s.length() == maxLength) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        while (sb.length() + s.length() < maxLength) {
            sb.append('0');
        }
        sb.append(s);
        return sb.toString();
    }

    /**
     * Removes leading zeros from a {@code StringBuilder}.
     *
     * @param stringBuilder the {@code StringBuilder} from which to remove leading zeros
     */
    private static void removeLeadingZeros(StringBuilder stringBuilder) {
        if (stringBuilder.charAt(0) == '0') {
            while (stringBuilder.charAt(0) == '0') {
                stringBuilder.deleteCharAt(0);
            }
        }
    }

}
