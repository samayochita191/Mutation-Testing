package Backtracking;

import org.example.Backtracking.FloodFill;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FloodFillTest {

    @Test
    public void testFloodFill() {
        // Example 2D image
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int newColor = 2;
        int x = 1, y = 1;
        int oldColor = image[x][y];

        // Perform flood fill
        FloodFill.floodFill(image, x, y, newColor, oldColor);

        // Expected image after flood fill
        int[][] expectedImage = {
                {2, 2, 2},
                {2, 2, 0},
                {2, 0, 1}
        };

        // Assert the result
        assertArrayEquals(expectedImage, image, "Flood fill did not work correctly.");
    }

    @Test
    public void testFloodFillNoChange() {
        // Example 2D image
        int[][] image = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };
        int newColor = 1; // New color same as old color
        int x = 1, y = 1;
        int oldColor = image[x][y];

        // Perform flood fill
        FloodFill.floodFill(image, x, y, newColor, oldColor);

        // Expected image should be the same
        int[][] expectedImage = {
                {1, 1, 1},
                {1, 1, 0},
                {1, 0, 1}
        };

        // Assert the result
        assertArrayEquals(expectedImage, image, "Flood fill should not modify the image.");
    }
}
