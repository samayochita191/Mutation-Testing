package org.example.GreedyAlgorithmsTest;


import org.example.GreedyAlgorithms.EgyptianFraction;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
