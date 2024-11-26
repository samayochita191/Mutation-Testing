package org.example.Backtracking;

class FloodFill {
    static int M = 8;
    static int N = 8;
    static void floodFillUtil(int screen[][], int x, int y, int prevC, int newC, int M, int N) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return;
        }
        if (screen[x][y] != prevC) {
            return;
        }
        screen[x][y] = newC;
        floodFillUtil(screen, x + 1, y, prevC, newC, M, N);
        floodFillUtil(screen, x - 1, y, prevC, newC, M, N);
        floodFillUtil(screen, x, y + 1, prevC, newC, M, N);
        floodFillUtil(screen, x, y - 1, prevC, newC, M, N);
    }

    static void floodFill(int screen[][], int x, int y, int newC, int M, int N) {
        int prevC = screen[x][y];
        if (prevC == newC) return;
        floodFillUtil(screen, x, y, prevC, newC, M, N);
    }
}