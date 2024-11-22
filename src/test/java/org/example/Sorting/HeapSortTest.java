package Sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.example.Sorting.HeapSort;
import org.junit.jupiter.api.Test;

class HeapSortTest {

    @Test
    void testMaxHeap() {
        int[] input = {3, 1, 6, 5, 2, 4};
        int[] expectedMaxHeap = {6, 5, 4, 1, 2, 3}; // Result of max heap creation.

        int[] maxHeap = HeapSort.maxHeap(input, input.length);

        assertArrayEquals(expectedMaxHeap, maxHeap, "The array should be transformed into a max heap.");
    }

    @Test
    void testMinHeap() {
        int[] input = {3, 1, 6, 5, 2, 4};
        int[] expectedMinHeap = {1, 2, 4, 5, 3, 6}; // Result of min heap creation.

        int[] minHeap = HeapSort.minHeap(input, input.length);

        assertArrayEquals(expectedMinHeap, minHeap, "The array should be transformed into a min heap.");
    }

    @Test
    void testDelMaxHeap() {
        int[] maxHeap = {6, 5, 4, 1, 2, 3};
        int[] expectedSorted = {1, 2, 3, 4, 5, 6}; // Sorted in ascending order after removing max elements.

        int[] sorted = HeapSort.delMaxHeap(maxHeap);

        assertArrayEquals(expectedSorted, sorted, "The max heap should be sorted in ascending order.");
    }

    @Test
    void testDelMinHeap() {
        int[] minHeap = {1, 2, 4, 5, 3, 6};
        int[] expectedSorted = {6, 5, 4, 3, 2, 1}; // Sorted in descending order after removing min elements.

        int[] sorted = HeapSort.delMinHeap(minHeap);

        assertArrayEquals(expectedSorted, sorted, "The min heap should be sorted in descending order.");
    }

    @Test
    void testHeap() {
        int[] input = {3, 1, 6, 5, 2, 4};
        int[] expectedSorted = {1, 2, 3, 4, 5, 6}; // Final sorted output from the `heap` method.

        int[] sorted = HeapSort.heap(input, input.length);

        assertArrayEquals(expectedSorted, sorted, "The array should be fully sorted after processing with heap.");
    }
}

