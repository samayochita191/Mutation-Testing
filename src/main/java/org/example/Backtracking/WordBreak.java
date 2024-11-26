package org.example.Backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordBreak {

    static void wordBreakHelper(String s, HashSet<String> dictSet,
                                String curr, List<String> res,
                                int start) {
        if (start == s.length()) {
            res.add(curr);
            return;
        }
        for (int end = start + 1; end <= s.length(); ++end) {
            String word = s.substring(start, end);
            if (dictSet.contains(word)) {
                String prev = curr;
                if (!curr.isEmpty()) {
                    curr += " ";
                }
                curr += word;
                wordBreakHelper(s, dictSet, curr, res, end);
                curr = prev;
            }
        }
    }

    static List<String> wordBreak(String s, List<String> dict) {
        HashSet<String> dictSet = new HashSet<>(dict);
        List<String> res = new ArrayList<>();
        String curr = "";
        wordBreakHelper(s, dictSet, curr, res, 0);
        return res;
    }
}
