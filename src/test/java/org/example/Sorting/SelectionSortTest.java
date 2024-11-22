package Sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Sorting.SelectionSort;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {

    @Test
    public void testSelectionSortAscending() {
        int[] arr = {10, 50, 60, 20, 30, 80, 90, 40, 100, 70};
        int[] expected = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        // Call the selectionSort method
        SelectionSort.selectionSort(arr, arr.length);

        // Verify if the array is sorted in ascending order
        assertArrayEquals(expected, arr, "Array should be sorted in ascending order.");
    }

    @Test
    public void testSelectionSortDescending() {
        int[] arr = {10, 50, 60, 20, 30, 80, 90, 40, 100, 70};
        int[] expected = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10};

        // Call the selectionSortDesc method
        SelectionSort.selectionSortDesc(arr, arr.length);

        // Verify if the array is sorted in descending order
        assertArrayEquals(expected, arr, "Array should be sorted in descending order.");
    }

    @Test
    public void testSelectionSortEmptyArray() {
        int[] arr = {};
        int[] expected = {};

        // Call the selectionSort method
        SelectionSort.selectionSort(arr, arr.length);

        // Verify if the empty array remains unchanged
        assertArrayEquals(expected, arr, "Empty array should remain unchanged.");
    }

    @Test
    public void testSelectionSortSingleElementArray() {
        int[] arr = {5};
        int[] expected = {5};

        // Call the selectionSort method
        SelectionSort.selectionSort(arr, arr.length);

        // Verify if the single-element array remains unchanged
        assertArrayEquals(expected, arr, "Single element array should remain unchanged.");
    }

    @Test
    public void testSelectionSortAlreadySortedArrayAscending() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};

        // Call the selectionSort method
        SelectionSort.selectionSort(arr, arr.length);

        // Verify if the already sorted array remains the same in ascending order
        assertArrayEquals(expected, arr, "Array already sorted in ascending order should remain unchanged.");
    }

    @Test
    public void testSelectionSortAlreadySortedArrayDescending() {
        int[] arr = {5, 4, 3, 2, 1};
        int[] expected = {5, 4, 3, 2, 1};

        // Call the selectionSortDesc method
        SelectionSort.selectionSortDesc(arr, arr.length);

        // Verify if the already sorted array remains the same in descending order
        assertArrayEquals(expected, arr, "Array already sorted in descending order should remain unchanged.");
    }
}
