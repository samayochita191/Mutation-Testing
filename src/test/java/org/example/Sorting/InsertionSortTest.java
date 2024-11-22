package Sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Sorting.InsertionSort;
import org.junit.jupiter.api.Test;

public class InsertionSortTest {

    @Test
    public void testInsertionSortAscending() {
        int[] arr = { 12, 11, 13, 5, 6 };
        int[] expected = { 5, 6, 11, 12, 13 };
        InsertionSort.insertionSort(arr, arr.length);

        // Check if the array is sorted in ascending order
        assertArrayEquals(expected, arr, "Array should be sorted in ascending order.");
    }

    @Test
    public void testInvertInsertionSortDescending() {
        int[] arr = { 12, 11, 13, 5, 6 };
        int[] expected = { 13, 12, 11, 6, 5 };
        InsertionSort.invertInsertion(arr, arr.length);

        // Check if the array is sorted in descending order
        assertArrayEquals(expected, arr, "Array should be sorted in descending order.");
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        int[] expected = {};
        InsertionSort.insertionSort(arr, arr.length);

        // Check if the empty array remains empty
        assertArrayEquals(expected, arr, "Empty array should remain empty.");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = { 10 };
        int[] expected = { 10 };
        InsertionSort.insertionSort(arr, arr.length);

        // Check if the single-element array remains unchanged
        assertArrayEquals(expected, arr, "Single element array should remain the same.");
    }

    @Test
    public void testAlreadySortedArrayAscending() {
        int[] arr = { 5, 6, 11, 12, 13 };
        int[] expected = { 5, 6, 11, 12, 13 };
        InsertionSort.insertionSort(arr, arr.length);

        // Check if the already sorted array remains the same in ascending order
        assertArrayEquals(expected, arr, "Array already sorted in ascending order should remain unchanged.");
    }

    @Test
    public void testAlreadySortedArrayDescending() {
        int[] arr = { 13, 12, 11, 6, 5 };
        int[] expected = { 13, 12, 11, 6, 5 };
        InsertionSort.invertInsertion(arr, arr.length);

        // Check if the already sorted array remains the same in descending order
        assertArrayEquals(expected, arr, "Array already sorted in descending order should remain unchanged.");
    }
}
