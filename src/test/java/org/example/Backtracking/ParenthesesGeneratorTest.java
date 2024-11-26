package org.example.Backtracking;

import org.example.Backtracking.ParenthesesGenerator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class ParenthesesGeneratorTest {

    @Test
    public void testGenerateParentheses() {
        // Test with 3 pairs of parentheses
        int n = 3;
        List<String> result = ParenthesesGenerator.generateParentheses(n);

        assertNotNull(result, "Result should not be null");
        assertEquals(5, result.size(), "There should be 5 valid combinations for 3 pairs of parentheses.");
        assertTrue(result.contains("((()))"), "Result should contain ((()))");
        assertTrue(result.contains("(()())"), "Result should contain (()())");
        assertTrue(result.contains("(())()"), "Result should contain (())()");
        assertTrue(result.contains("()(())"), "Result should contain ()(())");
        assertTrue(result.contains("()()()"), "Result should contain ()()()");
    }

    @Test
    public void testGenerateParenthesesZeroPairs() {
        // Test with 0 pairs of parentheses
        int n = 0;
        List<String> result = ParenthesesGenerator.generateParentheses(n);

        assertNotNull(result, "Result should not be null");
        assertFalse(result.isEmpty(), "There should be no combinations for 0 pairs of parentheses.");
    }

    @Test
    public void testGenerateParenthesesOnePair() {
        // Test with 1 pair of parentheses
        int n = 1;
        List<String> result = ParenthesesGenerator.generateParentheses(n);

        assertNotNull(result, "Result should not be null");
        assertEquals(1, result.size(), "There should be 1 valid combination for 1 pair of parentheses.");
        assertTrue(result.contains("()"), "Result should contain ()");
    }

    @Test
    public void testGenerateParenthesesNegativeInput() {
        // Test with a negative number of pairs of parentheses
        int n = -1;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            ParenthesesGenerator.generateParentheses(n);
        });

        assertEquals("The number of pairs of parentheses cannot be negative", exception.getMessage(), "Exception message should match");
    }
}
