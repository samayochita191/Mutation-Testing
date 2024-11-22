package Backtracking;

import org.example.Backtracking.MColoring;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MColoringTest {

    @Test
    public void testMColoringSolution() {
        // Example graph
        boolean[][] graph = {
                {false, true, true, false},
                {true, false, true, true},
                {true, true, false, true},
                {false, true, true, false}
        };

        int m = 3;  // Number of colors

        // Solve the m-coloring problem
        boolean result = MColoring.solveMColoring(graph, m);

        // Assert the result
        assertTrue(result, "Solution exists for the given graph and number of colors.");
    }

    @Test
    public void testMColoringNoSolution() {
        // Example graph
        boolean[][] graph = {
                {false, true, true, false},
                {true, false, true, true},
                {true, true, false, true},
                {false, true, true, false}
        };

        int m = 2;  // Not enough colors to solve this graph

        // Solve the m-coloring problem
        boolean result = MColoring.solveMColoring(graph, m);

        // Assert the result
        assertFalse(result, "No solution exists for the given graph and number of colors.");
    }
}
