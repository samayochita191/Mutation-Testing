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
}
