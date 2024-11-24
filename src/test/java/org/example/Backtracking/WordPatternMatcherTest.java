package org.example.Backtracking;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class WordPatternMatcherTest {

    @Test
    public void testPatternWithEmptyStringMapping() {
        String pattern = "abc";
        String inputString = "JavaPythonJava";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // abc -> Java, Python, Java
    }

    @Test
    public void testNoPatternMatch() {
        String pattern = "abab";
        String inputString = "abcd";
        assertFalse(WordPatternMatcher.matchWordPattern(pattern, inputString));  // No valid mapping for ab
    }

    @Test
    public void testSingleCharacterPatternWithMultipleOccurrences() {
        String pattern = "aaaa";
        String inputString = "PythonPythonPythonPython";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // Each a can map to "Python"
    }

    @Test
    public void testPatternLongerThanInputString() {
        String pattern = "abcd";
        String inputString = "abc";
        assertFalse(WordPatternMatcher.matchWordPattern(pattern, inputString));  // Pattern cannot be longer than input
    }

    @Test
    public void testMatchingSameWordMultipleTimes() {
        String pattern = "aabb";
        String inputString = "JavaJavaPythonPython";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // a -> Java, b -> Python
    }

    @Test
    public void testStringContainsPatternsNotInSequence() {
        String pattern = "abab";
        String inputString = "PythonJavaPythonJava";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // ab -> Python, Java
    }

    @Test
    public void testPatternWithLeadingCharacters() {
        String pattern = "abc";
        String inputString = "PythonJavaPython";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // a -> Python, b -> Java, c -> Python
    }

    @Test
    public void testPatternWithExactSubstringMatch() {
        String pattern = "aab";
        String inputString = "aaabb";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // a -> aa, b -> b
    }

    @Test
    public void testPatternContainingSingleCharacter() {
        String pattern = "a";
        String inputString = "Java";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // a -> Java
    }

    @Test
    public void testPatternThatShouldMatchWithMultipleSubstrings() {
        String pattern = "abc";
        String inputString = "PythonJavaPython";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // a -> Python, b -> Java, c -> Python
    }

    @Test
    public void testPatternWithDifferentLengths() {
        String pattern = "ab";
        String inputString = "JavaPythonJava";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // ab -> Java, Python
    }

    @Test
    public void testEdgeCaseSingleCharacterPattern() {
        String pattern = "a";
        String inputString = "x";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // a -> x
    }

    @Test
    public void testPatternWithMultiplePossibleMappings() {
        String pattern = "aba";
        String inputString = "xyzxyzxyz";
        assertFalse(WordPatternMatcher.matchWordPattern(pattern, inputString));
    }

    @Test
    public void testLargePattern() {
        String pattern = "abababababab";
        String inputString = "JavaPythonJavaPythonJavaPythonJavaPython";
        assertFalse(WordPatternMatcher.matchWordPattern(pattern, inputString));  // ab -> Java, Python
    }

    @Test
    public void testNoValidMappingForPattern() {
        String pattern = "aabb";
        String inputString = "PythonJava";
        assertFalse(WordPatternMatcher.matchWordPattern(pattern, inputString));  // No valid mapping as input is too short
    }

    @Test
    public void testSingleCharacterRepeatedInPattern() {
        String pattern = "a";
        String inputString = "Java";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // a -> Java
    }

    @Test
    public void testEmptyPatternWithEmptyString() {
        String pattern = "";
        String inputString = "";
        assertTrue(WordPatternMatcher.matchWordPattern(pattern, inputString));  // empty pattern matches empty string
    }

    @Test
    public void testEmptyPatternWithNonEmptyString() {
        String pattern = "";
        String inputString = "Java";
        assertFalse(WordPatternMatcher.matchWordPattern(pattern, inputString));  // empty pattern cannot match non-empty string
    }

    @Test
    public void testNonEmptyPatternWithEmptyString() {
        String pattern = "a";
        String inputString = "";
        assertFalse(WordPatternMatcher.matchWordPattern(pattern, inputString));  // non-empty pattern cannot match empty string
    }

    @Test
    public void testMultipleDifferentPatterns() {
        String pattern = "aaabbb";
        String inputString = "catdogcatdogcatdog";
        assertFalse(WordPatternMatcher.matchWordPattern(pattern, inputString));
    }
}
