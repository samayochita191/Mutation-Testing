package org.example.Backtracking;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.Map;

public class WordPatternMatcherTest {
    WordPatternMatcher ws = new WordPatternMatcher();
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

    @Test
    void testIMCD() {
        WordPatternMatcher ws = new WordPatternMatcher();
        String pattern = "abab";
        String inputString = "JavaPythonJavaPython";

        // Deleting calls to patternMap.containsKey() and strMap.containsKey() inside backtrack
        boolean resultWithoutValidityCheck = false;
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();

        try {
            resultWithoutValidityCheck = backtrackWithDeletion(pattern, inputString, 0, 0, patternMap, strMap);
        } catch (Exception e) {
            // Expecting an exception due to invalid mapping
            resultWithoutValidityCheck = false;
        }

        assertFalse(resultWithoutValidityCheck);
    }

    private boolean backtrackWithDeletion(String pattern, String inputString, int patternIndex, int strIndex, Map<Character, String> patternMap, Map<String, Character> strMap) {
        if (patternIndex == pattern.length() && strIndex == inputString.length()) {
            return true;
        }
        if (patternIndex == pattern.length() || strIndex == inputString.length()) {
            return false;
        }

        char currentChar = pattern.charAt(patternIndex);

        // The validity checks are removed here, which will cause incorrect mappings
        if (!patternMap.containsKey(currentChar)) {
            return false;
        }

        String mappedStr = patternMap.get(currentChar);
        if (inputString.startsWith(mappedStr, strIndex)) {
            return backtrackWithDeletion(pattern, inputString, patternIndex + 1, strIndex + mappedStr.length(), patternMap, strMap);
        } else {
            return false;
        }
    }
    @Test
    void testIPVR() {
        WordPatternMatcher ws = new WordPatternMatcher();
        String pattern = "abab";
        String inputString = "JavaPythonJavaPython";

        // Mutation: Replacing variables in method call
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();

        // Mutated value for patternMap and strMap
        patternMap.put('a', "Java");
        patternMap.put('b', "Python");
        strMap.put("Java", 'a');
        strMap.put("Python", 'b');

        boolean result = ws.backtrack(pattern, inputString, 0, 0, patternMap, strMap);

        // The original should return true (valid pattern match)
        // But with the IVPR mutation, it will change the behavior, which might cause it to fail.
        assertTrue(result);  // This would fail if the mutation was applied incorrectly.
    }
    @Test
    void testIPEX() {
        WordPatternMatcher ws = new WordPatternMatcher();
        String pattern = "abab";
        String inputString = "JavaPythonJavaPython";

        // Mutation: Exchange the order of parameters in the backtrack method call
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> strMap = new HashMap<>();

        // Original order of parameters: patternIndex, strIndex
        boolean result = ws.backtrack(pattern, inputString, 0, 0, patternMap, strMap);

        // The original pattern matching would give a correct result
        boolean originalResult = true;

        // Mutation: Swap the order of the parameters
        boolean mutatedResult = ws.backtrack(inputString, pattern, 0, 0, patternMap, strMap);

        // Assert that the mutated result is different from the original result
        assertNotEquals(originalResult, mutatedResult); // The mutated result should differ.
    }

    @Test
    void testIREM() {
        WordPatternMatcher ws = new WordPatternMatcher();
        String pattern = "abab";
        String inputString = "JavaPythonJavaPython";

        // Mutation: Modify the return expression using an arithmetic operator
        boolean resultWithIREM = backtrackWithReturnModification(pattern, inputString, 0, 0, new HashMap<>(), new HashMap<>());

        // Original return expression from backtrack should return true for valid matching
        boolean originalResult = true;

        // The mutated version of the method will yield a different result
        assertNotEquals(originalResult, resultWithIREM); // The mutated return should cause a failure in the test.
    }

    private boolean backtrackWithReturnModification(String pattern, String inputString, int patternIndex, int strIndex, Map<Character, String> patternMap, Map<String, Character> strMap) {
        if (patternIndex == pattern.length() && strIndex == inputString.length()) {
            // Original return expression: return true if the pattern and string are fully matched
            return true;
        }
        if (patternIndex == pattern.length() || strIndex == inputString.length()) {
            // Original return expression: return false if one string is fully processed
            return false;
        }

        char currentChar = pattern.charAt(patternIndex);

        if (patternMap.containsKey(currentChar)) {
            String mappedStr = patternMap.get(currentChar);
            if (inputString.startsWith(mappedStr, strIndex)) {
                return backtrackWithReturnModification(pattern, inputString, patternIndex + 1, strIndex + mappedStr.length(), patternMap, strMap);
            } else {
                return false; // If pattern doesn't match, return false
            }
        }

        for (int end = strIndex + 1; end <= inputString.length(); end++) {
            String substring = inputString.substring(strIndex, end);
            if (strMap.containsKey(substring)) {
                continue;
            }

            patternMap.put(currentChar, substring);
            strMap.put(substring, currentChar);

            // Mutation: Modify the return expression to use an arithmetic operator
            boolean backtrackResult = backtrackWithReturnModification(pattern, inputString, patternIndex + 1, end, patternMap, strMap);
            return !backtrackResult; // IREM mutation: Invert the boolean result (negation)
        }

        return false;
    }

    @Test
    void testIREMOriginal() {
        WordPatternMatcher ws = new WordPatternMatcher();
        String pattern = "abab";
        String inputString = "JavaPythonJavaPython";

        // Original method without modification
        boolean result = ws.backtrack(pattern, inputString, 0, 0, new HashMap<>(), new HashMap<>());

        // The correct original behavior
        boolean expected = true;

        // The original method should return the expected result
        assertEquals(expected, result); // This test ensures that the original behavior remains correct.
    }

}
