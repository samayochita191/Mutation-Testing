package Backtracking;

import org.example.Backtracking.MazeRecursion;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MazeRecursionTest {

    @Test
    public void testSolveMazeUsingFirstStrategy() {
        int[][] map = {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        int[][] result = MazeRecursion.solveMazeUsingFirstStrategy(map);

        assertNotNull(result, "Maze solution should not be null.");

        // Check if the path from (1,1) to (6,5) is marked with '2'
        assertEquals(2, result[1][1], "Start position should be marked as part of the solution.");
        assertEquals(2, result[6][5], "End position should be marked as part of the solution.");

        // Additional validation could check for dead ends marked as '3'
    }

    @Test
    public void testSolveMazeUsingSecondStrategy() {
        int[][] map = {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1}
        };

        int[][] result = MazeRecursion.solveMazeUsingSecondStrategy(map);

        assertNotNull(result, "Maze solution should not be null.");

        // Check if the path from (1,1) to (6,5) is marked with '2'
        assertEquals(2, result[1][1], "Start position should be marked as part of the solution.");
        assertEquals(2, result[6][5], "End position should be marked as part of the solution.");

        // Additional validation could check for dead ends marked as '3'
    }

    @Test
    public void testNoSolution() {
        // A maze that has no possible path to the target
        int[][] map = {
                {1, 1, 1, 1, 1, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };

        // Test the first strategy where no solution exists
        int[][] result = MazeRecursion.solveMazeUsingFirstStrategy(map);

        assertNull(result, "Maze should not have a solution.");

        // Test the second strategy where no solution exists
        result = MazeRecursion.solveMazeUsingSecondStrategy(map);

        assertNull(result, "Maze should not have a solution.");
    }
}
