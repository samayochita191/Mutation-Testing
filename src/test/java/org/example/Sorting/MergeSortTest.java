package Sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Sorting.MergeSort;
import org.junit.jupiter.api.Test;

public class MergeSortTest {

    @Test
    public void testMergeSort() {
        int[] arr = {10, 50, 60, 20, 30, 80, 90, 40, 100, 70};
        int[] expected = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Call the mergeSort method
        MergeSort.mergeSort(arr, 0, arr.length - 1);

        // Verify if the array is sorted in ascending order
        assertArrayEquals(expected, arr, "Array should be sorted in ascending order.");
    }

    @Test
    public void testMergeSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        // Call the mergeSort method
        MergeSort.mergeSort(arr, 0, arr.length - 1);

        // Verify if the empty array remains unchanged
        assertArrayEquals(expected, arr, "Empty array should remain unchanged.");
    }

    @Test
    public void testMergeSortSingleElementArray() {
        int[] arr = {5};
        int[] expected = {5};

        // Call the mergeSort method
        MergeSort.mergeSort(arr, 0, arr.length - 1);

        // Verify if the single element array remains unchanged
        assertArrayEquals(expected, arr, "Single element array should remain unchanged.");
    }

    @Test
    public void testMergeSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        // Call the mergeSort method
        MergeSort.mergeSort(arr, 0, arr.length - 1);

        // Verify if the already sorted array remains the same
        assertArrayEquals(expected, arr, "Already sorted array should remain unchanged.");
    }

    @Test
    public void testMergeSortReverseOrderArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        // Call the mergeSort method
        MergeSort.mergeSort(arr, 0, arr.length - 1);

        // Verify if the array is sorted correctly
        assertArrayEquals(expected, arr, "Array in reverse order should be sorted in ascending order.");
    }
}

