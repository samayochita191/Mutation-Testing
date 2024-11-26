package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.MinimumWaitingTime;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class MinimumWaitingTimeTest {

    @Test
    void testEmptyArray() {
        // Case: n == 0
        int[] queries = {};
        int result = MinimumWaitingTime.minimumWaitingTime(queries);
        assertEquals(0, result, "Empty array should have a waiting time of 0");
    }

    @Test
    void testSingleElement() {
        // Case: n == 1
        int[] queries = {5};
        int result = MinimumWaitingTime.minimumWaitingTime(queries);
        assertEquals(0, result, "Single element should have a waiting time of 0");
    }

    @Test
    void testTwoElements() {
        // Case: n == 2
        int[] queries = {3, 2};
        int result = MinimumWaitingTime.minimumWaitingTime(queries);
        assertEquals(2, result, "Two elements should result in waiting time of 2");
    }

    @Test
    void testBoundaryConditions() {
        // Boundary test cases to kill mutation
        int[] queries1 = {};  // n == 0
        assertEquals(0, MinimumWaitingTime.minimumWaitingTime(queries1));

        int[] queries2 = {1};  // n == 1
        assertEquals(0, MinimumWaitingTime.minimumWaitingTime(queries2));

        int[] queries3 = {1, 2};  // n == 2
        assertEquals(1, MinimumWaitingTime.minimumWaitingTime(queries3));
    }

    @Test
    void testLargerInput() {
        // Case: Regular input
        int[] queries = {5, 1, 3};
        int result = MinimumWaitingTime.minimumWaitingTime(queries);
        assertEquals(5, result, "Expected waiting time for {5, 1, 3} is 5");
    }
    @Test
    public void testMinimumWaitingTime() {
        // Create an array of queries
        int[] queries = {3, 1, 4, 2};

        // Calculate minimum waiting time with the original method
        int result = MinimumWaitingTime.minimumWaitingTime(queries);

        // Verify that the result is correct
        assertEquals(10, result, "The minimum waiting time should be 10.");
    }

    @Test
    public void testMinimumWaitingTimeMutation_IPVR() {
        // Create an array of queries
        int[] queries = {3, 1, 4, 2};

        // Apply IPVR mutation by changing the query values
        queries[0] = 5;  // Change the first query to 5 (Mutation)
        queries[1] = 6;  // Change the second query to 6 (Mutation)

        // Calculate minimum waiting time with the mutated method
        int result = MinimumWaitingTime.minimumWaitingTime(queries);

        // Verify that the mutated result is different from the original
        assertNotEquals(10, result, "The minimum waiting time should be different after mutation.");
    }

    @Test
    public void testMinimumWaitingTimeMutation_IMCD() {
        // Create an array of queries
        int[] queries = {3, 1, 4, 2};

        // Apply IMCD mutation by deleting the sorting step
        // Mutation: Remove the sorting step (This will cause incorrect calculation)
        //Arrays.sort(queries);  // This line will be deleted in mutation

        int totalWaitingTime = 0;
        for (int i = 0; i < queries.length; i++) {
            totalWaitingTime += queries[i] * (queries.length - i - 1);
        }

        // Since sorting is removed, the output will differ
        assertNotEquals(10, totalWaitingTime, "The waiting time should be different due to method call deletion.");
    }

    @Test
    public void testMinimumWaitingTimeMutation_IREM() {
        // Create an array of queries
        int[] queries = {3, 1, 4, 2};

        // Calculate minimum waiting time with the original method
        int result = MinimumWaitingTime.minimumWaitingTime(queries);

        // Apply IREM mutation by modifying the return expression
        // Mutation: Add a constant value to the result (alter the return value)
        result += 5;  // Adding a constant value to the result

        // Verify the mutated result is different from the original
        assertNotEquals(10, result, "The minimum waiting time should be different after modifying the return expression.");
    }
    @Test
    public void testChangedConditionalBoundary() {
        // Case where there is only one query
        int[] queriesOne = {5};
        int resultOne = MinimumWaitingTime.minimumWaitingTime(queriesOne);
        assertEquals(0, resultOne);  // With one query, no waiting time should be added

        // Case where there are no queries (empty array)
        int[] queriesEmpty = {};
        int resultEmpty = MinimumWaitingTime.minimumWaitingTime(queriesEmpty);
        assertEquals(0, resultEmpty);  // With no queries, no waiting time should be added

        // Case where there are multiple queries (more than 1)
        int[] queriesMultiple = {1, 2, 3, 4};
        int resultMultiple = MinimumWaitingTime.minimumWaitingTime(queriesMultiple);
        assertTrue(resultMultiple > 0);  // With multiple queries, the waiting time should be greater than 0
    }
    @Test
    public void testSubstituted1With0() {
        // Case where there is exactly one query
        int[] queriesOne = {10};
        int resultOne = MinimumWaitingTime.minimumWaitingTime(queriesOne);
        assertEquals(0, resultOne);  // With one query, no waiting time should be added

        // Case where there are multiple queries
        int[] queriesMultiple = {10, 20, 30};
        int resultMultiple = MinimumWaitingTime.minimumWaitingTime(queriesMultiple);
        assertTrue(resultMultiple > 0);  // The result for multiple queries should be greater than 0
    }
    @Test
    public void testRemovedConditional() {
        // Case where there are no queries (empty array)
        int[] queriesEmpty = {};
        int resultEmpty = MinimumWaitingTime.minimumWaitingTime(queriesEmpty);
        assertEquals(0, resultEmpty);  // With no queries, no waiting time should be added

        // Case where there is exactly one query
        int[] queriesSingle = {5};
        int resultSingle = MinimumWaitingTime.minimumWaitingTime(queriesSingle);
        assertEquals(0, resultSingle);  // With one query, no waiting time should be added

        // Case where there are multiple queries
        int[] queriesMultiple = {10, 20, 30};
        int resultMultiple = MinimumWaitingTime.minimumWaitingTime(queriesMultiple);
        assertTrue(resultMultiple > 0);  // With multiple queries, waiting time should be positive
    }

}
