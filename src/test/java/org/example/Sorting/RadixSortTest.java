package Sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.example.Sorting.RadixSort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RadixSortTest {

    private RadixSort radixSort;

    @BeforeEach
    public void setUp() {
        radixSort = new RadixSort();
    }

    @Test
    public void testRadixSort() {
        // Test case 1: Array with random integers
        int[] arr = {170, 45, 75, 90, 802, 24, 2, 66};
        int[] expectedArr = {2, 24, 45, 66, 75, 90, 170, 802};

        radixSort.radixSort(arr);
        assertArrayEquals(expectedArr, arr, "The array should be sorted in ascending order after radixSort.");
    }

    @Test
    public void testRadixSortWithNegativeNumbers() {
        // Test case 2: Array with negative numbers
        int[] arr = {-170, -45, -75, -90, -802, -24, -2, -66};
        int[] expectedArr = {-802, -170, -90, -75, -66, -45, -24, -2};

        radixSort.radixSort(arr);
        assertArrayEquals(expectedArr, arr, "The array with negative numbers should be sorted in ascending order.");
    }

    @Test
    public void testRadixSortAlreadySorted() {
        // Test case 3: Already sorted array
        int[] arr = {2, 24, 45, 66, 75, 90, 170, 802};
        int[] expectedArr = {2, 24, 45, 66, 75, 90, 170, 802};

        radixSort.radixSort(arr);
        assertArrayEquals(expectedArr, arr, "The array that is already sorted should remain the same after radixSort.");
    }

    @Test
    public void testRadixSortEmptyArray() {
        // Test case 4: Empty array
        int[] arr = {};
        int[] expectedArr = {};

        radixSort.radixSort(arr);
        assertArrayEquals(expectedArr, arr, "An empty array should remain empty after radixSort.");
    }

    @Test
    public void testRadixSortSingleElement() {
        // Test case 5: Array with a single element
        int[] arr = {42};
        int[] expectedArr = {42};

        radixSort.radixSort(arr);
        assertArrayEquals(expectedArr, arr, "An array with a single element should remain unchanged after radixSort.");
    }
}
