package Sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.example.Sorting.CountingSort;
import org.junit.jupiter.api.Test;

class CountingSortTest {

    @Test
    void testCountSortIntegers() {
        int[] input = {1, 2, 1, 4, 2, 5, 7, 2};
        int[] expected = {1, 1, 2, 2, 2, 4, 5, 7};

        CountingSort.countSort(input);

        assertArrayEquals(expected, input, "The integer array should be sorted in ascending order");
    }

    @Test
    void testCountSortCharacters() {
        char[] input = {'g', 'e', 'e', 'k', 's', 'f', 'o', 'r', 'g', 'e', 'e', 'k', 's'};
        char[] expected = {'e', 'e', 'e', 'e', 'f', 'g', 'g', 'k', 'k', 'o', 'r', 's', 's'};

        CountingSort.countSort(input);

        assertArrayEquals(expected, input, "The character array should be sorted in ascending order");
    }
}

