package Sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Sorting.ShellSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ShellSortTest {

    private ShellSort shellSort;

    @BeforeEach
    public void setUp() {
        shellSort = new ShellSort();
    }

    @Test
    public void testShellSort() {
        // Test case 1: Array with random integers
        int[] arr = {5, 8, 2, 9, 1, 3, 7};
        int[] expectedArr = {1, 2, 3, 5, 7, 8, 9};

        shellSort.shellSort(arr);
        assertArrayEquals(expectedArr, arr, "The array should be sorted in ascending order after shellSort.");
    }

    @Test
    public void testShellSortWithNegativeNumbers() {
        // Test case 2: Array with negative numbers
        int[] arr = {-5, -8, 2, 9, -1, 3, -7};
        int[] expectedArr = {-8, -7, -5, -1, 2, 3, 9};

        shellSort.shellSort(arr);
        assertArrayEquals(expectedArr, arr, "The array with negative numbers should be sorted in ascending order.");
    }

    @Test
    public void testShellSortAlreadySorted() {
        // Test case 3: Already sorted array
        int[] arr = {1, 2, 3, 5, 7, 8, 9};
        int[] expectedArr = {1, 2, 3, 5, 7, 8, 9};

        shellSort.shellSort(arr);
        assertArrayEquals(expectedArr, arr, "The array that is already sorted should remain the same after shellSort.");
    }

    @Test
    public void testShellSortEmptyArray() {
        // Test case 4: Empty array
        int[] arr = {};
        int[] expectedArr = {};

        shellSort.shellSort(arr);
        assertArrayEquals(expectedArr, arr, "An empty array should remain empty after shellSort.");
    }

    @Test
    public void testShellSortSingleElement() {
        // Test case 5: Array with a single element
        int[] arr = {42};
        int[] expectedArr = {42};

        shellSort.shellSort(arr);
        assertArrayEquals(expectedArr, arr, "An array with a single element should remain unchanged after shellSort.");
    }
}

