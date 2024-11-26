package org.example.Backtracking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MColoringTest {

    @Test
    public void testMColoringSolutionExists() {
        boolean[][] graph = {
                {false, true, true, false},
                {true, false, true, true},
                {true, true, false, true},
                {false, true, true, false}
        };
        int m = 3;  // Number of colors

        boolean result = MColoring.solveMColoring(graph, m);

        assertTrue(result, "Solution should exist for the given graph and m-coloring.");
    }

    @Test
    public void testMColoringNoSolution() {
        boolean[][] graph = {
                {false, true, true, false},
                {true, false, true, true},
                {true, true, false, true},
                {false, true, true, true}
        };
        int m = 2;  // Number of colors (this graph cannot be 2-colored)

        boolean result = MColoring.solveMColoring(graph, m);

        assertFalse(result, "Solution should not exist for the given graph and m-coloring.");
    }

    @Test
    public void testMColoringSingleColorGraph() {
        boolean[][] graph = {
                {false, false, false},
                {false, false, false},
                {false, false, false}
        };
        int m = 1;  // Only one color available

        boolean result = MColoring.solveMColoring(graph, m);

        assertTrue(result, "Solution should exist with a single color on an isolated graph.");
    }

    @Test
    public void testMColoringEdgeCase() {
        boolean[][] graph = {
                {false}
        };
        int m = 1;  // Only one vertex, only one color needed

        boolean result = MColoring.solveMColoring(graph, m);

        assertTrue(result, "Solution should exist for a graph with a single vertex and one color.");
    }

    @Test
    public void testMColoringNoSolutionDueToGraphStructure() {
        boolean[][] graph = {
                {false, true, true, true},
                {true, false, true, true},
                {true, true, false, true},
                {true, true, true, false}
        };
        int m = 2;  // Number of colors

        boolean result = MColoring.solveMColoring(graph, m);

        assertFalse(result, "Solution should not exist for this graph with 2 colors due to the structure.");
    }
}
