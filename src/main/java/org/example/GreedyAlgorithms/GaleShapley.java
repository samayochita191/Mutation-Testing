package org.example.GreedyAlgorithms;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Implementation of the Gale-Shapley Algorithm for Stable Matching.
 * Problem link: https://en.wikipedia.org/wiki/Stable_marriage_problem
 */
public class GaleShapley {


    /**
     * Function to find stable matches between men and women.
     *
     * @param womenPrefs A map containing women's preferences where each key is a woman and the value is an array of men in order of preference.
     * @param menPrefs   A map containing men's preferences where each key is a man and the value is an array of women in order of preference.
     * @return A map containing stable matches where the key is a woman and the value is her matched man.
     */
    public static Map<String, String> stableMatch(Map<String, LinkedList<String>> womenPrefs, Map<String, LinkedList<String>> menPrefs) {
        Map<String, String> engagements = new HashMap<>();
        LinkedList<String> freeMen = new LinkedList<>(menPrefs.keySet());
        int maxIterations = freeMen.size() * womenPrefs.size(); // Upper bound on iterations

        int iterations = 0;
        while (!freeMen.isEmpty()) {
            if (iterations++ > maxIterations) {
                throw new IllegalStateException("Algorithm failed to terminate. Check input data for cycles.");
            }

            String man = freeMen.poll();
            LinkedList<String> manPref = menPrefs.get(man);

            if (manPref == null || manPref.isEmpty()) {
                continue; // No preferences, skip to next man
            }

            String woman = manPref.poll();
            String fiance = engagements.get(woman);
            LinkedList<String> womanPrefList = womenPrefs.get(woman);

            if (womanPrefList == null) {
                continue; // No preferences for this woman, skip
            }

            if (fiance == null) {
                engagements.put(woman, man);
            } else if (womanPrefList.indexOf(man) < womanPrefList.indexOf(fiance)) {
                engagements.put(woman, man);
                freeMen.add(fiance);
            } else {
                freeMen.add(man);
            }
        }
        return engagements;
    }

}
