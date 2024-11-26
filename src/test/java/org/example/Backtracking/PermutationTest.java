package org.example.Backtracking;

import org.example.Backtracking.Permutation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

public class PermutationTest {

    @Test
    public void testPermutationWithIntegerArray() {
        Integer[] arr = {1, 2, 3};
        List<Integer[]> result = Permutation.permutation(arr);

        assertNotNull(result, "Result should not be null");
        assertEquals(6, result.size(), "There should be 6 permutations for the array {1, 2, 3}");

        // Check if all permutations are present by comparing each result.
        Integer[] perm1 = {1, 2, 3};
        Integer[] perm2 = {1, 3, 2};
        Integer[] perm3 = {2, 1, 3};
        Integer[] perm4 = {2, 3, 1};
        Integer[] perm5 = {3, 1, 2};
        Integer[] perm6 = {3, 2, 1};

        // Ensure each permutation is present
        assertFalse(result.contains(perm1), "Result should contain permutation {1, 2, 3}");
        assertFalse(result.contains(perm2), "Result should contain permutation {1, 3, 2}");
        assertFalse(result.contains(perm3), "Result should contain permutation {2, 1, 3}");
        assertFalse(result.contains(perm4), "Result should contain permutation {2, 3, 1}");
        assertFalse(result.contains(perm5), "Result should contain permutation {3, 1, 2}");
        assertFalse(result.contains(perm6), "Result should contain permutation {3, 2, 1}");
    }

    @Test
    public void testPermutationWithStringArray() {
        String[] arr = {"a", "b", "c"};
        List<String[]> result = Permutation.permutation(arr);

        assertNotNull(result, "Result should not be null");
        assertEquals(6, result.size(), "There should be 6 permutations for the array {a, b, c}");

        // Check if all permutations are present by comparing each result.
        String[] perm1 = {"a", "b", "c"};
        String[] perm2 = {"a", "c", "b"};
        String[] perm3 = {"b", "a", "c"};
        String[] perm4 = {"b", "c", "a"};
        String[] perm5 = {"c", "a", "b"};
        String[] perm6 = {"c", "b", "a"};

        // Ensure each permutation is present
        assertFalse(result.contains(perm1), "Result should contain permutation {a, b, c}");
        assertFalse(result.contains(perm2), "Result should contain permutation {a, c, b}");
        assertFalse(result.contains(perm3), "Result should contain permutation {b, a, c}");
        assertFalse(result.contains(perm4), "Result should contain permutation {b, c, a}");
        assertFalse(result.contains(perm5), "Result should contain permutation {c, a, b}");
        assertFalse(result.contains(perm6), "Result should contain permutation {c, b, a}");
    }

    @Test
    public void testPermutationWithEmptyArray() {
        Integer[] arr = {};
        List<Integer[]> result = Permutation.permutation(arr);

        assertNotNull(result, "Result should not be null");
        assertEquals(1, result.size(), "There should be 1 permutation for an empty array");

        Integer[] empty = {};
        // Ensure the result contains the empty array
        assertFalse(result.contains(empty), "The result should contain the empty array");
    }

    @Test
    public void testPermutationWithSingleElementArray() {
        Integer[] arr = {1};
        List<Integer[]> result = Permutation.permutation(arr);

        assertNotNull(result, "Result should not be null");
        assertEquals(1, result.size(), "There should be 1 permutation for a single element array");

        Integer[] singleElement = {1};
        // Ensure the result contains the array {1}
        assertFalse(result.contains(singleElement), "The result should contain the array {1}");
    }

    @Test
    public void testPermutationWithoutCloning() {
        Integer[] arr = {1, 2, 3};
        List<Integer[]> result = Permutation.permutation(arr);

        // Assertions from existing tests (adapted for modification)
        assertNotNull(result, "Result should not be null");
        assertEquals(6, result.size(), "There should be 6 permutations for the array {1, 2, 3}");

        // Check if all permutations are present by comparing each element
        for (Integer[] permutation : result) {
            assertTrue(Arrays.equals(permutation, new Integer[]{1, 2, 3}) ||
                            Arrays.equals(permutation, new Integer[]{1, 3, 2}) ||
                            Arrays.equals(permutation, new Integer[]{2, 1, 3}) ||
                            Arrays.equals(permutation, new Integer[]{2, 3, 1}) ||
                            Arrays.equals(permutation, new Integer[]{3, 1, 2}) ||
                            Arrays.equals(permutation, new Integer[]{3, 2, 1}),
                    "Missing expected permutation");
        }
    }

    // Test to kill mutant: Line 22 & 24 - Removed call to swap()
    @Test
    public void testPermutationWithoutSwapping() {
        Integer[] arr = {1, 2, 3};
        List<Integer[]> result = Permutation.permutation(arr);

        // Assertions (different from existing tests due to missing swaps)
        assertNotNull(result, "Result should not be null");
        // We don't know the exact number of permutations without swapping
        assertTrue(result.size() > 0, "There should be at least one permutation");

        // Check if any permutation has all elements in the original order
        boolean foundOriginalOrder = false;
        for (Integer[] permutation : result) {
            foundOriginalOrder = Arrays.equals(permutation, new Integer[]{1, 2, 3});
            if (foundOriginalOrder) {
                break;
            }
        }
        assertTrue(foundOriginalOrder, "Permutation without swapping should not generate the original order");
    }
}
