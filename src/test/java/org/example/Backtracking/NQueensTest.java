package org.example.Backtracking;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;

public class NQueensTest {

    @Test
    public void testGetNQueensArrangements() {
        int queens = 4;
        List<List<String>> arrangements = NQueens.getNQueensArrangements(queens);

        assertNotNull(arrangements, "The arrangement list should not be null.");
        assertTrue(arrangements.size() > 0, "There should be at least one arrangement.");
        assertEquals(2, arrangements.size(), "For 4 queens, there should be exactly 2 arrangements.");

        // Check if all arrangements are valid
        for (List<String> arrangement : arrangements) {
            assertEquals(queens, arrangement.size(), "Each arrangement should have " + queens + " rows.");
            for (String row : arrangement) {
                assertEquals(queens, row.length(), "Each row should have " + queens + " columns.");
                assertTrue(row.contains("Q"), "Each row should contain exactly one 'Q'.");
            }
        }
    }

    @Test
    public void testNoSolutionForImpossibleQueens() {
        int queens = 2;
        List<List<String>> arrangements = NQueens.getNQueensArrangements(queens);

        assertTrue(arrangements.isEmpty(), "For 2 queens, there should be no possible arrangement.");
    }

    @Test
    public void testGetArrangementsForSingleQueen() {
        int queens = 1;
        List<List<String>> arrangements = NQueens.getArrangementsForQueens(queens);

        assertNotNull(arrangements, "The arrangement list should not be null.");
        assertEquals(1, arrangements.size(), "For 1 queen, there should be exactly 1 arrangement.");

        List<String> arrangement = arrangements.get(0);
        assertEquals(1, arrangement.size(), "There should be 1 row.");
        assertEquals("Q", arrangement.get(0), "The only arrangement should have a single queen.");
    }

    @Test
    public void testGetArrangementsForThreeQueens() {
        int queens = 3;
        List<List<String>> arrangements = NQueens.getNQueensArrangements(queens);

        assertTrue(arrangements.isEmpty(), "For 3 queens, there should be no possible arrangement.");
    }

    @Test
    public void testGetArrangementsForEightQueens() {
        int queens = 8;
        List<List<String>> arrangements = NQueens.getNQueensArrangements(queens);

        assertNotNull(arrangements, "The arrangement list should not be null.");
        assertTrue(arrangements.size() > 0, "There should be at least one arrangement.");
    }
}
