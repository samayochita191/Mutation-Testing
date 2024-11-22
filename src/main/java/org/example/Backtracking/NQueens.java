package org.example.Backtracking;

import java.util.ArrayList;
import java.util.List;


public final class NQueens {
    private NQueens() {
    }

    public static List<List<String>> getNQueensArrangements(int queens) {
        List<List<String>> arrangements = new ArrayList<>();
        getSolution(queens, arrangements, new int[queens], 0);
        return arrangements;
    }

    public static void placeQueens(final int queens) {
        List<List<String>> arrangements = new ArrayList<List<String>>();
        getSolution(queens, arrangements, new int[queens], 0);
        if (arrangements.isEmpty()) {
            System.out.println("There is no way to place " + queens + " queens on board of size " + queens + "x" + queens);
        } else {
            System.out.println("Arrangement for placing " + queens + " queens");
        }
        for (List<String> arrangement : arrangements) {
            arrangement.forEach(System.out::println);
            System.out.println();
        }
    }

    /**
     * This is backtracking function which tries to place queen recursively
     *
     * @param boardSize: size of chess board
     * @param solutions: this holds all possible arrangements
     * @param columns: columns[i] = rowId where queen is placed in ith column.
     * @param columnIndex: This is the column in which queen is being placed
     */
    private static void getSolution(int boardSize, List<List<String>> solutions, int[] columns, int columnIndex) {
        if (columnIndex == boardSize) {
            // this means that all queens have been placed
            List<String> sol = new ArrayList<String>();
            for (int i = 0; i < boardSize; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < boardSize; j++) {
                    sb.append(j == columns[i] ? "Q" : ".");
                }
                sol.add(sb.toString());
            }
            solutions.add(sol);
            return;
        }

        // This loop tries to place queen in a row one by one
        for (int rowIndex = 0; rowIndex < boardSize; rowIndex++) {
            columns[columnIndex] = rowIndex;
            if (isPlacedCorrectly(columns, rowIndex, columnIndex)) {
                // If queen is placed successfully at rowIndex in column=columnIndex then try
                // placing queen in next column
                getSolution(boardSize, solutions, columns, columnIndex + 1);
            }
        }
    }

    /**
     * This function checks if queen can be placed at row = rowIndex in column =
     * columnIndex safely
     *
     * @param columns: columns[i] = rowId where queen is placed in ith column.
     * @param rowIndex: row in which queen has to be placed
     * @param columnIndex: column in which queen is being placed
     * @return true: if queen can be placed safely false: otherwise
     */
    private static boolean isPlacedCorrectly(int[] columns, int rowIndex, int columnIndex) {
        for (int i = 0; i < columnIndex; i++) {
            int diff = Math.abs(columns[i] - rowIndex);
            if (diff == 0 || columnIndex - i == diff) {
                return false;
            }
        }
        return true;
    }
}
