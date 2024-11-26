package org.example.Backtracking;

import java.util.ArrayList;

public class MazeRecursion {

    static String direction = "DLRU";
    static int[] dr = {1, 0, 0, -1};
    static int[] dc = {0, -1, 1, 0};

    static boolean isValid(int row, int col, int n, int[][] maze) {
        return row >= 0 && col >= 0 && row < n && col < n && maze[row][col] == 1;
    }

    static void findPath(int row, int col, int[][] maze, int n, ArrayList<String> ans, StringBuilder currentPath) {
        if (!isValid(row, col, n, maze)) {
            return; // Return immediately if the start position is invalid
        }
        if (row == n - 1 && col == n - 1) {
            ans.add(currentPath.toString());
            return;
        }
        maze[row][col] = 0;

        for (int i = 0; i < 4; i++) {
            int nextRow = row + dr[i];
            int nextCol = col + dc[i];
            if (isValid(nextRow, nextCol, n, maze)) {
                currentPath.append(direction.charAt(i));
                findPath(nextRow, nextCol, maze, n, ans, currentPath);
                currentPath.deleteCharAt(currentPath.length() - 1);
            }
        }
        maze[row][col] = 1;
    }

}