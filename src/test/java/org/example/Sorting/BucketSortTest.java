package org.example.Sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

public class BucketSortTest {

    @Test
    public void testBucketSortBasic() {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.37f};
        BucketSort.bucketSort(arr);

        // After sorting, the array should be in increasing order
        assertArrayEquals(new float[]{0.23f, 0.32f, 0.37f, 0.42f, 0.52f}, arr);
    }

    @Test
    public void testBucketSortAlreadySorted() {
        float[] arr = {0.1f, 0.2f, 0.3f, 0.4f, 0.5f};
        BucketSort.bucketSort(arr);

        // The array should remain the same as it's already sorted
        assertArrayEquals(new float[]{0.1f, 0.2f, 0.3f, 0.4f, 0.5f}, arr);
    }

    @Test
    public void testBucketSortReversedOrder() {
        float[] arr = {0.9f, 0.8f, 0.7f, 0.6f, 0.5f};
        BucketSort.bucketSort(arr);

        // After sorting, the array should be in increasing order
        assertArrayEquals(new float[]{0.5f, 0.6f, 0.7f, 0.8f, 0.9f}, arr);
    }

    @Test
    public void testBucketSortWithDuplicates() {
        float[] arr = {0.42f, 0.42f, 0.23f, 0.42f, 0.23f};
        BucketSort.bucketSort(arr);

        // After sorting, the array should handle duplicates correctly
        assertArrayEquals(new float[]{0.23f, 0.23f, 0.42f, 0.42f, 0.42f}, arr);
    }

    @Test
    public void testBucketSortSingleElement() {
        float[] arr = {0.1f};
        BucketSort.bucketSort(arr);

        // A single element array should remain unchanged
        assertArrayEquals(new float[]{0.1f}, arr);
    }

    @Test
    public void testBucketSortEmptyArray() {
        float[] arr = {};
        BucketSort.bucketSort(arr);

        // An empty array should remain empty
        assertArrayEquals(new float[]{}, arr);
    }

    @Test
    public void testBucketSortLargeArray() {
        float[] arr = new float[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = (float) Math.random();
        }
        BucketSort.bucketSort(arr);

        // After sorting, the array should be in increasing order
        assertTrue(isSorted(arr));
    }

    @Test
    public void testBucketSortWithLargeNumbers() {
        float[] arr = {0.85f, 0.95f, 0.75f, 0.68f, 0.92f};
        BucketSort.bucketSort(arr);

        // After sorting, the array should be in increasing order
        assertArrayEquals(new float[]{0.68f, 0.75f, 0.85f, 0.92f, 0.95f}, arr);
    }

    @Test
    public void testBucketSortWithSmallNumbers() {
        float[] arr = {0.001f, 0.0001f, 0.0009f, 0.0007f, 0.0002f};
        BucketSort.bucketSort(arr);

        // After sorting, the array should be in increasing order
        assertArrayEquals(new float[]{0.0001f, 0.0002f, 0.0007f, 0.0009f, 0.001f}, arr);
    }

    private boolean isSorted(float[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
