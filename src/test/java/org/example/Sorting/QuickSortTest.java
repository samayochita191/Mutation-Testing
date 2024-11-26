package org.example.Sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuickSortTest {

    @Test
    public void testAlreadySortedArray() {
        int[] arr = {1, 2, 3, 4, 5};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "Already sorted array should remain unchanged.");
    }

    @Test
    public void testReverseSortedArray() {
        int[] arr = {5, 4, 3, 2, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, arr, "Reverse sorted array should be sorted correctly.");
    }

    @Test
    public void testSingleElementArray() {
        int[] arr = {42};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{42}, arr, "Single-element array should remain unchanged.");
    }

    @Test
    public void testEmptyArray() {
        int[] arr = {};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{}, arr, "Empty array should remain unchanged.");
    }

    @Test
    public void testArrayWithDuplicates() {
        int[] arr = {3, 5, 3, 3, 9, 5, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 3, 3, 3, 5, 5, 9}, arr, "Array with duplicates should be sorted correctly.");
    }

    @Test
    public void testArrayWithNegativeAndPositiveNumbers() {
        int[] arr = {-5, 3, -2, 9, -1, 0};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{-5, -2, -1, 0, 3, 9}, arr, "Array with both negative and positive numbers should be sorted correctly.");
    }

    @Test
    public void testArrayWithSameElements() {
        int[] arr = {7, 7, 7, 7, 7};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{7, 7, 7, 7, 7}, arr, "Array with all identical elements should remain unchanged.");
    }

    @Test
    public void testPivotAsLargestElement() {
        int[] arr = {6, 1, 5, 7};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 5, 6, 7}, arr, "Array where pivot is the largest element should be sorted correctly.");
    }

    @Test
    public void testPivotAsSmallestElement() {
        int[] arr = {5, 6, 7, 1};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{1, 5, 6, 7}, arr, "Array where pivot is the smallest element should be sorted correctly.");
    }

    @Test
    public void testLargeArray() {
        int[] arr = {100, 99, 98, 3, 2, 1, 0, 200, 300, 150, 50};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 0, arr.length - 1);
        assertArrayEquals(new int[]{0, 1, 2, 3, 50, 98, 99, 100, 150, 200, 300}, arr, "Large array should be sorted correctly.");
    }

    @Test
    public void testSubarraySorting() {
        int[] arr = {5, 3, 8, 6, 2, 7};
        QuickSort sorter = new QuickSort();
        sorter.sort(arr, 1, 4); // Sort only a portion of the array
        assertArrayEquals(new int[]{5, 2, 3, 6, 8, 7}, arr, "Subarray sorting should correctly sort the specified range.");
    }

    @Test
    public void testPartitionWithMultipleSmallerElements() {
        int[] arr = {4, 2, 3, 1, 5}; // Pivot = 5
        QuickSort sorter = new QuickSort();
        int partitionIndex = sorter.partition(arr, 0, arr.length - 1);
        assertEquals(4, partitionIndex, "Partition index should be at the last position for this input.");
        assertArrayEquals(new int[]{4, 2, 3, 1, 5}, arr, "Array should be partitioned with all elements smaller than pivot to its left.");
    }

//    @Test
//    public void testPartitionWithIncrementLogic() {
//        int[] arr = {10, 7, 8, 9, 1, 5}; // Pivot = 5
//        QuickSort sorter = new QuickSort();
//        int partitionIndex = sorter.partition(arr, 0, arr.length - 1);
//        assertEquals(1, partitionIndex, "Partition index should point to the correct position of the pivot.");
//        assertArrayEquals(new int[]{1, 5, 8, 9, 7, 10}, arr, "Array should be partitioned correctly around the pivot.");
//    }


    @Test
    public void testPartitionWithSwaps() {
        int[] arr = {3, 5, 8, 6, 2, 7}; // Pivot = 7
        QuickSort sorter = new QuickSort();
        int partitionIndex = sorter.partition(arr, 0, arr.length - 1);
        assertEquals(4, partitionIndex, "Partition index should point to the position where pivot is placed.");
        assertArrayEquals(new int[]{3, 5, 6, 2, 7, 8}, arr, "Array should be partitioned correctly with elements rearranged around the pivot.");
    }





}
