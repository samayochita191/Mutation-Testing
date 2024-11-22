package Backtracking;

import org.example.Backtracking.NQueens;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class NQueensTest {

    @Test
    public void testGetNQueensArrangements() {
        int queens = 4;
        List<List<String>> arrangements = NQueens.getNQueensArrangements(queens);

        assertNotNull(arrangements, "Arrangements should not be null.");
        assertFalse(arrangements.isEmpty(), "There should be at least one arrangement.");

        // Check if the arrangements are valid (no queens should threaten each other)
        for (List<String> arrangement : arrangements) {
            assertEquals(queens, arrangement.size(), "Each arrangement should have exactly " + queens + " rows.");
            for (String row : arrangement) {
                assertEquals(queens, row.length(), "Each row should have exactly " + queens + " columns.");
            }
        }
    }

    @Test
    public void testPlaceQueens() {
        // Testing with 4 queens
        NQueens.placeQueens(4);

    }

    @Test
    public void testNoSolutionForZeroQueens() {
        // There is no valid solution for 0 queens
        NQueens.placeQueens(0);
    }

    @Test
    public void testLargeNumberOfQueens() {
        int queens = 8;
        List<List<String>> arrangements = NQueens.getNQueensArrangements(queens);

        assertNotNull(arrangements, "Arrangements should not be null.");
        assertFalse(arrangements.isEmpty(), "There should be at least one arrangement.");

        // Validate the format of the output
        for (List<String> arrangement : arrangements) {
            assertEquals(queens, arrangement.size(), "Each arrangement should have exactly " + queens + " rows.");
            for (String row : arrangement) {
                assertEquals(queens, row.length(), "Each row should have exactly " + queens + " columns.");
            }
        }
    }

    @Test
    public void testNoSolutionForOneQueen() {
        // There's only one solution for 1 queen
        NQueens.placeQueens(1);
    }
}
