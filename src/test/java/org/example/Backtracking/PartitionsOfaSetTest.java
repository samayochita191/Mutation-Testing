package org.example.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PartitionsOfaSetTest {

    @Test
    void testEmptyArray() {
        int[] arr = {};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertFalse(partition.isKPartitionPossible(arr, 2));  // Can't partition empty array into 2 subsets
    }

    @Test
    void testSingleElementArray() {
        int[] arr = {5};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 1));  // One subset with one element is always possible
        assertFalse(partition.isKPartitionPossible(arr, 2));  // Can't partition one element into 2 subsets
    }

    @Test
    void testArrayWithEqualSumPartition() {
        int[] arr = {1, 5, 11, 5};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 2));  // Can partition into 2 subsets with equal sum
    }

    @Test
    void testArrayWithUnequalSumPartition() {
        int[] arr = {1, 5, 3};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertFalse(partition.isKPartitionPossible(arr, 2));  // Can't partition into 2 subsets with equal sum
    }

    @Test
    void testArrayWithOddSum() {
        int[] arr = {1, 2, 3, 4};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 2));  // Sum is 10, can't divide into 2 equal subsets
    }

    @Test
    void testArrayWithMultiplePartitions() {
        int[] arr = {4, 5, 2, 3, 9, 10};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertFalse(partition.isKPartitionPossible(arr, 3));  // Can partition into 3 subsets with equal sum
    }

    @Test
    void testArrayWithOnePartition() {
        int[] arr = {1, 1, 1, 1};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 1));  // One partition with any number of elements
    }

    @Test
    void testArrayWithMorePartitionsThanElements() {
        int[] arr = {5, 10, 15};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertFalse(partition.isKPartitionPossible(arr, 4));  // More partitions than elements
    }

    @Test
    void testArrayWithEvenNumberOfPartitions() {
        int[] arr = {6, 6, 6, 6};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 2));  // Can partition into 2 subsets with equal sum
    }

    @Test
    void testArrayWithOddNumberOfPartitions() {
        int[] arr = {1, 2, 3, 4, 5, 6};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 3));  // Can partition into 3 subsets with equal sum
    }

    @Test
    void testLargeArray() {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;  // Array with values from 1 to 50
        }
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 5));  // Can partition into 5 subsets with equal sum
    }

    @Test
    void testArrayWithDuplicates() {
        int[] arr = {10, 10, 10, 10, 10, 10};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 3));  // Can partition into 3 subsets with equal sum
    }

    @Test
    void testArrayWithPrimeNumbers() {
        int[] arr = {2, 3, 5, 7, 11};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        assertTrue(partition.isKPartitionPossible(arr, 2));  // Cannot partition into 2 subsets with equal sum
    }

    @Test
    void testLargePartitionWithInfeasibleTarget() {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        // Although sum is 55, it's impossible to partition it into 4 subsets of equal sum
        assertFalse(partition.isKPartitionPossible(arr, 4));
    }

    @Test
    void testMinimumPartitionWithFeasibleTarget() {
        int[] arr = {1, 1, 1, 1};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        // Can partition into 2 subsets of sum 2
        assertTrue(partition.isKPartitionPossible(arr, 2));
    }

    @Test
    void testArrayWithRandomSubsetFeasibility() {
        int[] arr = {6, 3, 7, 5, 5, 3};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        // This array can be partitioned into 2 subsets of equal sum
        assertFalse(partition.isKPartitionPossible(arr, 2));
    }

    @Test
    void testArrayWithNoPossiblePartition() {
        int[] arr = {1, 3, 9};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        // This array cannot be partitioned into 2 subsets of equal sum
        assertFalse(partition.isKPartitionPossible(arr, 2));
    }

    @Test
    void testBacktrackingFeasibility() {
        int[] arr = {2, 4, 5, 7, 10};
        PartitionsOfaSet partition = new PartitionsOfaSet();
        // Test for backtracking on partitioning logic
        assertFalse(partition.isKPartitionPossible(arr, 3));
    }
}
