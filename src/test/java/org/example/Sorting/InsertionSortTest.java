package org.example.Sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InsertionSortTest {

    @Test
    public void testInsertionSortAscending() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {1, 2, 5, 5, 6, 9};

        InsertionSort.insertionSort(arr, arr.length);

        assertArrayEquals(expected, arr, "Array should be sorted in ascending order.");
    }

    @Test
    public void testInsertionSortDescending() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expected = {9, 6, 5, 5, 2, 1};

        InsertionSort.invertInsertion(arr, arr.length);

        assertArrayEquals(expected, arr, "Array should be sorted in descending order.");
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        InsertionSort.insertionSort(arr, arr.length);

        assertArrayEquals(expected, arr, "Empty array should remain unchanged.");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {1};
        int[] expected = {1};

        InsertionSort.insertionSort(arr, arr.length);

        assertArrayEquals(expected, arr, "Single-element array should remain unchanged.");
    }

    @Test
    public void testDuplicateElements() {
        int[] arr = {3, 3, 3, 3};
        int[] expected = {3, 3, 3, 3};

        InsertionSort.insertionSort(arr, arr.length);

        assertArrayEquals(expected, arr, "Array with duplicate elements should remain unchanged.");
    }

    @Test
    public void testNegativeNumbers() {
        int[] arr = {-3, -1, -7, -4};
        int[] expectedAsc = {-7, -4, -3, -1};
        int[] expectedDesc = {-1, -3, -4, -7};

        InsertionSort.insertionSort(arr, arr.length);
        assertArrayEquals(expectedAsc, arr, "Array should be sorted in ascending order with negative numbers.");

        InsertionSort.invertInsertion(arr, arr.length);
        assertArrayEquals(expectedDesc, arr, "Array should be sorted in descending order with negative numbers.");
    }

    @Test
    public void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        InsertionSort.insertionSort(arr, arr.length);

        assertArrayEquals(expected, arr, "Already sorted array should remain unchanged.");
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expectedAsc = {1, 2, 3, 4, 5};
        int[] expectedDesc = {5, 4, 3, 2, 1};

        InsertionSort.insertionSort(arr, arr.length);
        assertArrayEquals(expectedAsc, arr, "Reverse sorted array should be sorted in ascending order.");

        InsertionSort.invertInsertion(arr, arr.length);
        assertArrayEquals(expectedDesc, arr, "Ascending sorted array should be sorted back to descending order.");
    }
}
