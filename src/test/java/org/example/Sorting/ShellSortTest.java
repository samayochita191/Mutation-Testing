package org.example.Sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ShellSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        ShellSort.shellSort(arr);
        assertArrayEquals(new int[]{}, arr);
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {5};
        ShellSort.shellSort(arr);
        assertArrayEquals(new int[]{5}, arr);
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        ShellSort.shellSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        ShellSort.shellSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testUnsortedArray() {
        int[] arr = {3, 1, 4, 5, 2};
        ShellSort.shellSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr);
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {3, 3, 1, 2, 1};
        ShellSort.shellSort(arr);
        assertArrayEquals(new int[]{1, 1, 2, 3, 3}, arr);
    }

    @Test
    void testLargeArray() {
        int[] arr = new int[1000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int)(Math.random() * 1000);  // Random values
        }
        int[] expected = arr.clone();
        Arrays.sort(expected);  // Sorting the expected result
        ShellSort.shellSort(arr);
        assertArrayEquals(expected, arr);
    }

    @Test
    void testArrayWithNegativeValues() {
        int[] arr = {3, -1, 4, -2, 1};
        ShellSort.shellSort(arr);
        assertArrayEquals(new int[]{-2, -1, 1, 3, 4}, arr);
    }
}
