package org.example;

import org.example.algorithms.SnowJournal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SnowJournalTest {

    @Test
    @DisplayName("Test valid restoration with consecutive missing values")
    void testValidRestoration() {
        List<Integer> measurements = List.of(1, -1, -1, 4, 5);
        String expected = "YES\n1 2 3 4 5";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test invalid restoration with a value exceeding 10^9")
    void testInvalidValue() {
        List<Integer> measurements = List.of(1, 1_000_000_001, 3);
        String expected = "NO";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test impossible restoration due to conflicting measurements")
    void testImpossibleRestoration() {
        List<Integer> measurements = List.of(1, -1, 3, 2);
        String expected = "NO";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with all missing values")
    void testAllMissingValues() {
        List<Integer> measurements = List.of(-1, -1, -1);
        String expected = "YES\n1 2 3";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with mixed valid and missing values")
    void testMixedValidAndMissingValues() {
        List<Integer> measurements = List.of(-1, 2, -1, -1, 5, -1);
        String expected = "YES\n1 2 3 4 5 6";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with no missing values (already valid)")
    void testNoMissingValues() {
        List<Integer> measurements = List.of(1, 2, 3, 4, 5);
        String expected = "YES\n1 2 3 4 5";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with single day missing measurement")
    void testSingleMissingValue() {
        List<Integer> measurements = List.of(1, -1, 3);
        String expected = "YES\n1 2 3";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with all values missing except the last one")
    void testAllMissingExceptLast() {
        List<Integer> measurements = List.of(-1, -1, -1, 4);
        String expected = "YES\n1 2 3 4";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with all values missing except the first one")
    void testAllMissingExceptFirst() {
        List<Integer> measurements = List.of(1, -1, -1, -1);
        String expected = "YES\n1 2 3 4";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with large valid sequence")
    void testLargeValidSequence() {
        List<Integer> measurements = List.of(1, -1, -1, 100, -1, -1, 105);
        String expected = "YES\n1 2 3 100 101 102 105";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration fails with incorrect boundaries for missing values")
    void testIncorrectBoundaries() {
        List<Integer> measurements = List.of(-1, 2, -1, 2);
        String expected = "NO";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with single valid value")
    void testSingleValue() {
        List<Integer> measurements = List.of(5);
        String expected = "YES\n5";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }

    @Test
    @DisplayName("Test restoration with single missing value")
    void testSingleMissing() {
        List<Integer> measurements = List.of(-1);
        String expected = "YES\n1";
        assertEquals(expected, SnowJournal.restoreMeasurements(measurements));
    }
}
