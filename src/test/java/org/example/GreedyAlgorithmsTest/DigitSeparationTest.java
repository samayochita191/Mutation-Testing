package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.DigitSeparation;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DigitSeparationTest {

    private final DigitSeparation digitSeparation = new DigitSeparation();

    @Test
    void testReverseOrderSingleDigit() {
        // Single-digit number
        assertEquals(Collections.singletonList(7L), digitSeparation.digitSeparationReverseOrder(7));
    }

    @Test
    void testReverseOrderMultiDigit() {
        // Multi-digit number
        assertEquals(Arrays.asList(3L, 2L, 1L), digitSeparation.digitSeparationReverseOrder(123));
    }

    @Test
    void testReverseOrderLargeNumber() {
        // Large number
        assertEquals(Arrays.asList(0L, 0L, 5L, 0L, 4L, 3L, 2L, 1L), digitSeparation.digitSeparationReverseOrder(12340500));
    }

    @Test
    void testReverseOrderZero() {
        // Zero input
        assertEquals(Collections.singletonList(0L), digitSeparation.digitSeparationReverseOrder(0));
    }

    @Test
    void testReverseOrderNegativeNumber() {
        // Negative number
        assertEquals(Arrays.asList(3L, 2L, 1L), digitSeparation.digitSeparationReverseOrder(-123));
    }

    @Test
    void testForwardOrderSingleDigit() {
        // Single-digit number
        assertEquals(Collections.singletonList(7L), digitSeparation.digitSeparationForwardOrder(7));
    }

    @Test
    void testForwardOrderMultiDigit() {
        // Multi-digit number
        assertEquals(Arrays.asList(1L, 2L, 3L), digitSeparation.digitSeparationForwardOrder(123));
    }

    @Test
    void testForwardOrderLargeNumber() {
        // Large number
        assertEquals(Arrays.asList(1L, 2L, 3L, 4L, 0L, 5L, 0L, 0L), digitSeparation.digitSeparationForwardOrder(12340500));
    }

    @Test
    void testForwardOrderZero() {
        // Zero input
        assertEquals(Collections.singletonList(0L), digitSeparation.digitSeparationForwardOrder(0));
    }

    @Test
    void testForwardOrderNegativeNumber() {
        // Negative number
        assertEquals(Arrays.asList(1L, 2L, 3L), digitSeparation.digitSeparationForwardOrder(-123));
    }
}
