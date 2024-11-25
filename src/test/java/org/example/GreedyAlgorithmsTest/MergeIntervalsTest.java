package org.example.GreedyAlgorithmsTest;

import org.example.GreedyAlgorithms.MergeIntervals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    /**
     * Test Case 1: Basic merge case with overlapping intervals
     * Example:
     * Input: {{1, 3}, {2, 6}, {8, 10}, {15, 18}}
     * Expected Output: {{1, 6}, {8, 10}, {15, 18}}
     */
    @Test
    void testBasicMerge() {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] result = MergeIntervals.merge(intervals);

        // Expected merged intervals
        int[][] expected = {
                {1, 6},
                {8, 10},
                {15, 18}
        };

        assertArrayEquals(expected, result);
    }

    /**
     * Test Case 2: Case with no overlapping intervals
     * Example:
     * Input: {{1, 2}, {3, 4}, {5, 6}}
     * Expected Output: {{1, 2}, {3, 4}, {5, 6}}
     */
    @Test
    void testNoOverlap() {
        int[][] intervals = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        int[][] result = MergeIntervals.merge(intervals);

        // No merging needed as there are no overlapping intervals
        int[][] expected = {
                {1, 2},
                {3, 4},
                {5, 6}
        };

        assertArrayEquals(expected, result);
    }

    /**
     * Test Case 3: Case where all intervals overlap
     * Example:
     * Input: {{1, 4}, {2, 5}, {3, 6}}
     * Expected Output: {{1, 6}}
     */
    @Test
    void testAllOverlap() {
        int[][] intervals = {
                {1, 4},
                {2, 5},
                {3, 6}
        };

        int[][] result = MergeIntervals.merge(intervals);

        // All intervals merge into a single interval [1, 6]
        int[][] expected = {
                {1, 6}
        };

        assertArrayEquals(expected, result);
    }

    /**
     * Test Case 4: Edge case with a single interval
     * Example:
     * Input: {{1, 2}}
     * Expected Output: {{1, 2}}
     */
    @Test
    void testSingleInterval() {
        int[][] intervals = {
                {1, 2}
        };

        int[][] result = MergeIntervals.merge(intervals);

        // Only one interval, no merging needed
        int[][] expected = {
                {1, 2}
        };

        assertArrayEquals(expected, result);
    }

    /**
     * Test Case 5: Case where intervals are sorted in reverse order
     * Example:
     * Input: {{5, 6}, {1, 3}, {2, 5}}
     * Expected Output: {{1, 6}}
     */
    @Test
    void testReverseOrder() {
        int[][] intervals = {
                {5, 6},
                {1, 3},
                {2, 5}
        };

        int[][] result = MergeIntervals.merge(intervals);

        // Intervals are merged into a single interval [1, 6]
        int[][] expected = {
                {1, 6}
        };

        assertArrayEquals(expected, result);
    }

    /**
     * Test Case 6: Case with intervals having the same start and end
     * Example:
     * Input: {{1, 3}, {1, 3}, {1, 3}}
     * Expected Output: {{1, 3}}
     */
    @Test
    void testSameIntervals() {
        int[][] intervals = {
                {1, 3},
                {1, 3},
                {1, 3}
        };

        int[][] result = MergeIntervals.merge(intervals);

        // All intervals are the same, merge into a single [1, 3]
        int[][] expected = {
                {1, 3}
        };

        assertArrayEquals(expected, result);
    }

    /**
     * Test Case 7: Case where intervals are large and mixed
     * Example:
     * Input: {{1, 10}, {2, 6}, {8, 10}, {15, 20}}
     * Expected Output: {{1, 10}, {15, 20}}
     */
    @Test
    void testLargeMixedIntervals() {
        int[][] intervals = {
                {1, 10},
                {2, 6},
                {8, 10},
                {15, 20}
        };

        int[][] result = MergeIntervals.merge(intervals);

        // Expected merged intervals
        int[][] expected = {
                {1, 10},
                {15, 20}
        };

        assertArrayEquals(expected, result);
    }
    @Test
    void testIPVR() {
        // IPVR: Integration Parameter Variable Replacement
        // Replace one or more parameters with alternate values

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] originalResult = MergeIntervals.merge(intervals);

        // Replace intervals with a different set of input
        int[][] mutatedIntervals = {{1, 4}, {5, 6}, {8, 10}, {15, 20}};
        int[][] mutatedResult = MergeIntervals.merge(mutatedIntervals);

        // Verify that the results differ due to mutation
        assertNotEquals(originalResult, mutatedResult, "IVPR mutation failed: Results are the same.");
    }

    @Test
    void testIMCD() {
        // IMCD: Integration Method Call Deletion
        // Simulate deleting the merge method call and replacing it with a default result

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] originalResult = MergeIntervals.merge(intervals);

        // Simulated mutation: Replace the method result with an empty array
        int[][] mutatedResult = new int[0][];

        // Verify that the mutation causes a different result
        assertNotEquals(originalResult, mutatedResult, "IMCD mutation failed: Results are the same.");
    }

    @Test
    void testIREM() {
        // IREM: Integration Return Expression Modification
        // Modify the return value of the merge method to simulate a mutation

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] originalResult = MergeIntervals.merge(intervals);

        // Simulated mutation: Add an extra interval to the result
        int[][] mutatedResult = new int[originalResult.length + 1][];
        System.arraycopy(originalResult, 0, mutatedResult, 0, originalResult.length);
        mutatedResult[originalResult.length] = new int[]{0, 0};

        // Verify that the mutation causes a different result
        assertNotEquals(originalResult, mutatedResult, "IREM mutation failed: Results are the same.");
    }

    @Test
    void testIPEX() {
        // IPEX: Integration Parameter Exchange
        // Swap the start and end times in the intervals to test compatibility and result changes

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] originalResult = MergeIntervals.merge(intervals);

        // Mutated intervals: Swap start and end times
        int[][] swappedIntervals = {{3, 1}, {6, 2}, {10, 8}, {18, 15}};
        int[][] mutatedResult = MergeIntervals.merge(swappedIntervals);

        // Verify that the mutation causes a different result
        assertNotEquals(originalResult, mutatedResult, "IPEX mutation failed: Results are the same.");
    }

}
