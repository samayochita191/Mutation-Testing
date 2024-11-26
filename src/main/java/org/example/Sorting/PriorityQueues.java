package org.example.Sorting;

import java.util.Arrays;

public class PriorityQueues {

	public static int[] heapMax(int[] arr, int key) {
		int n = 0;
		while (n < arr.length && arr[n] != 0) {
			n++; // Count the number of non-zero elements (the actual heap size)
		}
		if (n == arr.length) {
			arr = Arrays.copyOf(arr, arr.length * 2);  // Double the size when full
		}
		return insertQueue(arr, key, n);
	}

	public static int[] insertQueue(int[] arr, int key, int n) {
		arr[n] = key;  // Add the new key at the end of the heap
		int i = n;
		while (i > 0 && arr[i] > arr[(i - 1) / 2]) {
			swap(arr, i, (i - 1) / 2);
			i = (i - 1) / 2;
		}
		return arr;
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
}
