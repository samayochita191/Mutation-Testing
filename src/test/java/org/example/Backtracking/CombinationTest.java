package org.example.Backtracking;

import org.example.Backtracking.Combination;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.TreeSet;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationTest {

    @Test
    public void testCombinationWithValidInput() {
        String[] input = {"A", "B", "C", "D"};
        int n = 2;

        List<TreeSet<String>> result = Combination.combination(input, n);

        assertNotNull(result);
        assertEquals(6, result.size());  // Since there are 4 elements, n=2 should give 6 combinations.

        // Check specific combinations
        TreeSet<String> expected1 = new TreeSet<>();
        Collections.addAll(expected1, "A", "B");
        assertTrue(result.contains(expected1));

        TreeSet<String> expected2 = new TreeSet<>();
        Collections.addAll(expected2, "A", "C");
        assertTrue(result.contains(expected2));

        // Add further assertions as needed for other combinations
    }

    @Test
    public void testCombinationWithZeroLength() {
        String[] input = {"A", "B", "C", "D"};
        int n = 0;

        List<TreeSet<String>> result = Combination.combination(input, n);

        assertNotNull(result);
        assertTrue(result.isEmpty());  // Since n == 0, it should return an empty list.
    }

    @Test
    public void testCombinationWithNegativeLength() {
        String[] input = {"A", "B", "C", "D"};
        int n = -1;

        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            Combination.combination(input, n);
        });
        assertEquals("The combination length cannot be negative.", thrown.getMessage());
    }

    @Test
    public void testCombinationWithEmptyArray() {
        String[] input = {};
        int n = 2;

        List<TreeSet<String>> result = Combination.combination(input, n);

        assertNotNull(result);
        assertTrue(result.isEmpty());  // With an empty array, no combinations should be possible.
    }
}
