package Backtracking;

import org.example.Backtracking.KnightsTour;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KnightsTourTest {

    @Test
    public void testKnightsTour() {
        // Reset the board before starting the test
        KnightsTour.resetBoard();

        // Start the Knight's Tour from position (2, 2)
        boolean result = KnightsTour.solve(2, 2, 1);  // First move is at (2, 2), move 1

        // Check if a solution exists
        assertTrue(result, "No solution found for the Knight's Tour.");

        // You can add additional assertions to verify the grid if needed
        // For example, checking if all cells have been visited exactly once
        int visitedCells = 0;
        for (int i = 0; i < KnightsTour.BASE; i++) {
            for (int j = 0; j < KnightsTour.BASE; j++) {
                if (KnightsTour.grid[i][j] > 0) {
                    visitedCells++;
                }
            }
        }

        // Check if all valid cells were visited
        assertEquals((KnightsTour.BASE - 4) * (KnightsTour.BASE - 4), visitedCells, "Not all cells were visited.");
    }

    @Test
    public void testKnightsTourNoSolution() {
        // Reset the board before starting the test
        KnightsTour.resetBoard();

        // Start the Knight's Tour from position (0, 0) with no solution
        // Here you can simulate a scenario where a solution doesn't exist (e.g., out of bounds)
        boolean result = KnightsTour.solve(0, 0, 1);  // Invalid starting position (edge case)

        // Assert that no solution was found
        assertFalse(result, "There should be no solution starting from (0, 0).");
    }
}
