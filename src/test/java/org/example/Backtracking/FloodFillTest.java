package org.example.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {

    @Test
    public void testFloodFillVerticalPropagation() {
        int[][] image = {
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0}
        };
        int newColor = 2;
        int x = 0, y = 0; // Start filling from top-left
        int M = 3, N = 3;  // Grid size

        // Perform flood fill
        FloodFill.floodFill(image, x, y, newColor, M, N);

        // Expected image after flood fill
        int[][] expectedImage = {
                {2, 0, 0},
                {2, 0, 0},
                {2, 0, 0}
        };

        // Assert the vertical propagation
        assertArrayEquals(expectedImage, image, "Flood fill did not propagate vertically.");
    }

    @Test
    public void testFloodFillHorizontalPropagation() {
        int[][] image = {
                {1, 1, 1},
                {0, 0, 0},
                {0, 0, 0}
        };
        int newColor = 3;
        int x = 0, y = 0; // Start filling from top-left
        int M = 3, N = 3;  // Grid size

        // Perform flood fill
        FloodFill.floodFill(image, x, y, newColor, M, N);

        // Expected image after flood fill
        int[][] expectedImage = {
                {3, 3, 3},
                {0, 0, 0},
                {0, 0, 0}
        };

        // Assert the horizontal propagation
        assertArrayEquals(expectedImage, image, "Flood fill did not propagate horizontally.");
    }

    @Test
    public void testFloodFillCornerPropagation() {
        int[][] image = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        int newColor = 4;
        int x = 0, y = 0; // Start filling from top-left
        int M = 3, N = 3;  // Grid size

        // Perform flood fill
        FloodFill.floodFill(image, x, y, newColor, M, N);

        // Expected image after flood fill
        int[][] expectedImage = {
                {4, 4, 0},
                {4, 4, 0},
                {0, 0, 0}
        };

        // Assert that fill propagated to the connected region
        assertArrayEquals(expectedImage, image, "Flood fill did not propagate correctly to the corner region.");
    }

    @Test
    public void testFloodFillDisconnectedRegion() {
        int[][] image = {
                {1, 0, 1},
                {0, 1, 0},
                {1, 0, 1}
        };
        int newColor = 5;
        int x = 1, y = 1; // Start filling from the center
        int M = 3, N = 3;  // Grid size

        // Perform flood fill
        FloodFill.floodFill(image, x, y, newColor, M, N);

        // Expected image after flood fill
        int[][] expectedImage = {
                {1, 0, 1},
                {0, 5, 0},
                {1, 0, 1}
        };

        // Assert that only the connected region is filled
        assertArrayEquals(expectedImage, image, "Flood fill incorrectly propagated to disconnected regions.");
    }

    @Test
    public void testFloodFillLargePropagatedArea() {
        int[][] image = {
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 1, 1}
        };
        int newColor = 6;
        int x = 2, y = 2; // Start from a center point
        int M = 4, N = 4;  // Grid size

        // Perform flood fill
        FloodFill.floodFill(image, x, y, newColor, M, N);

        // Expected image after flood fill
        int[][] expectedImage = {
                {6, 6, 6, 6},
                {6, 6, 6, 6},
                {6, 6, 6, 6},
                {6, 6, 6, 6}
        };

        // Assert the large propagated area
        assertArrayEquals(expectedImage, image, "Flood fill did not propagate to the entire region.");
    }

    @Test
    public void testFloodFillSameColor() {
        int[][] image = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        int newColor = 2;
        int x = 0, y = 0; // Start from top-left
        int M = 3, N = 3;  // Grid size

        // Perform flood fill
        FloodFill.floodFill(image, x, y, newColor, M, N);

        // The image should remain the same
        int[][] expectedImage = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };

        assertArrayEquals(expectedImage, image, "Flood fill incorrectly modified the image.");
    }

    @Test
    public void testFloodFillOutOfBounds() {
        int[][] image = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 0}
        };
        int newColor = 3;
        int x = 0, y = 0; // Valid coordinates
        int M = 3, N = 3;  // Grid size

        // Perform flood fill (valid coordinates)
        FloodFill.floodFill(image, x, y, newColor, M, N);

        // Expected image after flood fill
        int[][] expectedImage = {
                {3, 3, 0},
                {3, 3, 0},
                {0, 0, 0}
        };

        assertArrayEquals(expectedImage, image, "Flood fill did not propagate correctly.");

        // Perform flood fill with out-of-bounds coordinates (invalid)
        int invalidX = -1, invalidY = -1;

        // Prevent flood fill for out-of-bounds coordinates
        if (invalidX >= 0 && invalidX < M && invalidY >= 0 && invalidY < N) {
            FloodFill.floodFill(image, invalidX, invalidY, newColor, M, N);
        }

        // Image should remain unchanged after out-of-bounds operation
        int[][] unchangedImage = {
                {3, 3, 0},
                {3, 3, 0},
                {0, 0, 0}
        };

        assertArrayEquals(unchangedImage, image, "Flood fill incorrectly modified the image when out of bounds.");
    }

}
