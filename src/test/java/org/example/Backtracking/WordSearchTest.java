package org.example.Backtracking;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void testWordExists() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCCED";
        assertTrue(wordSearch.exist(board, word), "The word 'ABCCED' should be found.");
    }

    @Test
    void testWordExistsWithBacktracking() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "SEE";
        assertTrue(wordSearch.exist(board, word), "The word 'SEE' should be found.");
    }

    @Test
    void testWordDoesNotExist() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        String word = "ABCB";
        assertFalse(wordSearch.exist(board, word), "The word 'ABCB' should not be found.");
    }
    @Test
    void testSingleCharacterMatch() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A'}
        };
        String word = "A";
        assertTrue(wordSearch.exist(board, word), "The word 'A' should be found in a single character board.");
    }

    @Test
    void testSingleCharacterNoMatch() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A'}
        };
        String word = "B";
        assertFalse(wordSearch.exist(board, word), "The word 'B' should not be found in a single character board.");
    }

    @Test
    void testMultipleWordsBoard() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'C', 'A', 'T'},
                {'D', 'O', 'G'},
                {'B', 'A', 'T'}
        };
        String word = "CAT";
        assertTrue(wordSearch.exist(board, word), "The word 'CAT' should be found.");
    }

    @Test
    void testNoValidPath() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "ABCDEFGH";
        assertFalse(wordSearch.exist(board, word), "The word 'ABCDEFGH' should not be found in this board.");
    }
    @Test
    void testAccessBeyondLowerBoundary() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "BCE";

        // Attempt to access out-of-bounds row (below the last row)
        // It should fail due to boundary check
        assertFalse(wordSearch.exist(board, word), "The word should not be found due to accessing out of bounds below.");
    }

    @Test
    void testWordMatchesOnlyOnEdge() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "BCE";

        // Word matches only on the edge (should be found)
        // Test to make sure boundary checks don't interfere
        assertFalse(wordSearch.exist(board, word), "The word 'BCE' should be found along the edge.");
    }

    @Test
    void testBoundaryAtStartOfBoard() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "ABD";

        // Attempt to start search from the very top-left boundary, ensuring the first cell is visited
        assertFalse(wordSearch.exist(board, word), "The word 'ABD' should be found starting from the top-left corner.");
    }

    @Test
    void testBoundaryAtEndOfBoard() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "FHI";

        // Word is at the bottom-right corner, testing boundary condition for last cells
        assertFalse(wordSearch.exist(board, word), "The word 'FHI' should be found from the bottom-right corner.");
    }

    @Test
    void testWordExceedsBoardSize() {
        WordSearch wordSearch = new WordSearch();
        char[][] board = {
                {'A', 'B'},
                {'C', 'D'}
        };
        String word = "ABCD"; // Word exceeds the size of the board

        // Attempt to find a word longer than the board's size
        assertFalse(wordSearch.exist(board, word), "The word 'ABCD' should not be found as it exceeds the board's size.");
    }

    @Test
    public void testWordFoundInSmallBoard() {
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "ABE";
        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.exist(board, word)); // word "ABE" exists in the board
    }

    @Test
    public void testWordNotFoundInSmallBoard() {
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "XYZ";
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word)); // word "XYZ" does not exist in the board
    }

    @Test
    public void testSingleCharacterWord() {
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "E";
        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.exist(board, word)); // Single character word should be found
    }

    @Test
    public void testWordExistsInLargeBoard() {
        char[][] board = new char[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                board[i][j] = 'A'; // Fill the board with 'A'
            }
        }
        board[5][5] = 'B'; // Place 'B' at a specific position
        String word = "AAAAAB";
        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.exist(board, word)); // Check for long word in large board
    }

    @Test
    public void testWordCannotBeFoundDueToObstacles() {
        char[][] board = {
                {'A', 'B', 'C', 'D'},
                {'E', 'F', 'G', 'H'},
                {'I', 'J', 'K', 'L'}
        };
        String word = "BEHL";
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word)); // Word should fail due to blocking obstacles
    }

    @Test
    public void testEmptyBoard() {
        char[][] board = {};
        String word = "A";
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word)); // Empty board, word cannot exist
    }

    @Test
    public void testSingleRowBoard() {
        char[][] board = {
                {'A', 'B', 'C', 'D'}
        };
        String word = "BCD";
        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.exist(board, word)); // Single row, word exists in sequence
    }

    @Test
    public void testSingleColumnBoard() {
        char[][] board = {
                {'A'},
                {'B'},
                {'C'},
                {'D'}
        };
        String word = "BC";
        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.exist(board, word)); // Single column, word exists vertically
    }

    @Test
    public void testWordSpansAcrossMultipleDirections() {
        char[][] board = {
                {'A', 'B', 'C', 'D'},
                {'E', 'F', 'G', 'H'},
                {'I', 'J', 'K', 'L'}
        };
        String word = "BFH";
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word)); // Word spans across different directions (diagonal or horizontal)
    }

    @Test
    public void testWordWithNoValidPath() {
        char[][] board = {
                {'A', 'B', 'C', 'D'},
                {'E', 'F', 'G', 'H'},
                {'I', 'J', 'K', 'L'}
        };
        String word = "ABCJ";
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word)); // No valid path for "ABCJ"
    }

    @Test
    public void testWordMatchingAtTheEdge() {
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "CIF";
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word)); // Word exists at the edge (starting from C to I)
    }
    @Test
    public void testSingleLetterBoardWithMatchingWord() {
        char[][] board = {
                {'A'}
        };
        String word = "A";
        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.exist(board, word)); // Single letter word should match a single letter board
    }
    @Test
    public void testLargeWordNotFound() {
        char[][] board = {
                {'A', 'B', 'C', 'D'},
                {'E', 'F', 'G', 'H'},
                {'I', 'J', 'K', 'L'}
        };
        String word = "ABCDEFGHIJKL"; // Larger word than board size
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word)); // Larger word cannot fit
    }

    @Test
    public void testWordFoundAfterBacktracking() {
        char[][] board = {
                {'A', 'B', 'C'},
                {'D', 'E', 'F'},
                {'G', 'H', 'I'}
        };
        String word = "ABE";
        WordSearch wordSearch = new WordSearch();
        assertTrue(wordSearch.exist(board, word)); // The word requires backtracking
    }

    @Test
    public void testWordDoesNotExistWhenBoardIsSmall() {
        char[][] board = {
                {'A'}
        };
        String word = "AB";
        WordSearch wordSearch = new WordSearch();
        assertFalse(wordSearch.exist(board, word)); // Word does not exist in a single letter board
    }
}