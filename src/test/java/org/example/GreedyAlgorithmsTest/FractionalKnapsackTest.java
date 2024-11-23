package org.example.GreedyAlgorithmsTest;


import org.example.GreedyAlgorithms.FractionalKnapsack;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FractionalKnapsackTest {

    @Test
    void testBasicScenario() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 50;

        // Expected maximum value is 240 (take full item 2 and part of item 3)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(240, result);
    }

    @Test
    void testExactFit() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 60;

        // Expected maximum value is 280 (take all items exactly)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(280, result);
    }

    @Test
    void testSingleItemFits() {
        int[] weights = {10};
        int[] values = {50};
        int capacity = 10;

        // Expected maximum value is 50 (only one item fits perfectly)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(50, result);
    }

    @Test
    void testPartialItem() {
        int[] weights = {4, 8};
        int[] values = {40, 50};
        int capacity = 5;

        // Expected maximum value is 40 (take item 1 fully, and fraction of item 2)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(46, result);
    }

    @Test
    void testZeroCapacity() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 0;

        // Expected maximum value is 0 (no capacity available)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(0, result);
    }

    @Test
    void testZeroWeightItems() {
        int[] weights = {0, 20, 30};
        int[] values = {0, 100, 120};
        int capacity = 50;

        // Expected maximum value is 220 (skip the zero-weight item)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(220, result);
    }

    @Test
    void testLargeCapacity() {
        int[] weights = {10, 20, 30};
        int[] values = {60, 100, 120};
        int capacity = 100;

        // Expected maximum value is 280 (take all items)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(280, result);
    }

    @Test
    void testLargeInputs() {
        int[] weights = {10, 40, 30, 50};
        int[] values = {100, 280, 120, 200};
        int capacity = 100;

        // Expected maximum value is 480
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(580, result);
    }

    @Test
    void testEqualRatios() {
        int[] weights = {10, 20};
        int[] values = {100, 200};
        int capacity = 15;

        // Expected maximum value is 150 (take part of the second item after the first)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(150, result);
    }

    @Test
    void testEmptyItems() {
        int[] weights = {};
        int[] values = {};
        int capacity = 50;

        // Expected maximum value is 0 (no items available)
        int result = FractionalKnapsack.fractionalKnapsack(weights, values, capacity);
        assertEquals(0, result);
    }

}
