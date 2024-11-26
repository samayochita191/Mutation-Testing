package org.example.Sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MergeSortTest {

    @Test
    public void testMergeSortAscending() {
        int[] arr = {10, 50, 60, 20, 30, 80, 90, 40, 100, 70};
        int[] expected = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        MergeSort.mergeSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr, "Array should be sorted in ascending order.");
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        MergeSort.mergeSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr, "Empty array should remain unchanged.");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {1};
        int[] expected = {1};

        MergeSort.mergeSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr, "Single-element array should remain unchanged.");
    }

    @Test
    public void testDuplicateElements() {
        int[] arr = {5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5};

        MergeSort.mergeSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr, "Array with duplicate elements should remain unchanged.");
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr = {-10, -50, -20, -30, -40};
        int[] expected = {-50, -40, -30, -20, -10};

        MergeSort.mergeSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr, "Array with negative numbers should be sorted in ascending order.");
    }

    @Test
    public void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        MergeSort.mergeSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr, "Already sorted array should remain unchanged.");
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        MergeSort.mergeSort(arr, 0, arr.length - 1);

        assertArrayEquals(expected, arr, "Reverse sorted array should be sorted in ascending order.");
    }
}
