package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.StockProfitCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StockProfitCalculatorTest {

    @Test
    void testTypicalCase() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expectedProfit = 5; // Buy at 1, sell at 6
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testDescendingPrices() {
        int[] prices = {7, 6, 4, 3, 1};
        int expectedProfit = 0; // No profit can be made
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testSinglePrice() {
        int[] prices = {5};
        int expectedProfit = 0; // Only one price, no transactions possible
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testEmptyPrices() {
        int[] prices = {};
        int expectedProfit = 0; // No prices provided
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testNullPrices() {
        int[] prices = null;
        int expectedProfit = 0; // Null input should return 0
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testFlatPrices() {
        int[] prices = {5, 5, 5, 5};
        int expectedProfit = 0; // No price fluctuation
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testProfitAtEnd() {
        int[] prices = {2, 3, 10, 1, 4, 8};
        int expectedProfit = 8; // Buy at 2, sell at 10
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testProfitAtStart() {
        int[] prices = {1, 8, 2, 5};
        int expectedProfit = 7; // Buy at 1, sell at 8
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testMultipleProfitOptions() {
        int[] prices = {3, 1, 4, 8, 7, 2};
        int expectedProfit = 7; // Buy at 1, sell at 8
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }

    @Test
    void testLargeInput() {
        int[] prices = new int[1000];
        for (int i = 0; i < 1000; i++) {
            prices[i] = i + 1;
        }
        int expectedProfit = 999; // Buy at 1, sell at 1000
        assertEquals(expectedProfit, StockProfitCalculator.maxProfit(prices));
    }
    @Test
    public void testMaxProfit() {
        // Original test case: prices = [7, 1, 5, 3, 6, 4]
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Calculate maximum profit with the original method
        int result = StockProfitCalculator.maxProfit(prices);

        // Verify that the result is correct
        assertEquals(5, result, "The maximum profit should be 5 (buy at 1 and sell at 6).");
    }

    @Test
    public void testMaxProfitMutation_IPVR() {
        // Mutation: Modify the input array using IPVR by changing the values of the prices
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Change the price values (IPVR mutation)
        prices[0] = 8; // Change first price
        prices[1] = 2; // Change second price

        // Calculate maximum profit with the mutated method
        int result = StockProfitCalculator.maxProfit(prices);

        // Verify that the mutated result is different from the original result
        assertNotEquals(5, result, "The maximum profit should be different after parameter variable replacement.");
    }

    @Test
    public void testMaxProfitMutation_IMCD() {
        // Create an array of prices
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Apply IMCD mutation by deleting the key method call (Math.min)
        // Mutation: Remove the call to Math.min for tracking the minimum price
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int price : prices) {
            // Removed the minPrice update call (IMCD mutation)
            // minPrice = Math.min(price, minPrice); // Mutation: Deleted this line
            maxProfit = Math.max(price - minPrice, maxProfit);
        }

        // Verify that the result is different from the correct implementation
        assertNotEquals(5, maxProfit, "The maximum profit should be different after method call deletion.");
    }

    @Test
    public void testMaxProfitMutation_IREM() {
        // Create an array of prices
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Calculate maximum profit with the original method
        int result = StockProfitCalculator.maxProfit(prices);

        // Apply IREM mutation by modifying the return expression
        // Mutation: Subtract 1 from the total profit (altering the final result)
        result -= 1;  // This is a mutation to the return expression

        // Verify the mutated result is different from the original
        assertNotEquals(5, result, "The maximum profit should be different after modifying the return expression.");
    }

    @Test
    public void testMaxProfitMutation_IPEX() {
        // Create an array of prices
        int[] prices = {7, 1, 5, 3, 6, 4};

        // Apply IPEX mutation by swapping two parameters in the input array
        // Mutation: Swap the first two prices (parameter exchange)
        int temp = prices[0];
        prices[0] = prices[1];  // IPEX mutation: swapping first and second prices
        prices[1] = temp;

        // Calculate maximum profit with the mutated method
        int result = StockProfitCalculator.maxProfit(prices);

        // Verify that the mutated result is different from the original
        assertNotEquals(5, result, "The maximum profit should be different after parameter exchange.");
    }
}
