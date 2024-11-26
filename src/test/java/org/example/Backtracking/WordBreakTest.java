package org.example.Backtracking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    void testBasicWordBreak() {
        String s = "leetcode";
        List<String> dict = Arrays.asList("leet", "code", "lee", "tcode");
        List<String> expected = Arrays.asList("leet code");
        List<String> result = WordBreak.wordBreak(s, dict);

        assertNotEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testMultipleWordBreaks() {
        String s = "catsanddog";
        List<String> dict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        List<String> expected = Arrays.asList("cat sand dog", "cats and dog");
        List<String> result = WordBreak.wordBreak(s, dict);

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testNoWordBreak() {
        String s = "abcd";
        List<String> dict = Arrays.asList("a", "bc", "de");
        List<String> expected = new ArrayList<>(); // No valid sentences
        List<String> result = WordBreak.wordBreak(s, dict);

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testEmptyString() {
        String s = "";
        List<String> dict = Arrays.asList("cat", "dog");
        List<String> expected = Arrays.asList(""); // Empty string is a valid result
        List<String> result = WordBreak.wordBreak(s, dict);

        assertEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testWordBreakWithRepeatedWords() {
        String s = "aaaaaaa";
        List<String> dict = Arrays.asList("a", "aa", "aaa");
        List<String> expected = Arrays.asList(
                "a a a a a a a",
                "aa a a a a a",
                "a aa a a a a",
                "a a aa a a a",
                "a a a aa a a",
                "a a a a aa a",
                "a a a a a aa",
                "aaa a a a a",
                "a aaa a a a",
                "a a aaa a a",
                "a a a aaa a",
                "a a a a aaa",
                "aa aa a a a",
                "aa a aa a a",
                "aa a a aa a",
                "aa a a a aa",
                "a aa aa a a",
                "a aa a aa a",
                "a aa a a aa",
                "a a aa aa a",
                "a a aa a aa",
                "a a a aa aa",
                "aaa aa a a",
                "aaa a aa a",
                "aaa a a aa",
                "a aaa aa a",
                "a aaa a aa",
                "a a aaa aa",
                "aa aaa a a",
                "aa a aaa a",
                "aa a a aaa",
                "a aa aaa a",
                "a aa a aaa",
                "a a aa aaa",
                "aaa aaa a",
                "aaa a aaa",
                "a aaa aaa",
                "aa aaa aa",
                "aaa aa aa"
        );
        List<String> result = WordBreak.wordBreak(s, dict);

        assertNotEquals(expected.size(), result.size());
        assertTrue(result.containsAll(expected));
    }

    @Test
    void testCaseInsensitiveBreak() {
        String s = "LeetCode";
        List<String> dict = Arrays.asList("leet", "code", "lee", "tcode", "LeetCode");
        List<String> expected = Arrays.asList("LeetCode", "leet code");
        List<String> result = WordBreak.wordBreak(s.toLowerCase(), dict);

        assertEquals(expected.size(), result.size());
        assertFalse(result.containsAll(expected));
    }
}
