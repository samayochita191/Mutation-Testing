package org.example.Backtracking;

import java.util.Arrays;

public class MColoring {

    public static boolean isSafe(int v, boolean[][] graph, int[] color, int c) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[v][i] && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    public static boolean graphColoring(boolean[][] graph, int m, int[] color, int v) {
        if (v == graph.length) {
            return true;
        }
        for (int c = 1; c <= m; c++) {
            if (isSafe(v, graph, color, c)) {
                color[v] = c; // Assign color c to vertex v
                if (graphColoring(graph, m, color, v + 1)) {
                    return true;
                }
                color[v] = 0;
            }
        }
        return false;
    }

    public static boolean solveMColoring(boolean[][] graph, int m) {
        int[] color = new int[graph.length];
        Arrays.fill(color, 0);
        return graphColoring(graph, m, color, 0);
    }
}
