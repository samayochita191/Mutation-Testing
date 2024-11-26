package org.example.Sorting;

public class InsertionSort {

	public static void insertionSort(int[] a, int n) {
		for (int i = 1; i <= n - 1; i++) {
			int x = a[i];
			int j = i;
			while (j > 0 && a[j - 1] > x) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = x;
		}
	}

	public static void invertInsertion(int[] a, int n) {
		for (int i = 1; i <= n - 1; i++) {
			int x = a[i];
			int j = i;
			while (j > 0 && a[j - 1] < x) {
				a[j] = a[j - 1];
				j--;
			}
			a[j] = x;
		}
	}
}
