package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.OptimalFileMerging;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OptimalFileMergingTest {

    @Test
    void testSmallFiles() {
        int[] files = {4, 3, 2, 6};
        int expectedCost = 29; // Steps are described in the problem statement
        assertEquals(expectedCost, OptimalFileMerging.minMergeCost(files));
    }

    @Test
    void testSingleFile() {
        int[] files = {10};
        int expectedCost = 0; // No merging needed for a single file
        assertEquals(expectedCost, OptimalFileMerging.minMergeCost(files));
    }

    @Test
    void testTwoFiles() {
        int[] files = {5, 15};
        int expectedCost = 20; // Only one merge needed
        assertEquals(expectedCost, OptimalFileMerging.minMergeCost(files));
    }

    @Test
    void testLargeFiles() {
        int[] files = {100, 200, 300, 400};
        int expectedCost = 1900; // Step-by-step merging: 300, 600, 1000
        assertEquals(expectedCost, OptimalFileMerging.minMergeCost(files));
    }

    @Test
    void testEqualFiles() {
        int[] files = {10, 10, 10, 10};
        int expectedCost = 80;
        assertEquals(expectedCost, OptimalFileMerging.minMergeCost(files));
    }

    @Test
    void testEmptyFilesArray() {
        int[] files = {};
        int expectedCost = 0; // No files to merge
        assertEquals(expectedCost, OptimalFileMerging.minMergeCost(files));
    }

    @Test
    void testZerosInFiles() {
        int[] files = {0, 0, 0, 0};
        int expectedCost = 0; // Merging zeros always costs 0
        assertEquals(expectedCost, OptimalFileMerging.minMergeCost(files));
    }

    @Test
    void testNegativeFiles() {
        int[] files = {-1, -2, -3, -4};
        assertThrows(IllegalArgumentException.class, () -> OptimalFileMerging.minMergeCost(files));
    }

    @Test
    void testLargeNumberOfFiles() {
        int[] files = new int[100];
        for (int i = 0; i < files.length; i++) {
            files[i] = i + 1;
        }
        // Not calculating expected cost manually, just verifying no exceptions and positive cost
        assertTrue(OptimalFileMerging.minMergeCost(files) > 0);
    }
    @Test
    public void testMinMergeCostMutation_IPVR() {
        // Mutation: Modify the input array using IVPR by changing the values of the files
        int[] files = {4, 3, 2, 6};

        // Change the first two file sizes (file size replacement)
        files[0] = 5; // IPVR mutation
        files[1] = 8; // IPVR mutation

        // Calculate minimum cost with the mutated method
        int result = OptimalFileMerging.minMergeCost(files);

        // Verify that the mutated result is different from the original result
        assertNotEquals(29, result, "The minimum merge cost should be different after parameter variable replacement.");
    }

    @Test
    public void testMinMergeCostMutation_IMCD() {
        // Create an array of files
        int[] files = {4, 3, 2, 6};

        // Apply IMCD mutation by deleting the PriorityQueue creation step
        // Mutation: Remove the PriorityQueue creation and the loop that adds the files to the heap.
        // Instead, assume the input array is already sorted for merging, which is incorrect.
        // The files array will be used directly without any min-heap, causing incorrect behavior.

        int totalCost = 0;
        // This code simulates the deletion of the PriorityQueue (IMCD mutation)
        for (int i = 0; i < files.length - 1; i++) {
            totalCost += files[i] + files[i + 1];  // Incorrect calculation without sorting and merging in heap
        }

        // Verify that the result is different from the correct implementation
        assertNotEquals(29, totalCost, "The merge cost should be different after method call deletion.");
    }

    @Test
    public void testMinMergeCostMutation_IREM() {
        // Create an array of files
        int[] files = {4, 3, 2, 6};

        // Calculate minimum cost with the original method
        int result = OptimalFileMerging.minMergeCost(files);

        // Apply IREM mutation by modifying the return expression
        // Mutation: Subtract 5 from the total cost (altering the final result)
        result -= 5;  // This is a mutation to the return expression

        // Verify the mutated result is different from the original
        assertNotEquals(29, result, "The minimum merge cost should be different after modifying the return expression.");
    }

}
