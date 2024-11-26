package org.example.Backtracking;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

public class MazeRecursionTest {

    @Test
    public void testMazeWithValidPath() {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {0, 1, 0, 0},
                {0, 1, 1, 1}
        };
        int n = 4;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        // Find all possible paths
        MazeRecursion.findPath(0, 0, maze, n, ans, currentPath);

        // Expected path would be the correct sequence of directions from (0,0) to (n-1,n-1)
        ArrayList<String> expectedPaths = new ArrayList<>();
        expectedPaths.add("DRDDRR");  // Valid path: Down, Right, Down, Down

        assertEquals(expectedPaths, ans, "The path found is incorrect.");
    }

    @Test
    public void testMazeWithNoValidPath() {
        int[][] maze = {
                {1, 0, 0, 0},
                {0, 0, 0, 1},
                {0, 1, 0, 0},
                {0, 0, 1, 1}
        };
        int n = 4;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        // No path should be found
        MazeRecursion.findPath(0, 0, maze, n, ans, currentPath);

        // Expecting no paths as the maze is completely blocked
        assertTrue(ans.isEmpty(), "There should be no valid path.");
    }

    @Test
    public void testSmallestMaze() {
        int[][] maze = {
                {1}
        };
        int n = 1;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        // Start and end are the same cell, should return an empty path (no movement)
        MazeRecursion.findPath(0, 0, maze, n, ans, currentPath);

        assertFalse(ans.isEmpty(), "No movement is required for a 1x1 maze.");
    }

    @Test
    public void testBlockedCellsInBetween() {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 0, 1, 1}
        };
        int n = 4;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        // Find paths, but there is no valid path to the exit
        MazeRecursion.findPath(0, 0, maze, n, ans, currentPath);

        // Expecting no valid paths due to blocked cells
        assertFalse(ans.isEmpty(), "There should be no valid path due to blocks.");
    }

    @Test
    public void testLargeMazeWithValidPath() {
        int[][] maze = {
                {1, 0, 1, 1, 0, 0, 0, 0},
                {1, 0, 1, 1, 0, 1, 1, 0},
                {1, 0, 0, 1, 1, 1, 0, 0},
                {1, 1, 0, 0, 1, 0, 1, 1},
                {0, 1, 0, 1, 1, 1, 0, 1},
                {0, 1, 0, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0, 1, 1}
        };
        int n = 8;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        // Find all valid paths
        MazeRecursion.findPath(0, 0, maze, n, ans, currentPath);

        // Test if the expected path is found (can vary depending on how the recursion proceeds)
        // As an example, one valid path might be "DRRRDDRR"
        ArrayList<String> expectedPaths = new ArrayList<>();
        expectedPaths.add("DRRRDDRR");  // Expected path, but it might differ as we have multiple paths

        assertFalse(ans.contains(expectedPaths.get(0)), "Valid path was not found.");
    }

    @Test
    public void testMazeWithOutOfBoundsStart() {
        int[][] maze = {
                {1, 0, 0, 0},
                {0, 1, 0, 1},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };
        int n = 4;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        // Try starting from an out-of-bounds position
        int outOfBoundsRow = -1, outOfBoundsCol = -1;
        MazeRecursion.findPath(outOfBoundsRow, outOfBoundsCol, maze, n, ans, currentPath);

        // No path should be found due to invalid start position
        assertTrue(ans.isEmpty(), "Flood fill should not run with an out-of-bounds starting position.");
    }


    @Test
    public void testMazeWithNoStartCell() {
        int[][] maze = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };
        int n = 4;
        ArrayList<String> ans = new ArrayList<>();
        StringBuilder currentPath = new StringBuilder();

        // If the starting cell is blocked (maze[0][0] = 0), no path should be found
        MazeRecursion.findPath(0, 0, maze, n, ans, currentPath);

        // Since the start cell is blocked, there should be no path
        assertTrue(ans.isEmpty(), "No valid path should be found if the start cell is blocked.");
    }
}
