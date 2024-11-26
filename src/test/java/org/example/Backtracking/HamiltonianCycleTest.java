package org.example.Backtracking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HamiltonianCycleTest {

    @Test
    void testSimpleHamiltonianCycle() {
        HamiltonianCycle hc = new HamiltonianCycle(5);

        int[][] graph = {
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
        };

        int[] result = hc.hamCycle(graph);
        assertNotNull(result, "A Hamiltonian cycle should exist.");
        assertTrue(isValidHamiltonianCycle(graph, result), "The result should form a valid Hamiltonian cycle.");
    }

//    @Test
//    void testNoHamiltonianCycle() {
//        HamiltonianCycle hc = new HamiltonianCycle(5);
//
//        int[][] graph = {
//                {0, 1, 1, 0, 0},
//                {1, 0, 1, 1, 0},
//                {1, 1, 0, 0, 1},
//                {0, 1, 0, 0, 1},
//                {0, 0, 1, 1, 0},
//        };
//
//        int[] result = hc.hamCycle(graph);
//        assertNull(result, "No Hamiltonian cycle should exist.");
//    }

    @Test
    void testDisconnectedGraph() {
        HamiltonianCycle hc = new HamiltonianCycle(5);

        int[][] graph = {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };

        int[] result = hc.hamCycle(graph);
        assertNull(result, "No Hamiltonian cycle should exist in a disconnected graph.");
    }

    @Test
    void testCompleteGraph() {
        HamiltonianCycle hc = new HamiltonianCycle(5);

        int[][] graph = {
                {0, 1, 1, 1, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 0, 1, 1},
                {1, 1, 1, 0, 1},
                {1, 1, 1, 1, 0},
        };

        int[] result = hc.hamCycle(graph);
        assertNotNull(result, "A complete graph should have a Hamiltonian cycle.");
        assertTrue(isValidHamiltonianCycle(graph, result), "The result should form a valid Hamiltonian cycle.");
    }

    /**
     * Helper method to validate whether a path is a Hamiltonian cycle.
     */
    private boolean isValidHamiltonianCycle(int[][] graph, int[] path) {
        int n = path.length;

        // Check if the path visits each vertex exactly once.
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (visited[path[i]]) {
                return false;
            }
            visited[path[i]] = true;
        }

        // Check if the path forms a cycle (i.e., connects back to the start).
        return graph[path[n - 1]][path[0]] == 1;
    }
}
