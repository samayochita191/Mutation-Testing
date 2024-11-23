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
}
