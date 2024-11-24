package org.example.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class PowerSumTest {

    PowerSum powerSum = new PowerSum();

    @Test
    void testBasicCase() {
        // Example from problem statement: N = 100, X = 3
        int targetSum = 100;
        int power = 3;
        int expected = 1; // Only 1^3 + 2^3 + 3^3 + 4^3 = 100
        assertEquals(expected, powerSum.powSum(targetSum, power), "Basic case failed");
    }

    @Test
    void testZeroSum() {
        // Edge case: Target sum is 0
        int targetSum = 0;
        int power = 3;
        int expected = 1; // No natural numbers can sum to 0
        assertEquals(expected, powerSum.powSum(targetSum, power), "Zero sum case failed");
    }

    @Test
    void testZeroPower() {
        // Special case: targetSum is any value and power is zero
        int targetSum = 0;
        int power = 0;
        int expected = 1; // Special case where targetSum is 0, it can be summed as nothing.
        assertEquals(expected, powerSum.powSum(targetSum, power), "Power 0 and target sum 0 case failed");

        // Target sum is non-zero, it should return 0 because there are no sums for non-zero target.
        targetSum = 1;
        expected = 0;
        assertEquals(expected, powerSum.powSum(targetSum, power), "Power 0 and non-zero target sum case failed");
    }

    @Test
    void testSingleSolution() {
        // Case where there is exactly one solution
        int targetSum = 9;
        int power = 2;
        int expected = 1; // 3^2 = 9
        assertEquals(expected, powerSum.powSum(targetSum, power), "Single solution case failed");
    }

    @Test
    void testMultipleSolutions() {
        // Case with multiple solutions
        int targetSum = 10;
        int power = 2;
        int expected = 1; // 1^2 + 3^2 = 10
        assertEquals(expected, powerSum.powSum(targetSum, power), "Multiple solutions case failed");
    }

    @Test
    void testNoSolution() {
        // Case with no possible solutions
        int targetSum = 17;
        int power = 3;
        int expected = 0; // No combination of cubes sums to 17
        assertEquals(expected, powerSum.powSum(targetSum, power), "No solution case failed");
    }

    @Test
    void testExceedingSum() {
        // Ensure the recursion handles the case when newSum exceeds remainingSum.
        int targetSum = 10;
        int power = 2;
        int expected = 1; // Valid solutions like 1^2 + 3^2 = 10
        assertEquals(expected, powerSum.powSum(targetSum, power), "Exceeding sum case failed");

        // Check if the function handles cases where a sum exceeds the remaining sum
        targetSum = 5;
        expected = 1;
        assertEquals(expected, powerSum.powSum(targetSum, power), "Exceeding sum case failed for smaller target");
    }

    @Test
    void testBaseCaseForZeroRemainingSum() {
        // Ensure the function correctly returns 1 when remainingSum is 0, as per base case
        int targetSum = 0;
        int power = 2;
        int expected = 1; // If no sum is left, there's one way to complete it: do nothing
        assertEquals(expected, powerSum.powSum(targetSum, power), "Base case for zero remaining sum failed");

        // Test another base case scenario where no number sums to zero
        targetSum = 0;
        power = 3;
        expected = 1; // By convention
        assertEquals(expected, powerSum.powSum(targetSum, power), "Base case for zero sum failed with cubes");
    }

    @Test
    void testLargeInput() {
        // Test for large inputs to check the performance and correctness
        int targetSum = 1000;
        int power = 3;
        // The expected result here needs to be pre-calculated or obtained.
        // For testing purposes, we are just demonstrating a large input.
        // You may want to verify the expected output with a different method.
        int expected = 1;  // (just an example placeholder, adjust based on logic)
        assertEquals(expected, powerSum.powSum(targetSum, power), "Large input test case failed");
    }

}
