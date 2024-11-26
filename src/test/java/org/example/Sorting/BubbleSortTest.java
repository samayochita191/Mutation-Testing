package org.example.Sorting;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @Test
    public void testBubbleSort() {
        int[] arr = {5, 2, 9, 1, 5, 6};
        int[] expectedArr = {1, 2, 5, 5, 6, 9};

        BubbleSort.bubbleSort(arr, arr.length);

        assertArrayEquals(expectedArr, arr, "The array should be sorted in ascending order.");
    }

    @Test
    public void testBubbleSortEmptyArray() {
        int[] arr = {};
        int[] expectedArr = {};

        BubbleSort.bubbleSort(arr, arr.length);

        assertArrayEquals(expectedArr, arr, "An empty array should remain empty after sorting.");
    }

    @Test
    public void testBubbleSortSingleElement() {
        int[] arr = {42};
        int[] expectedArr = {42};

        BubbleSort.bubbleSort(arr, arr.length);

        assertArrayEquals(expectedArr, arr, "An array with a single element should remain unchanged.");
    }

    @Test
    public void testBubbleSortAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expectedArr = {1, 2, 3, 4, 5};

        BubbleSort.bubbleSort(arr, arr.length);

        assertArrayEquals(expectedArr, arr, "An already sorted array should remain unchanged.");
    }

    @Test
    public void testBubbleSortDif() {
        int[] arr = {8, 3, 7, 4, 2, 6};
        int[] expectedArr = {2, 3, 4, 6, 7, 8};

        BubbleSort.bubbleSortDif(arr, arr.length);

        assertArrayEquals(expectedArr, arr, "The array should be sorted in ascending order using bubbleSortDif.");
    }

    @Test
    public void testBubbleSortDifEmptyArray() {
        int[] arr = {};
        int[] expectedArr = {};

        BubbleSort.bubbleSortDif(arr, arr.length);

        assertArrayEquals(expectedArr, arr, "An empty array should remain empty after sorting with bubbleSortDif.");
    }

    @Test
    public void testBubbleSortDifSingleElement() {
        int[] arr = {99};
        int[] expectedArr = {99};

        BubbleSort.bubbleSortDif(arr, arr.length);

        assertArrayEquals(expectedArr, arr, "An array with a single element should remain unchanged.");
    }

    @Test
    public void testBubbleSortDifAlreadySorted() {
        int[] arr = {1, 2, 3, 4, 5};
        int[] expectedArr = {1, 2, 3, 4, 5};

        BubbleSort.bubbleSortDif(arr, arr.length);

        assertArrayEquals(expectedArr, arr, "An already sorted array should remain unchanged using bubbleSortDif.");
    }
}
