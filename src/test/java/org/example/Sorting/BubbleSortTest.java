package Sorting;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.example.Sorting.BubbleSort;
import org.junit.jupiter.api.Test;

class BubbleSortTest {

    @Test
    void testBubbleSort() {
        int[] input = {5, 3, 8, 4, 2};
        int[] expected = {2, 3, 4, 5, 8};

        BubbleSort.bubbleSort(input, input.length);

        assertArrayEquals(expected, input, "The array should be sorted in ascending order");
    }

    @Test
    void testBubbleSortDif() {
        int[] input = {5, 3, 8, 4, 2};
        int[] expected = {2, 3, 4, 5, 8};

        BubbleSort.bubbleSortDif(input, input.length);

        assertArrayEquals(expected, input, "The array should be sorted in ascending order");
    }
}

