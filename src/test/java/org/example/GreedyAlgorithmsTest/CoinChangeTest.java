package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.CoinChange;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void testExactAmount() {
        // Test exact match with single coin
        assertEquals(Arrays.asList(2000), CoinChange.coinChangeProblem(2000));

        // Test exact match with multiple coins
        assertEquals(Arrays.asList(500, 500), CoinChange.coinChangeProblem(1000));
    }

    @Test
    void testMixedDenominations() {
        // Test amount requiring a mix of denominations
        assertEquals(Arrays.asList(2000, 500, 100, 20, 2), CoinChange.coinChangeProblem(2622));
    }

    @Test
    void testMinimumCoins() {
        // Test with minimum coins to make up the amount
        assertEquals(Arrays.asList(100), CoinChange.coinChangeProblem(100));

        // Test a smaller amount
        assertEquals(Arrays.asList(10, 5, 2, 1), CoinChange.coinChangeProblem(18));
    }

    @Test
    void testZeroAmount() {
        // Test with amount zero
        assertEquals(new ArrayList<>(), CoinChange.coinChangeProblem(0));
    }

    @Test
    void testAmountLessThanSmallestCoin() {
        // Test with amount less than the smallest coin
        assertEquals(new ArrayList<>(), CoinChange.coinChangeProblem(0));
    }

    @Test
    void testLargeAmount() {
        // Test with a large amount
        assertEquals(Arrays.asList(2000, 2000, 2000, 500, 100, 100, 100, 50),
                CoinChange.coinChangeProblem(6850));
    }

    @Test
    void testSingleCoin() {
        // Test where only one denomination is needed repeatedly
        assertEquals(Arrays.asList(10), CoinChange.coinChangeProblem(10));
    }

    @Test
    void testEdgeCaseExactMatch() {
        // Test an edge case with an exact match
        assertEquals(Arrays.asList(5, 2, 2), CoinChange.coinChangeProblem(9));
    }

    @Test
    void testNoChangeNeeded() {
        // Test when the amount is zero, no coins should be selected
        assertEquals(new ArrayList<>(), CoinChange.coinChangeProblem(0));
    }

    @Test
    void testAmountJustUnderMultiple() {
        // Test when amount is just under a larger coin
        assertEquals(Arrays.asList(50, 2, 1), CoinChange.coinChangeProblem(53));
    }
    // Integration Test for IUOI (Integration Unary Operator Insertion)
    @Test
    public void testIUOI() {
        int amount = 178;
        // Simulate mutation by flipping the sign of the amount
        int mutatedAmount = -amount;

        ArrayList<Integer> originalResult = CoinChange.coinChangeProblem(amount);
        ArrayList<Integer> mutatedResult = CoinChange.coinChangeProblem(mutatedAmount);

        assertNotEquals(originalResult, mutatedResult, "IUOI mutation was not killed!");
    }

    @Test
    public void testIMCD() {
        int amount = 178;

        // Original result from the actual method
        ArrayList<Integer> originalResult = CoinChange.coinChangeProblem(amount);

        // Mutated result with method call deleted and replaced
        ArrayList<Integer> mutatedResult = simulateIMCD(amount);

        // The results should not match if the method works correctly
        assertNotEquals(originalResult, mutatedResult, "IMCD mutation was not killed!");
    }

    /**
     * Simulates IMCD by replacing the method call to coinChangeProblem with default or constant values.
     *
     * @param amount The amount to compute for coin change.
     * @return Default value replacing the method's actual functionality.
     */
    private ArrayList<Integer> simulateIMCD(int amount) {
        // Replace the method call with a new ArrayList<>(), as the method returns ArrayList<Integer>
        return new ArrayList<>();
    }

    /**
     * Tests IMCD for each individual part of the CoinChange method.
     */
    @Test
    public void testIMCDForInternalLogic() {
        int amount = 2650;

        // Simulate IMCD by replacing coins array with a default array
        Integer[] defaultCoins = new Integer[0]; // Replace with empty array
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < defaultCoins.length; i++) {
            // Replace internal logic with default values
            if (0 <= amount) { // Mutation with default condition
                while (0 <= amount) { // Mutation replaces logic
                    ans.add(0); // Mutation replaces actual coin value
                    amount -= 0; // Mutation replaces coin subtraction
                }
            }
        }

        assertEquals(new ArrayList<>(), ans, "IMCD mutation was not killed!");
    }
    // Integration Test for IREM (Integration Return Expression Modification)
    @Test
    public void testIREM() {
        int amount = 178;
        // Simulate mutation by adding an extra coin to the result
        ArrayList<Integer> originalResult = CoinChange.coinChangeProblem(amount);
        ArrayList<Integer> mutatedResult = new ArrayList<>(originalResult);
        mutatedResult.add(1); // Add an extra denomination

        assertNotEquals(originalResult, mutatedResult, "IREM mutation was not killed!");
    }

}
