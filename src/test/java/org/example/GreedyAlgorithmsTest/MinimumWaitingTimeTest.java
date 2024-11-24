package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.MinimumWaitingTime;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
