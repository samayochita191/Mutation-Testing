package org.example.Backtracking;

import java.util.Arrays;

public class MColoring {

    // Function to check if it's safe to assign color to vertex
    public static boolean isSafe(int v, boolean[][] graph, int[] color, int c) {
        for (int i = 0; i < graph.length; i++) {
            // If adjacent vertex has the same color, return false
            if (graph[v][i] && color[i] == c) {
                return false;
            }
        }
        return true;
    }

    // Backtracking function to solve m-coloring problem
    public static boolean graphColoring(boolean[][] graph, int m, int[] color, int v) {
        // If all vertices are assigned a color then return true
        if (v == graph.length) {
            return true;
        }

        // Try different colors for vertex v
        for (int c = 1; c <= m; c++) {
            // Check if it's safe to color vertex v with color c
            if (isSafe(v, graph, color, c)) {
                color[v] = c; // Assign color c to vertex v

                // Recursively assign colors to the next vertices
                if (graphColoring(graph, m, color, v + 1)) {
                    return true;
                }

                // If assigning color c doesn't lead to a solution, backtrack
                color[v] = 0;
            }
        }

        // If no color can be assigned to this vertex then return false
        return false;
    }

    // Function to solve the m-coloring problem
    public static boolean solveMColoring(boolean[][] graph, int m) {
        int[] color = new int[graph.length];
        Arrays.fill(color, 0);

        // Start solving the problem from vertex 0
        return graphColoring(graph, m, color, 0);
    }

    public static void main(String[] args) {
        // Example graph
        boolean[][] graph = {
                {false, true, true, false},
                {true, false, true, true},
                {true, true, false, true},
                {false, true, true, false}
        };
        int m = 3;  // Number of colors

        if (solveMColoring(graph, m)) {
            System.out.println("Solution exists");
        } else {
            System.out.println("No solution exists");
        }
    }
}
