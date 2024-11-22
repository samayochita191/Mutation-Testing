package Sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Sorting.QuickSort;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @Test
    public void testQuickSort() {
        int[] arr = {5, 6, 11, 14, 19, 20, 23, 32, 54, 65, 78, 87, 88};
        int[] expected = {5, 6, 11, 14, 19, 20, 23, 32, 54, 65, 78, 87, 88};

        // Call the quickSort method
        QuickSort.quickSort(arr, 0, arr.length - 1);

        // Verify if the array is sorted in ascending order
        assertArrayEquals(expected, arr, "Array should be sorted in ascending order.");
    }

    @Test
    public void testQuickSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        // Call the quickSort method
        QuickSort.quickSort(arr, 0, arr.length - 1);

        // Verify if the empty array remains unchanged
        assertArrayEquals(expected, arr, "Empty array should remain unchanged.");
    }

    @Test
    public void testQuickSortSingleElementArray() {
        int[] arr = {5};
        int[] expected = {5};

        // Call the quickSort method
        QuickSort.quickSort(arr, 0, arr.length - 1);

        // Verify if the single-element array remains unchanged
        assertArrayEquals(expected, arr, "Single element array should remain unchanged.");
    }

    @Test
    public void testQuickSortAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        // Call the quickSort method
        QuickSort.quickSort(arr, 0, arr.length - 1);

        // Verify if the already sorted array remains the same
        assertArrayEquals(expected, arr, "Already sorted array should remain unchanged.");
    }

    @Test
    public void testQuickSortReverseOrderArray() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {1, 2, 3, 4, 5};

        // Call the quickSort method
        QuickSort.quickSort(arr, 0, arr.length - 1);

        // Verify if the array is sorted correctly
        assertArrayEquals(expected, arr, "Array in reverse order should be sorted in ascending order.");
    }
}
