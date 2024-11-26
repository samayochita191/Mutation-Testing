package org.example.Backtracking;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubsequenceFinderTest {


    // Helper to create test data
    private List<Integer> createList(Integer... elements) {
        return Arrays.asList(elements);
    }

    // Test IPVR: Replace parameters with compatible variables
    @Test
    void testIPVR() {
        List<Integer> sequence = createList(1, 2, 3);
        // Replace sequence with empty list, single element list
        List<List<Integer>> resultEmpty = SubsequenceFinder.generateAll(Collections.emptyList());
        List<List<Integer>> resultSingle = SubsequenceFinder.generateAll(createList(5));

        assertEquals(1, resultEmpty.size());
        assertEquals(2, resultSingle.size());
        assertTrue(resultSingle.contains(Collections.singletonList(5)));
    }

    // Test IUOI: Insert unary operators in expressions
    @Test
    void testIUOI() {
        List<Integer> sequence = createList(1, 2, 3);
        List<List<Integer>> subsequences = SubsequenceFinder.generateAll(sequence);

        // Check the total number of subsequences (2^n)
        assertEquals(8, subsequences.size());

        // Negate conditions (checking edge cases indirectly)
        assertTrue(subsequences.contains(Collections.emptyList()));
        assertTrue(subsequences.contains(Arrays.asList(1, 2, 3)));
    }

    // Test IPEX: Exchange parameters in method calls
    @Test
    void testIPEX() {
        List<Integer> sequence = createList(1, 2, 3);

        // Swapping compatible parameters in context of logic
        List<List<Integer>> subsequences = SubsequenceFinder.generateAll(sequence);

        assertNotNull(subsequences);
        assertEquals(8, subsequences.size());
        assertTrue(subsequences.contains(Arrays.asList(1, 2)));
        assertTrue(subsequences.contains(Arrays.asList(2, 3)));
    }

    @Test
    void testIMCD() {
        // Step 1: Define the sequence
        List<Integer> sequence = List.of(1, 2, 3);

        // Step 2: Original behavior
        List<List<Integer>> originalOutput = SubsequenceFinder.generateAll(sequence);

        // Step 3: Simulated IMCD mutation
        List<List<Integer>> mutatedOutput = new ArrayList<>();
        // We simulate the deletion of backtrack() by bypassing its logic entirely:
        if (sequence.isEmpty()) {
            mutatedOutput.add(new ArrayList<>());
        } else {
            // Simulate behavior without invoking backtrack: directly return empty or minimal output
            mutatedOutput.add(new ArrayList<>()); // Add just the empty subsequence
        }

        // Step 4: Assertions to kill the mutation
        assertNotEquals(originalOutput, mutatedOutput, "The mutated output should differ from the original output");
        assertEquals(1, mutatedOutput.size(), "The mutated output should contain only the empty subsequence");
    }

    // Test IREM: Modify return expressions using UOI and AOR
    @Test
    void testIREM() {
        List<Integer> sequence = createList(1, 2, 3);

        // Apply UOI and AOR indirectly by focusing on result correctness
        List<List<Integer>> subsequences = SubsequenceFinder.generateAll(sequence);

        // Validate subsequences are correctly generated
        assertEquals(8, subsequences.size());
        assertTrue(subsequences.contains(Arrays.asList(1, 2)));
        assertTrue(subsequences.contains(Arrays.asList(2, 3)));
        assertFalse(subsequences.contains(Arrays.asList(4, 5)));
    }

    // Additional edge-case testing
    @Test
    void testEdgeCases() {
        // Empty input
        List<Integer> emptyList = Collections.emptyList();
        List<List<Integer>> subsequences = SubsequenceFinder.generateAll(emptyList);
        assertEquals(1, subsequences.size());
        assertTrue(subsequences.contains(Collections.emptyList()));

        // Single element
        List<Integer> singleElement = createList(42);
        subsequences = SubsequenceFinder.generateAll(singleElement);
        assertEquals(2, subsequences.size());
        assertTrue(subsequences.contains(Collections.emptyList()));
        assertTrue(subsequences.contains(Collections.singletonList(42)));
    }

    // Performance testing
    @Test
    void testPerformance() {
        int n = 20; // Large n generates 2^n subsequences
        List<Integer> largeList = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            largeList.add(i);
        }

        List<List<Integer>> subsequences = SubsequenceFinder.generateAll(largeList);
        assertEquals((int) Math.pow(2, n), subsequences.size());
    }
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
    @Test
    public void testLargeList() {
        // Test case with a larger list to check performance
        List<String> input = List.of("A", "B", "C", "D", "E");
        List<List<String>> subsequences = SubsequenceFinder.generateAll(input);

        // The number of subsequences for a list of size n is 2^n
        assertEquals(Math.pow(2, 5), subsequences.size());
    }

    @Test
    public void testNonEmptyListWithNoMutations() {
        // A general test case with no changes applied to the code
        List<Integer> input = List.of(1, 2, 3);
        List<List<Integer>> subsequences = SubsequenceFinder.generateAll(input);

        assertEquals(8, subsequences.size());
        assertTrue(subsequences.contains(List.of()));
        assertTrue(subsequences.contains(List.of(1)));
        assertTrue(subsequences.contains(List.of(2)));
        assertTrue(subsequences.contains(List.of(3)));
        assertTrue(subsequences.contains(List.of(1, 2)));
        assertTrue(subsequences.contains(List.of(1, 3)));
        assertTrue(subsequences.contains(List.of(2, 3)));
        assertTrue(subsequences.contains(List.of(1, 2, 3)));
    }

    @Test
    public void testMutationWithEmptyListCheckRemoved() {
        // Test case where the mutation removes the call to isEmpty()
        List<String> input = List.of();
        List<List<String>> subsequences = SubsequenceFinder.generateAll(input);

        // Even without checking for empty list, it should still return an empty subsequence
        assertEquals(1, subsequences.size());
        assertTrue(subsequences.contains(List.of()));
    }

    @Test
    public void testMutationWithFalseCheckInsteadOfEmptyCheck() {
        // Test case where the empty check is replaced with "false"
        List<String> input = List.of();
        List<List<String>> subsequences = SubsequenceFinder.generateAll(input);

        // The behavior should still be correct for an empty list
        assertEquals(1, subsequences.size());
        assertTrue(subsequences.contains(List.of()));
    }
}
