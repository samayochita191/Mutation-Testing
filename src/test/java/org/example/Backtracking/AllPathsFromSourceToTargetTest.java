package org.example.Backtracking;

import org.junit.jupiter.api.Test;

import static org.example.Backtracking.AllPathsFromSourceToTarget.allPathsFromSourceToTarget;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class AllPathsFromSourceToTargetTest {

    @Test
    public void testAllPathsFromSourceToTarget() {
        // Test case 1: Simple graph with one path
        int[][] graph1 = {
                {0, 1},
                {0, 2},
                {1, 3},
                {2, 3}
        };
        int vertices1 = 4;
        int source1 = 0;
        int destination1 = 3;

        List<List<Integer>> result1 = allPathsFromSourceToTarget(vertices1, graph1, source1, destination1);
        // Expected paths: [[0, 1, 3], [0, 2, 3]]
        assertEquals(2, result1.size());
        assertTrue(result1.contains(List.of(0, 1, 3)));
        assertTrue(result1.contains(List.of(0, 2, 3)));

        // Test case 2: Simple graph with no path
        int[][] graph2 = {
                {0, 1},
                {1, 2}
        };
        int vertices2 = 3;
        int source2 = 0;
        int destination2 = 3;

        List<List<Integer>> result2 = allPathsFromSourceToTarget(vertices2, graph2, source2, destination2);
        // No path exists from 0 to 3
        assertTrue(result2.isEmpty());

        // Test case 3: Graph with a single node and no edges
        int[][] graph3 = {};
        int vertices3 = 1;
        int source3 = 0;
        int destination3 = 0;

        List<List<Integer>> result3 = allPathsFromSourceToTarget(vertices3, graph3, source3, destination3);
        // Path from 0 to 0 is just [0]
        assertEquals(1, result3.size());
        assertTrue(result3.contains(List.of(0)));
    }
}
