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
}
