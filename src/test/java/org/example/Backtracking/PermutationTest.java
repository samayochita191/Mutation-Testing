package Backtracking;

import org.example.Backtracking.Permutation;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class PermutationTest {

    @Test
    public void testPermutationWithIntegerArray() {
        Integer[] arr = {1, 2, 3};
        List<Integer[]> result = Permutation.permutation(arr);

        assertNotNull(result, "Result should not be null");
        assertEquals(6, result.size(), "There should be 6 permutations for the array {1, 2, 3}");

        // Check if all permutations are present
        assertTrue(result.contains(new Integer[] {1, 2, 3}));
        assertTrue(result.contains(new Integer[] {1, 3, 2}));
        assertTrue(result.contains(new Integer[] {2, 1, 3}));
        assertTrue(result.contains(new Integer[] {2, 3, 1}));
        assertTrue(result.contains(new Integer[] {3, 1, 2}));
        assertTrue(result.contains(new Integer[] {3, 2, 1}));
    }

    @Test
    public void testPermutationWithStringArray() {
        String[] arr = {"a", "b", "c"};
        List<String[]> result = Permutation.permutation(arr);

        assertNotNull(result, "Result should not be null");
        assertEquals(6, result.size(), "There should be 6 permutations for the array {a, b, c}");

        // Check if all permutations are present
        assertTrue(result.contains(new String[] {"a", "b", "c"}));
        assertTrue(result.contains(new String[] {"a", "c", "b"}));
        assertTrue(result.contains(new String[] {"b", "a", "c"}));
        assertTrue(result.contains(new String[] {"b", "c", "a"}));
        assertTrue(result.contains(new String[] {"c", "a", "b"}));
        assertTrue(result.contains(new String[] {"c", "b", "a"}));
    }

    @Test
    public void testPermutationWithEmptyArray() {
        Integer[] arr = {};
        List<Integer[]> result = Permutation.permutation(arr);

        assertNotNull(result, "Result should not be null");
        assertEquals(1, result.size(), "There should be 1 permutation for an empty array");
        assertTrue(result.contains(new Integer[] {}), "The result should contain an empty array");
    }

    @Test
    public void testPermutationWithSingleElementArray() {
        Integer[] arr = {1};
        List<Integer[]> result = Permutation.permutation(arr);

        assertNotNull(result, "Result should not be null");
        assertEquals(1, result.size(), "There should be 1 permutation for a single element array");
        assertTrue(result.contains(new Integer[] {1}), "The result should contain the array {1}");
    }
}
