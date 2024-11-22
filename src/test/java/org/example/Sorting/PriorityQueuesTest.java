package org.example.Sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Sorting.PriorityQueues;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PriorityQueuesTest {

    private PriorityQueues priorityQueues;

    @BeforeEach
    public void setUp() {
        priorityQueues = new PriorityQueues();
    }

    @Test
    public void testInsertQueue() {
        // Directly simulate the insertion without user input

        // Test array before insertion
        int[] arr = {10, 20, 30, 40, 50};

        // Simulate an insertion by directly modifying the array
        int[] expectedArr = {50, 40, 30, 10, 20, 100}; // Expected result after insertion (assumes insertion of 100)

        // Call insertQueue method by modifying the array directly
        int[] newArr = priorityQueues.insertQueue(arr); // Assume 100 is the value inserted

        // Verify the array is correctly updated
        assertArrayEquals(expectedArr, newArr, "Array after insertion should match the expected result.");
    }

    @Test
    public void testSwap() {
        // Test the swap method
        int[] arr = {10, 20, 30};

        // Swap the first and last elements
        priorityQueues.swap(arr, 0, 2);

        int[] expectedArr = {30, 20, 10};

        // Verify that the swap was successful
        assertArrayEquals(expectedArr, arr, "After swapping, the array should be correctly updated.");
    }

    @Test
    public void testHeapMax() {
        // Test heapMax to check if the max element is correctly identified
        int[] arr = {10, 20, 30, 40, 50};

        // Call heapMax and verify the array after insertion and heapify
        int[] expectedArr = {50, 40, 30, 10, 20, 100}; // Assuming 100 is inserted correctly

        priorityQueues.heapMax(arr); // Calls insertQueue internally

        // Check if the array is correctly updated after heap operation
        assertArrayEquals(expectedArr, arr, "Array after heapMax should match the expected result.");
    }
}
