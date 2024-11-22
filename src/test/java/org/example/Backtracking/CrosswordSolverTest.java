package Backtracking;

import org.example.Backtracking.CrosswordSolver;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CrosswordSolverTest {

    @Test
    public void testIsValidHorizontal() {
        char[][] puzzle = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        String word = "cat";
        boolean isValid = CrosswordSolver.isValid(puzzle, word, 0, 0, false);
        assertTrue(isValid);

        // Place a word and check again
        CrosswordSolver.placeWord(puzzle, word, 0, 0, false);
        isValid = CrosswordSolver.isValid(puzzle, word, 1, 0, false); // This should be false as the row is occupied
        assertFalse(isValid);
    }

    @Test
    public void testIsValidVertical() {
        char[][] puzzle = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        String word = "cat";
        boolean isValid = CrosswordSolver.isValid(puzzle, word, 0, 0, true);
        assertTrue(isValid);

        // Place a word and check again
        CrosswordSolver.placeWord(puzzle, word, 0, 0, true);
        isValid = CrosswordSolver.isValid(puzzle, word, 0, 1, true); // This should be false as the column is occupied
        assertFalse(isValid);
    }

    @Test
    public void testSolveCrossword() {
        char[][] puzzle = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        List<String> words = Arrays.asList("cat", "dog");

        boolean solved = CrosswordSolver.solveCrossword(puzzle, words);

        assertTrue(solved);

        // Check if words were placed correctly
        assertArrayEquals(new char[]{'c', 'a', 't'}, puzzle[0]);
        assertArrayEquals(new char[]{' ', ' ', ' '}, puzzle[1]);
        assertArrayEquals(new char[]{'d', 'o', 'g'}, puzzle[2]);
    }

    @Test
    public void testSolveCrosswordWithNoSolution() {
        char[][] puzzle = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        List<String> words = Arrays.asList("cat", "dog", "fish");

        boolean solved = CrosswordSolver.solveCrossword(puzzle, words);

        assertFalse(solved);
    }

    @Test
    public void testRemoveWord() {
        char[][] puzzle = {
                {' ', ' ', ' '},
                {' ', ' ', ' '},
                {' ', ' ', ' '}
        };
        String word = "cat";

        // Place the word
        CrosswordSolver.placeWord(puzzle, word, 0, 0, false);
        assertArrayEquals(new char[]{'c', 'a', 't'}, puzzle[0]);

        // Remove the word
        CrosswordSolver.removeWord(puzzle, word, 0, 0, false);
        assertArrayEquals(new char[]{' ', ' ', ' '}, puzzle[0]);
    }
}
