package org.example.Sorting;

public class CountingSort {
	public static int MAX = 256;

	public static void countSort(int[] arr) {
		int[] count = new int[10];
		int[] sortedArr = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i < 10; i++) {
			count[i] += count[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			sortedArr[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		System.arraycopy(sortedArr, 0, arr, 0, arr.length);
	}

	public static void countSort(char[] arr) {
		int[] count = new int[256];
		char[] sortedArr = new char[arr.length];
		for (int i = 0; i < arr.length; i++) {
			count[arr[i]]++;
		}
		for (int i = 1; i < 256; i++) {
			count[i] += count[i - 1];
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			sortedArr[count[arr[i]] - 1] = arr[i];
			count[arr[i]]--;
		}
		System.arraycopy(sortedArr, 0, arr, 0, arr.length);
	}
}
