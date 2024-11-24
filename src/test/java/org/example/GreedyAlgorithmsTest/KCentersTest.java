package org.example.GreedyAlgorithmsTest;
import org.example.GreedyAlgorithms.KCenters;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class KCentersTest {

    /**
     * Test Case 1: Basic functionality with a small distance matrix.
     * This test checks the correctness of the algorithm for small inputs.
     * Mutation Operators Targeted:
     * - Replace conditional boundary (`<` replaced with `<=`)
     * - Negate conditionals (`!selected[i]` negated)
     * - Change mathematical operations (e.g., `Math.min` altered)
     */
    @Test
    void testBasicFunctionality() {
        int[][] distances = {
                {0, 4, 8, 5},
                {4, 0, 10, 7},
                {8, 10, 0, 9},
                {5, 7, 9, 0}
        };
        int k = 2;
        int result = KCenters.findKCenters(distances, k);
        assertEquals(8, result);
    }

    /**
     * Test Case 2: All points are equidistant.
     * This test ensures that the algorithm handles edge cases where distances are uniform.
     * Mutation Operators Targeted:
     * - Change comparison (`> replaced with >=`)
     * - Remove calls to `Math.min`
     */
    @Test
    void testUniformDistances() {
        int[][] distances = {
                {0, 1, 1, 1},
                {1, 0, 1, 1},
                {1, 1, 0, 1},
                {1, 1, 1, 0}
        };
        int k = 3;
        int result = KCenters.findKCenters(distances, k);
        assertEquals(1, result); // Expected result: 1
    }


    /**
     * Test Case 4: Large matrix with varying distances.
     * Integration-level mutation: Ensure logic scales and centers are correctly chosen.
     * Mutation Operators Targeted:
     * - Remove loop iterations
     * - Change result computation logic
     */
    @Test
    void testLargeMatrix() {
        int[][] distances = {
                {0, 5, 10, 20},
                {5, 0, 15, 25},
                {10, 15, 0, 30},
                {20, 25, 30, 0}
        };
        assertEquals(20, KCenters.findKCenters(distances, 2));
    }


    /**
     * Test Case 5: All distances are zero.
     * Ensures that the algorithm handles a degenerate case with all zero distances.
     * Integration-level mutation: Handle invalid distance computations.
     */
    @Test
    void testAllZeroDistances() {
        int[][] distances = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        int k = 2;
        int result = KCenters.findKCenters(distances, k);
        assertEquals(0, result); // Expected result: 0
    }
    /**
     * Test Case 6: Test with points having different distances and multiple centers.
     * This test ensures that the program behaves correctly when selecting multiple centers.
     */
    @Test
    void testMultipleCenters() {
        int[][] distances = {
                {0, 3, 6, 9},
                {3, 0, 3, 6},
                {6, 3, 0, 3},
                {9, 6, 3, 0}
        };
        int k = 2; // Testing with multiple centers
        int result = KCenters.findKCenters(distances, k);
        assertEquals(9, result); // Expected result: 9 (the farthest distance to a center)
    }
    /**
     * Test Case 7: Verify that the algorithm does not select already selected centers.
     * This test specifically targets the negated conditional mutation.
     */
    @Test
    void testNoReselectAlreadySelectedCenters() {
        int[][] distances = {
                {0, 4, 8, 5},
                {4, 0, 10, 7},
                {8, 10, 0, 9},
                {5, 7, 9, 0}
        };
        int k = 2; // We should not select already selected centers
        int result = KCenters.findKCenters(distances, k);
        assertEquals(8, result); // Expected result: 8 (The farthest center should not be reselected)
    }
    /**
     * Test Case 8: Test case where the farthest distance is equal between two points.
     * This test ensures that changing the conditional boundary does not produce wrong results.
     */
    @Test
    void testEqualDistances() {
        int[][] distances = {
                {0, 5, 5},
                {5, 0, 5},
                {5, 5, 0}
        };
        int k = 2; // The farthest nodes (equal distance) should still be selected correctly
        int result = KCenters.findKCenters(distances, k);
        assertEquals(5, result); // Expected result: 5 (since two points are equally far)
    }


    /**
     * Test Case 9: Test when selecting the center with the highest distance.
     * This test is designed to ensure that boundary changes (<=) do not allow wrong selections.
     */
    @Test
    void testMaxDistanceSelection() {
        int[][] distances = {
                {0, 10, 15},
                {10, 0, 20},
                {15, 20, 0}
        };
        int k = 2;
        int result = KCenters.findKCenters(distances, k);
        assertEquals(15, result); // Expected result: 15 (The farthest point should be selected first)
    }

    @Test
    void testMultipleCentersNoReselection() {
        int[][] distances = {
                {0, 5, 8, 7},
                {5, 0, 6, 4},
                {8, 6, 0, 3},
                {7, 4, 3, 0}
        };
        int k = 3; // Three centers should be selected
        int result = KCenters.findKCenters(distances, k);
        assertEquals(5, result); // The maximum distance to a center should be 5
    }
    @Test
    void testBoundaryChangeEffect() {
        int[][] distances = {
                {0, 10, 10, 20},   // The distances are such that the first center has a distance of 10 from the others
                {10, 0, 15, 25},
                {10, 15, 0, 30},
                {20, 25, 30, 0}
        };
        int k = 2; // Selecting 2 centers

        // This test will specifically target the changed conditional boundary mutation.
        // If the condition is changed from '>' to '>=' in the selection logic, it might result in a different selection.
        int result = KCenters.findKCenters(distances, k);

        // In this case, we expect the result to be 20, because the center selected with the farthest distance should
        // be selected. If the boundary condition is changed incorrectly, the result might vary.
        assertEquals(20, result);
    }
}
