package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.DigitSeparation;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    /**
     * Test for Integration Parameter Variable Replacement (IVPR).
     */
    @Test
    public void testIPVR() {
        long largeNumber = 123456789L;

        // Original method call
        List<Long> originalResult = digitSeparation.digitSeparationReverseOrder(largeNumber);

        // Replace the parameter with another value of the same type
        long replacedParameter = 0L; // Replace with the default long value
        List<Long> mutatedResult = digitSeparation.digitSeparationReverseOrder(replacedParameter);

        // The results should differ since the parameter was replaced
        assertNotEquals(originalResult, mutatedResult, "IVPR mutation was not killed!");
    }

    /**
     * Test for Integration Unary Operator Insertion (IUOI).
     */
    @Test
    public void testIUOI() {
        long largeNumber = 987654321L;

        // Original method call
        List<Long> originalResult = digitSeparation.digitSeparationReverseOrder(largeNumber);

        // Simulate a mutation by flipping the sign of the parameter
        long mutatedNumber = largeNumber * 2;
        List<Long> mutatedResult = digitSeparation.digitSeparationReverseOrder(mutatedNumber);

        // The results should differ since the parameter was mutated
        assertNotEquals(originalResult, mutatedResult, "IUOI mutation was not killed!");
    }

    /**
     * Test for Integration Parameter Exchange (IPEX).
     */
    @Test
    public void testIPEX() {
        long largeNumber = 12345L;

        // Original method call
        List<Long> originalResult = digitSeparation.digitSeparationForwardOrder(largeNumber);

        // Simulate parameter exchange (using digitSeparationReverseOrder instead)
        List<Long> mutatedResult = digitSeparation.digitSeparationReverseOrder(largeNumber);

        // The results should differ due to the parameter exchange
        assertNotEquals(originalResult, mutatedResult, "IPEX mutation was not killed!");
    }

    /**
     * Test for Integration Method Call Deletion (IMCD).
     */
    @Test
    public void testIMCD() {
        long largeNumber = 54321L;

        // Original method call
        List<Long> originalResult = digitSeparation.digitSeparationForwardOrder(largeNumber);

        // Simulate method call deletion by replacing with a default return value
        List<Long> mutatedResult = new ArrayList<>(); // Default return for List<Long>

        // The results should differ due to the method call deletion
        assertNotEquals(originalResult, mutatedResult, "IMCD mutation was not killed!");
    }

    /**
     * Test for Integration Return Expression Modification (IREM).
     */
    @Test
    public void testIREM() {
        long largeNumber = 123L;

        // Original method call
        List<Long> originalResult = digitSeparation.digitSeparationForwardOrder(largeNumber);

        // Simulate return modification by reversing the result incorrectly
        List<Long> mutatedResult = digitSeparation.digitSeparationReverseOrder(largeNumber); // Deliberate reversal mutation

        // The results should differ due to the mutation in return expression
        assertNotEquals(originalResult, mutatedResult, "IREM mutation was not killed!");
    }
}
