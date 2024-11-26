package org.example.Backtracking;

public class HamiltonianCycle {
    private final int V; // Number of vertices

    public HamiltonianCycle(int vertices) {
        this.V = vertices;
    }

    private boolean isSafe(int v, int[][] graph, int[] path, int pos) {
        if (graph[path[pos - 1]][v] == 0) {
            return false;
        }
        for (int i = 0; i < pos; i++) {
            if (path[i] == v) {
                return false;
            }
        }
        return true;
    }

    private boolean hamCycleUtil(int[][] graph, int[] path, int pos) {
        if (pos == V) {
            return graph[path[pos - 1]][path[0]] == 1;
        }
        for (int v = 1; v < V; v++) {
            if (isSafe(v, graph, path, pos)) {
                path[pos] = v;
                if (hamCycleUtil(graph, path, pos + 1)) {
                    return true;
                }
                path[pos] = -1;
            }
        }
        return false;
    }

    public int[] hamCycle(int[][] graph) {
        int[] path = new int[V];
        for (int i = 0; i < V; i++) {
            path[i] = -1;
        }
        path[0] = 0;
        if (!hamCycleUtil(graph, path, 1)) {
            return null; // Return null if no Hamiltonian cycle exists.
        }
        return path;
    }
}
