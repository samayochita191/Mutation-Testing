package org.example.Sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CountingSortTest {

    @Test
    public void testCountSortIntegers() {
        // Test sorting a regular array
        int[] arr = {1, 2, 1, 4, 2, 5, 7, 2};
        int[] expected = {1, 1, 2, 2, 2, 4, 5, 7};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "The integer array should be sorted correctly.");
    }

    @Test
    public void testCountSortIntegersEmptyArray() {
        // Test sorting an empty array
        int[] arr = {};
        int[] expected = {};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "An empty integer array should remain empty.");
    }

    @Test
    public void testCountSortIntegersSingleElement() {
        // Test sorting an array with a single element
        int[] arr = {5};
        int[] expected = {5};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "A single-element integer array should remain unchanged.");
    }

    @Test
    public void testCountSortCharacters() {
        // Test sorting a regular character array
        char[] arr = {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};
        char[] expected = {'e', 'e', 'e', 'e', 'f', 'g', 'g', 'k', 'k', 'o', 'r', 's', 's'};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "The character array should be sorted correctly.");
    }

    @Test
    public void testCountSortCharactersEmptyArray() {
        // Test sorting an empty character array
        char[] arr = {};
        char[] expected = {};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "An empty character array should remain empty.");
    }

    @Test
    public void testCountSortCharactersSingleElement() {
        // Test sorting a character array with a single element
        char[] arr = {'z'};
        char[] expected = {'z'};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "A single-element character array should remain unchanged.");
    }

    @Test
    public void testCountSortIntegersWithDuplicates() {
        // Test sorting an integer array with all elements being the same
        int[] arr = {3, 3, 3, 3};
        int[] expected = {3, 3, 3, 3};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "An integer array with duplicates should remain correctly sorted.");
    }

    @Test
    public void testCountSortCharactersWithDuplicates() {
        // Test sorting a character array with all elements being the same
        char[] arr = {'a', 'a', 'a', 'a'};
        char[] expected = {'a', 'a', 'a', 'a'};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "A character array with duplicates should remain correctly sorted.");
    }

    @Test
    public void testCountSortIntegersBoundaryValues() {
        // Test sorting integers near the boundary of the counting range
        int[] arr = {0, 9, 9, 0, 5};
        int[] expected = {0, 0, 5, 9, 9};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "An integer array with boundary values should be sorted correctly.");
    }

    @Test
    public void testCountSortCharactersBoundaryValues() {
        // Test sorting characters near the ASCII boundary
        char[] arr = {'\0', 'z', 'a', '\127'};
        char[] expected = {'\0', '\127', 'a', 'z'};

        CountingSort.countSort(arr);

        assertArrayEquals(expected, arr, "A character array with ASCII boundary values should be sorted correctly.");
    }
}
