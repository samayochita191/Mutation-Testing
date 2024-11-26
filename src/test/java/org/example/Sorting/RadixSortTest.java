package org.example.Sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class RadixSortTest {

    @Test
    public void testSortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "Sorting an already sorted array should return the same array.");
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "Sorting a reverse sorted array should correctly sort it.");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {42};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{42}, arr, "Sorting an array with one element should return the same array.");
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{}, arr, "Sorting an empty array should return an empty array.");
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {3, 3, 3, 3, 3};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{3, 3, 3, 3, 3}, arr, "Sorting an array with all duplicates should return the same array.");
    }

    @Test
    public void testArrayWithNegativeNumbers() {
        int[] arr = {-5, -10, 0, 5, 10};
        // Radix sort does not handle negative numbers. This is to check behavior.
        assertThrows(Exception.class, () -> RadixSort.radixSort(arr), "Radix sort does not support negative numbers.");
    }

    @Test
    public void testArrayWithZeros() {
        int[] arr = {0, 0, 0, 0};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{0, 0, 0, 0}, arr, "Sorting an array of zeros should return the same array.");
    }

    @Test
    public void testLargeArray() {
        int[] arr = {999, 500, 100, 200, 300, 400, 800, 700, 600, 0};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{0, 100, 200, 300, 400, 500, 600, 700, 800, 999}, arr, "Sorting a large array should correctly sort all elements.");
    }

    @Test
    public void testArrayWithMixedDigits() {
        int[] arr = {12, 121, 123, 1, 10, 100, 101};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{1, 10, 12, 100, 101, 121, 123}, arr, "Sorting an array with mixed digits should correctly sort it.");
    }

    @Test
    public void testArrayWithLargeNumbers() {
        int[] arr = {100000, 200000, 300000, 10000, 500000, 400000};
        RadixSort.radixSort(arr);
        assertArrayEquals(new int[]{10000, 100000, 200000, 300000, 400000, 500000}, arr, "Sorting an array with large numbers should handle all elements correctly.");
    }
}
