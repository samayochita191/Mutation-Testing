package org.example.Backtracking;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsequenceFinderTest {

    @Test
    void testGenerateAllSubsequences() {
        List<Integer> sequence = Arrays.asList(1, 2, 3);
        List<List<Integer>> expectedSubsequences = Arrays.asList(
                new ArrayList<>(),        // Empty subsequence
                Arrays.asList(3),         // Subsequence with 3
                Arrays.asList(2),         // Subsequence with 2
                Arrays.asList(2, 3),      // Subsequence with 2 and 3
                Arrays.asList(1),         // Subsequence with 1
                Arrays.asList(1, 3),      // Subsequence with 1 and 3
                Arrays.asList(1, 2),      // Subsequence with 2 and 3
                Arrays.asList(1, 2, 3)    // Subsequence with 1, 2, and 3
        );

        List<List<Integer>> actualSubsequences = SubsequenceFinder.generateAll(sequence);
        assertEquals(expectedSubsequences, actualSubsequences);
    }

    @Test
    void testEmptyList() {
        List<Integer> sequence = new ArrayList<>();
        List<List<Integer>> expectedSubsequences = Arrays.asList(
                new ArrayList<>()  // Only the empty subsequence
        );

        List<List<Integer>> actualSubsequences = SubsequenceFinder.generateAll(sequence);
        assertEquals(expectedSubsequences, actualSubsequences);
    }

    @Test
    void testSingleElementList() {
        List<Integer> sequence = Arrays.asList(42);
        List<List<Integer>> expectedSubsequences = Arrays.asList(
                new ArrayList<>(),        // Empty subsequence
                Arrays.asList(42)         // Subsequence with 42
        );

        List<List<Integer>> actualSubsequences = SubsequenceFinder.generateAll(sequence);
        assertEquals(expectedSubsequences, actualSubsequences);
    }

    @Test
    void testNullList() {
        List<Integer> sequence = null;
        assertThrows(NullPointerException.class, () -> SubsequenceFinder.generateAll(sequence));
    }

    @Test
    void testSubsequencesWithStrings() {
        List<String> sequence = Arrays.asList("a", "b", "c");
        List<List<String>> expectedSubsequences = Arrays.asList(
                new ArrayList<>(),        // Empty subsequence
                Arrays.asList("c"),       // Subsequence with "a"
                Arrays.asList("b"),       // Subsequence with "b"
                Arrays.asList("b", "c"),       // Subsequence with "b" and "c"
                Arrays.asList("a"),  // Subsequence with "a"
                Arrays.asList("a", "c"),  // Subsequence with "a" and "c"
                Arrays.asList("a", "b"),  // Subsequence with "a" and "b"
                Arrays.asList("a", "b", "c")  // Subsequence with "a", "b", and "c"
        );

        List<List<String>> actualSubsequences = SubsequenceFinder.generateAll(sequence);
        assertEquals(expectedSubsequences, actualSubsequences);
    }
}
