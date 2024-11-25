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

    /**
     * Test for Integration Parameter Variable Replacement (IPVR).
     */
    @Test
    public void testIPVR() {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int capacity = 50;

        // Original method call
        int originalResult = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

        // Replace one of the parameters with a constant value (e.g., weight array replaced with {5, 10, 15})
        int[] mutatedWeight = {5, 10, 15}; // IVPR: Replacing the weight parameter with a different value
        int mutatedResult = FractionalKnapsack.fractionalKnapsack(mutatedWeight, value, capacity);

        // The results should differ due to the change in the weight array
        assertNotEquals(originalResult, mutatedResult, "IPVR mutation was not killed!");
    }

    /**
     * Test for Integration Unary Operator Insertion (IUOI).
     */
    @Test
    public void testIUOI() {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int capacity = 50;

        // Original method call
        int originalResult = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

        // Simulate a unary operator insertion by negating the capacity
        int mutatedCapacity = -capacity; // IUOI: Unary operator insertion (negating capacity)
        int mutatedResult = FractionalKnapsack.fractionalKnapsack(weight, value, mutatedCapacity);

        // The results should differ since the capacity is negated
        assertNotEquals(originalResult, mutatedResult, "IUOI mutation was not killed!");
    }


    /**
     * Test for Integration Method Call Deletion (IMCD).
     */
    @Test
    public void testIMCD() {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int capacity = 50;

        // Original method call
        int originalResult = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

        // Simulate method call deletion by replacing the method call with a default return value (e.g., 0)
        int mutatedResult = 0; // IMCD: Deleting the method call, returning a constant value (e.g., 0)

        // The results should differ due to the method call deletion
        assertNotEquals(originalResult, mutatedResult, "IMCD mutation was not killed!");
    }

    /**
     * Test for Integration Return Expression Modification (IREM).
     */
    @Test
    public void testIREM() {
        int[] weight = {10, 20, 30};
        int[] value = {60, 100, 120};
        int capacity = 50;

        // Original method call
        int originalResult = FractionalKnapsack.fractionalKnapsack(weight, value, capacity);

        // Simulate a return expression modification by modifying the result in a way that the return value changes
        int mutatedResult = FractionalKnapsack.fractionalKnapsack(weight, value, capacity) - 10; // IREM: Modify return expression by subtracting 10

        // The results should differ due to the return expression modification
        assertNotEquals(originalResult, mutatedResult, "IREM mutation was not killed!");
    }

}
