package org.example.Sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HeapSortTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        new HeapSort().sort(arr);
        assertArrayEquals(new int[]{}, arr, "An empty array should remain empty after sorting.");
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {42};
        new HeapSort().sort(arr);
        assertArrayEquals(new int[]{42}, arr, "A single-element array should remain unchanged after sorting.");
    }

    @Test
    void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        new HeapSort().sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "An already sorted array should remain unchanged.");
    }

    @Test
    void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        new HeapSort().sort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "A reverse-sorted array should be correctly sorted.");
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5};
        int[] expected = {1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9};
        new HeapSort().sort(arr);
        assertArrayEquals(expected, arr, "The array with duplicate elements should be sorted correctly.");
    }

    @Test
    void testArrayWithNegativeNumbers() {
        int[] arr = {-3, -1, -4, -1, -5, -9, -2, -6, -5, -3, -5};
        int[] expected = {-9, -6, -5, -5, -5, -4, -3, -3, -2, -1, -1};
        new HeapSort().sort(arr);
        assertArrayEquals(expected, arr, "The array with negative numbers should be sorted correctly.");
    }

    @Test
    void testMixedPositiveAndNegativeNumbers() {
        int[] arr = {3, -1, 4, 1, -5, 9, -2, 6, 0};
        int[] expected = {-5, -2, -1, 0, 1, 3, 4, 6, 9};
        new HeapSort().sort(arr);
        assertArrayEquals(expected, arr, "The array with mixed positive and negative numbers should be sorted correctly.");
    }

    @Test
    void testArrayWithZero() {
        int[] arr = {0, 0, 0, 0, 0};
        int[] expected = {0, 0, 0, 0, 0};
        new HeapSort().sort(arr);
        assertArrayEquals(expected, arr, "An array of zeros should remain unchanged.");
    }

    @Test
    void testLargeArray() {
        int size = 1000;
        int[] arr = new int[size];
        int[] expected = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i;
            expected[i] = i + 1;
        }
        new HeapSort().sort(arr);
        assertArrayEquals(expected, arr, "A large array should be sorted correctly.");
    }

    @Test
    void testArrayWithMaxAndMinIntegers() {
        int[] arr = {Integer.MAX_VALUE, Integer.MIN_VALUE, 0, -1, 1};
        int[] expected = {Integer.MIN_VALUE, -1, 0, 1, Integer.MAX_VALUE};
        new HeapSort().sort(arr);
        assertArrayEquals(expected, arr, "The array with Integer.MIN_VALUE and Integer.MAX_VALUE should be sorted correctly.");
    }
}
