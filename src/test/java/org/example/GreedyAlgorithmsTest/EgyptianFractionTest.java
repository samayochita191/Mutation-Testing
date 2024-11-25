package org.example.GreedyAlgorithmsTest;


import org.example.GreedyAlgorithms.EgyptianFraction;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class EgyptianFractionTest {

    @Test
    void testSimpleFraction() {
        // 2/3 = 1/2 + 1/6
        List<String> expected = Arrays.asList("1/2", "1/6");
        assertEquals(expected, EgyptianFraction.getEgyptianFraction(2, 3));
    }

    @Test
    void testProperFraction() {
        // 3/10 = 1/4 + 1/20
        List<String> expected = Arrays.asList("1/4", "1/20");
        assertEquals(expected, EgyptianFraction.getEgyptianFraction(3, 10));
    }

    @Test
    void testImproperFraction() {
        // 5/4 = 1/1 + 1/4
        List<String> expected = Arrays.asList("1/1", "1/4");
        assertEquals(expected, EgyptianFraction.getEgyptianFraction(5, 4));
    }

    @Test
    void testWholeNumber() {
        // 4/1 = 1/1 + 1/1 + 1/1 + 1/1
        List<String> expected = Arrays.asList("1/1", "1/1", "1/1", "1/1");
        assertEquals(expected, EgyptianFraction.getEgyptianFraction(4, 1));
    }

    @Test
    void testLargeFraction() {
        // 6/7 = 1/2 + 1/14
        List<String> expected = Arrays.asList("1/2", "1/3", "1/42");
        assertEquals(expected, EgyptianFraction.getEgyptianFraction(6, 7));
    }

    @Test
    void testFractionWithHighDenominator() {
        // 1/100 = 1/100
        List<String> expected = List.of("1/100");
        assertEquals(expected, EgyptianFraction.getEgyptianFraction(1, 100));
    }

    @Test
    void testEdgeCaseZeroNumerator() {
        // 0/5 should return an empty list
        List<String> expected = List.of();
        assertEquals(expected, EgyptianFraction.getEgyptianFraction(0, 5));
    }

    @Test
    void testEdgeCaseInvalidFraction() {
        // Invalid case: denominator == 0 should throw ArithmeticException
        try {
            EgyptianFraction.getEgyptianFraction(3, 0);
        } catch (ArithmeticException e) {
            assertEquals("/ by zero", e.getMessage());
        }
    }

    @Test
    void testEdgeCaseNegativeFraction() {
        // -3/4 = -1/2 + -1/4 (negativity is ignored as per assumption)
        // Output would still use the positive representation
        List<String> expected = Arrays.asList("1/-1", "1/4");
        assertEquals(expected, EgyptianFraction.getEgyptianFraction(-3, 4));
    }
    /**
     * Test for Integration Parameter Variable Replacement (IVPR).
     */
    @Test
    public void testIPVR() {
        int numerator = 3;
        int denominator = 4;

        // Original method call
        List<String> originalResult = EgyptianFraction.getEgyptianFraction(numerator, denominator);

        // Replace the numerator with a different value (e.g., 1) and check the result
        int replacedNumerator = 1; // IPVR: Replacing the parameter with a constant value
        List<String> mutatedResult = EgyptianFraction.getEgyptianFraction(replacedNumerator, denominator);

        // The results should differ since the numerator was replaced
        assertNotEquals(originalResult, mutatedResult, "IPVR mutation was not killed!");
    }

    /**
     * Test for Integration Unary Operator Insertion (IUOI).
     */
    @Test
    public void testIUOI() {
        int numerator = 5;
        int denominator = 6;

        // Original method call
        List<String> originalResult = EgyptianFraction.getEgyptianFraction(numerator, denominator);

        // Simulate a unary operator insertion by negating the numerator
        int mutatedNumerator = -numerator; // IUOI: Unary operator insertion
        List<String> mutatedResult = EgyptianFraction.getEgyptianFraction(mutatedNumerator, denominator);

        // The results should differ since the numerator was negated
        assertNotEquals(originalResult, mutatedResult, "IUOI mutation was not killed!");
    }

    /**
     * Test for Integration Parameter Exchange (IPEX).
     */
    @Test
    public void testIPEX() {
        int numerator = 2;
        int denominator = 3;

        // Original method call
        List<String> originalResult = EgyptianFraction.getEgyptianFraction(numerator, denominator);

        // Swap the numerator and denominator (parameter exchange) and check the result
        List<String> mutatedResult = EgyptianFraction.getEgyptianFraction(denominator, numerator); // IPEX: Parameter exchange

        // The results should differ due to the exchange of parameters
        assertNotEquals(originalResult, mutatedResult, "IPEX mutation was not killed!");
    }

    /**
     * Test for Integration Method Call Deletion (IMCD).
     */
    @Test
    public void testIMCD() {
        int numerator = 6;
        int denominator = 8;

        // Original method call
        List<String> originalResult = EgyptianFraction.getEgyptianFraction(numerator, denominator);

        // Simulate method call deletion by replacing the result with an empty list (default return)
        List<String> mutatedResult = List.of(); // IMCD: Deleting the method call, returning an empty list

        // The results should differ due to the method call deletion
        assertNotEquals(originalResult, mutatedResult, "IMCD mutation was not killed!");
    }

}
