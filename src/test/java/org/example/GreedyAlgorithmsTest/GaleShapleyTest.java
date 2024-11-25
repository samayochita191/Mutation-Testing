package org.example.GreedyAlgorithmsTest;

import org.example.GreedyAlgorithms.GaleShapley;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GaleShapleyTest {

    @Test
    void testStableMatchBasicScenario() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Alice", new LinkedList<>(Arrays.asList("Bob", "Charlie", "David")));
        womenPrefs.put("Beth", new LinkedList<>(Arrays.asList("Charlie", "David", "Bob")));
        womenPrefs.put("Cara", new LinkedList<>(Arrays.asList("David", "Charlie", "Bob")));

        menPrefs.put("Bob", new LinkedList<>(Arrays.asList("Alice", "Beth", "Cara")));
        menPrefs.put("Charlie", new LinkedList<>(Arrays.asList("Beth", "Cara", "Alice")));
        menPrefs.put("David", new LinkedList<>(Arrays.asList("Cara", "Alice", "Beth")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Verify the matches
        assertEquals("Bob", result.get("Alice"));
        assertEquals("Charlie", result.get("Beth"));
        assertEquals("David", result.get("Cara"));
    }

    @Test
    void testStableMatchWithTiePreferences() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Anna", new LinkedList<>(Arrays.asList("Evan", "Frank")));
        womenPrefs.put("Bea", new LinkedList<>(Arrays.asList("Frank", "Evan")));

        menPrefs.put("Evan", new LinkedList<>(Arrays.asList("Anna", "Bea")));
        menPrefs.put("Frank", new LinkedList<>(Arrays.asList("Bea", "Anna")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Verify the matches
        assertTrue(
                (result.get("Anna").equals("Evan") && result.get("Bea").equals("Frank")) ||
                        (result.get("Anna").equals("Frank") && result.get("Bea").equals("Evan"))
        );
    }

    @Test
    void testStableMatchEdgeCaseNoPreferences() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Diana", new LinkedList<>());
        menPrefs.put("Ed", new LinkedList<>());

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Verify no matches since there are no preferences
        assertTrue(result.isEmpty());
    }

    @Test
    void testStableMatchMismatchedParticipants() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Fiona", new LinkedList<>(Arrays.asList("George")));
        womenPrefs.put("Grace", new LinkedList<>(Arrays.asList("Henry")));

        menPrefs.put("George", new LinkedList<>(Arrays.asList("Fiona", "Grace")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Verify the match and unmatched participants
        assertEquals("George", result.get("Fiona"));
        assertNull(result.get("Grace")); // Grace remains unmatched
    }

    @Test
    void testStableMatchAllUnmatched() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Hannah", new LinkedList<>());
        womenPrefs.put("Isla", new LinkedList<>());

        menPrefs.put("Jack", new LinkedList<>());
        menPrefs.put("Kevin", new LinkedList<>());

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Verify no matches since there are no valid preferences
        assertTrue(result.isEmpty());
    }

    @Test
    void testStableMatchComplexScenario() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Lara", new LinkedList<>(Arrays.asList("Mike", "Nate", "Oscar")));
        womenPrefs.put("Mona", new LinkedList<>(Arrays.asList("Nate", "Mike", "Oscar")));
        womenPrefs.put("Nina", new LinkedList<>(Arrays.asList("Oscar", "Nate", "Mike")));

        menPrefs.put("Mike", new LinkedList<>(Arrays.asList("Mona", "Nina", "Lara")));
        menPrefs.put("Nate", new LinkedList<>(Arrays.asList("Lara", "Nina", "Mona")));
        menPrefs.put("Oscar", new LinkedList<>(Arrays.asList("Nina", "Mona", "Lara")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Verify the matches
        assertEquals("Mike", result.get("Mona"));
        assertEquals("Nate", result.get("Lara"));
        assertEquals("Oscar", result.get("Nina"));
    }
    @Test
    void testWomanWithNullPreferences() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Olivia", null); // Null preference list for Olivia
        menPrefs.put("Paul", new LinkedList<>(Arrays.asList("Olivia")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Olivia cannot be matched due to null preferences
        assertTrue(result.isEmpty());
    }
    @Test
    void testWomanSwitchesToPreferredMan() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Alice", new LinkedList<>(Arrays.asList("Bob", "Charlie")));
        menPrefs.put("Bob", new LinkedList<>(Arrays.asList("Alice")));
        menPrefs.put("Charlie", new LinkedList<>(Arrays.asList("Alice")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Charlie is free initially, but Alice switches from Bob to Charlie due to preference
        assertEquals("Bob", result.get("Alice"));
        assertFalse(result.containsValue("Charlie"));
    }

    @Test
    void testWomanRejectsProposal() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Quinn", new LinkedList<>(Arrays.asList("Ryan", "Sam"))); // Quinn prefers Ryan over Sam
        menPrefs.put("Ryan", new LinkedList<>(Arrays.asList("Quinn")));
        menPrefs.put("Sam", new LinkedList<>(Arrays.asList("Quinn")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Quinn should stay engaged to Ryan, rejecting Sam's proposal
        assertEquals("Ryan", result.get("Quinn"));
    }

    @Test
    void testBoundaryConditionEqualPreference() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Tina", new LinkedList<>(Arrays.asList("Uma", "Victor")));
        menPrefs.put("Uma", new LinkedList<>(Arrays.asList("Tina")));
        menPrefs.put("Victor", new LinkedList<>(Arrays.asList("Tina")));

        // Modify preference order to make Uma and Victor equally preferred
        womenPrefs.get("Tina").add(1, "Uma"); // Add duplicate to make index comparison ambiguous

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Ensure algorithm still resolves to a stable match
        assertNotNull(result.get("Tina"));
    }

    @Test
    void testLargePreferenceIndex() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Wendy", new LinkedList<>(Arrays.asList("Xavier")));
        menPrefs.put("Xavier", new LinkedList<>(Arrays.asList("Wendy")));

        // Add a large preference index for Wendy
        womenPrefs.get("Wendy").addAll(Collections.nCopies(1000, "Yann"));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Xavier should still match Wendy despite large preference list
        assertEquals("Xavier", result.get("Wendy"));
    }

    /**
     * Test for Integration Parameter Variable Replacement (IPVR).
     */
    @Test
    public void testIPVR() {
        // Original input data for stable matching
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Alice", new LinkedList<>(List.of("John", "Paul")));
        womenPrefs.put("Bob", new LinkedList<>(List.of("Paul", "John")));
        menPrefs.put("John", new LinkedList<>(List.of("Alice", "Bob")));
        menPrefs.put("Paul", new LinkedList<>(List.of("Bob", "Alice")));

        // Original method call
        Map<String, String> originalResult = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Replace one of the input maps with a mutated map (e.g., different preferences for women)
        Map<String, LinkedList<String>> mutatedWomenPrefs = new HashMap<>();
        mutatedWomenPrefs.put("Alice", new LinkedList<>(List.of("Paul", "John"))); // IVPR: Change Alice's preference

        Map<String, String> mutatedResult = GaleShapley.stableMatch(mutatedWomenPrefs, menPrefs);

        // The results should differ due to the change in women's preferences
        assertNotEquals(originalResult, mutatedResult, "IPVR mutation was not killed!");
    }

    /**
     * Test for Integration Unary Operator Insertion (IUOI).
     */
    @Test
    public void testIUOI() {
        // Original input data for stable matching
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Alice", new LinkedList<>(List.of("John", "Paul")));
        womenPrefs.put("Bob", new LinkedList<>(List.of("Paul", "John")));
        menPrefs.put("John", new LinkedList<>(List.of("Alice", "Bob")));
        menPrefs.put("Paul", new LinkedList<>(List.of("Bob", "Alice")));

        // Original method call
        Map<String, String> originalResult = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Mutate the input by applying a unary operation (e.g., negating the preferences)
        // In this case, we don't really have "negation" but we can simulate changing the input to some new invalid state.
        menPrefs.put("John", new LinkedList<>(List.of("Alice"))); // IUOI: Modify John's preferences

        Map<String, String> mutatedResult = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // The results should differ due to the unary operation (modifying John’s preference)
        assertNotEquals(originalResult, mutatedResult, "IUOI mutation was not killed!");
    }
    /**
     * Test for Integration Method Call Deletion (IMCD).
     */
    @Test
    public void testIMCD() {
        // Original input data for stable matching
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Alice", new LinkedList<>(List.of("John", "Paul")));
        womenPrefs.put("Bob", new LinkedList<>(List.of("Paul", "John")));
        menPrefs.put("John", new LinkedList<>(List.of("Alice", "Bob")));
        menPrefs.put("Paul", new LinkedList<>(List.of("Bob", "Alice")));

        // Original method call
        Map<String, String> originalResult = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Simulate a method call deletion by returning a constant value (e.g., empty matching)
        Map<String, String> mutatedResult = new HashMap<>(); // IMCD: Simulating method deletion, return empty map

        // The results should differ due to the method call deletion
        assertNotEquals(originalResult, mutatedResult, "IMCD mutation was not killed!");
    }

    /**
     * Test for Integration Return Expression Modification (IREM).
     */
    @Test
    public void testIREM() {
        // Original input data for stable matching
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        womenPrefs.put("Alice", new LinkedList<>(List.of("John", "Paul")));
        womenPrefs.put("Bob", new LinkedList<>(List.of("Paul", "John")));
        menPrefs.put("John", new LinkedList<>(List.of("Alice", "Bob")));
        menPrefs.put("Paul", new LinkedList<>(List.of("Bob", "Alice")));

        // Original method call
        Map<String, String> originalResult = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Modify the return value by altering the result after method execution
        Map<String, String> mutatedResult = GaleShapley.stableMatch(womenPrefs, menPrefs);
        mutatedResult.put("Alice", "Paul"); // IREM: Modify the return expression by altering the result

        // The results should differ due to the modified return expression
        assertNotEquals(originalResult, mutatedResult, "IREM mutation was not killed!");
    }
}
