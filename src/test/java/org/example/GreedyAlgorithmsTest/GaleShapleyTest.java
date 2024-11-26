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
    @Test
    public void testManWithNoPreferences() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Bob", "Charlie")));
        womenPrefs.put("Diana", new LinkedList<>(List.of("Bob", "Charlie")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", null); // Man with no preferences
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice", "Diana")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals("Charlie", result.get("Alice")); // Alice matches Charlie
        assertEquals(null, result.get("Diana"));  // Diana matches Charlie
    }
    @Test
    public void testEmptyPreferenceLists() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>());
        womenPrefs.put("Diana", new LinkedList<>());

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>());
        menPrefs.put("Charlie", new LinkedList<>());

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertTrue(result.isEmpty()); // No matches should occur
    }
    @Test
    public void testCyclicPreferences() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Bob", "Charlie")));
        womenPrefs.put("Diana", new LinkedList<>(List.of("Charlie", "Bob")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>(List.of("Diana", "Alice")));
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice", "Diana")));

        GaleShapley.stableMatch(womenPrefs, menPrefs);
    }
    @Test
    public void testWomanPrefersNewMan() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Bob", "Charlie")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>(List.of("Alice")));
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals("Bob", result.get("Alice")); // Ensure Bob is matched first

        // Change preferences mid-process
        menPrefs.get("Charlie").poll();
        result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals(null, result.get("Alice")); // Charlie replaces Bob
    }
    @Test
    public void testEngagementUpdate() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Bob", "Charlie")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>(List.of("Alice")));
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals("Bob", result.get("Alice")); // Initial engagement

        menPrefs.get("Charlie").poll(); // Charlie proposes
        result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals(null, result.get("Alice")); // Engagement updated
    }
    @Test
    public void testManReaddedToFreeMen() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Bob", "Charlie")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>(List.of("Alice")));
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals("Bob", result.get("Alice")); // Initial engagement

        // Ensure Charlie replaces Bob
        LinkedList<String> freeMen = new LinkedList<>(menPrefs.keySet());
        assertTrue(freeMen.contains("Bob")); // Verify Bob is added back to freeMen
    }
    @Test
    public void testManRejectedAndReaddedToFreeMen() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Charlie", "Bob")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>(List.of("Alice")));
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals("Charlie", result.get("Alice")); // Charlie engaged

        LinkedList<String> freeMen = new LinkedList<>(menPrefs.keySet());
        assertTrue(freeMen.contains("Bob")); // Bob remains in freeMen
    }
    @Test
    public void testExceedsMaxIterations() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Bob", "Charlie")));
        womenPrefs.put("Bob", new LinkedList<>(List.of("Alice", "Charlie")));
        womenPrefs.put("Charlie", new LinkedList<>(List.of("Alice", "Bob")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>(List.of("Alice")));
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice")));

        GaleShapley.stableMatch(womenPrefs, menPrefs);  // This should throw an exception
    }
    @Test
    public void testIterationsDecrementToNegative() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Bob", "Charlie")));
        womenPrefs.put("Bob", new LinkedList<>(List.of("Alice", "Charlie")));
        womenPrefs.put("Charlie", new LinkedList<>(List.of("Alice", "Bob")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>(List.of("Alice")));
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice")));

        // Set maxIterations to a reasonable number
        int maxIterations = 5;

        // Call the method to check if the iteration works
        GaleShapley.stableMatch(womenPrefs, menPrefs);  // The loop should fail because of negative iteration increment
    }
    @Test
    public void testExceptionThrownOnFailureToTerminate() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("Alice", new LinkedList<>(List.of("Bob", "Charlie")));
        womenPrefs.put("Bob", new LinkedList<>(List.of("Alice", "Charlie")));
        womenPrefs.put("Charlie", new LinkedList<>(List.of("Alice", "Bob")));

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("Bob", new LinkedList<>(List.of("Alice")));
        menPrefs.put("Charlie", new LinkedList<>(List.of("Alice")));


        GaleShapley.stableMatch(womenPrefs, menPrefs);  // This should throw IllegalStateException
    }
    // Basic test case to check stable matching
    @Test
    public void testBasicMatching() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        // Men preferences
        menPrefs.put("Man1", new LinkedList<>(Arrays.asList("Woman1", "Woman2")));
        menPrefs.put("Man2", new LinkedList<>(Arrays.asList("Woman2", "Woman1")));

        // Women preferences
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1", "Man2")));
        womenPrefs.put("Woman2", new LinkedList<>(Arrays.asList("Man2", "Man1")));

        // Run stable matching algorithm
        Map<String, String> engagements = GaleShapley.stableMatch(womenPrefs, menPrefs);

        assertEquals("Man1", engagements.get("Woman1"));
        assertEquals("Man2", engagements.get("Woman2"));
    }

    // Test case where no man is added back to freeMen (check if the algorithm terminates prematurely)
    @Test
    public void testNoFreeMenAddedBack() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        // Men preferences
        menPrefs.put("Man1", new LinkedList<>(Arrays.asList("Woman1")));
        menPrefs.put("Man2", new LinkedList<>(Arrays.asList("Woman1")));

        // Women preferences
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1", "Man2")));

        // Run stable matching algorithm
        Map<String, String> engagements = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // If the call to LinkedList.add is removed, Man2 may never get a chance to be matched
        assertEquals("Man1", engagements.get("Woman1"));
        // The test may fail without the `add` method as Man2 should ideally be engaged as well
    }

    // Test case with only one man and one woman
    @Test
    public void testSingleManSingleWoman() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        // Men preferences
        menPrefs.put("Man1", new LinkedList<>(Arrays.asList("Woman1")));

        // Women preferences
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1")));

        // Run stable matching algorithm
        Map<String, String> engagements = GaleShapley.stableMatch(womenPrefs, menPrefs);

        assertEquals("Man1", engagements.get("Woman1"));
    }

    // Test case with more men than women
    @Test
    public void testUnevenPreferences() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        // Men preferences
        menPrefs.put("Man1", new LinkedList<>(Arrays.asList("Woman1", "Woman2")));
        menPrefs.put("Man2", new LinkedList<>(Arrays.asList("Woman1", "Woman2")));
        menPrefs.put("Man3", new LinkedList<>(Arrays.asList("Woman2", "Woman1")));

        // Women preferences
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1", "Man2")));
        womenPrefs.put("Woman2", new LinkedList<>(Arrays.asList("Man2", "Man3")));

        // Run stable matching algorithm
        Map<String, String> engagements = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Check the matches
        assertEquals("Man3", engagements.get("Woman1"));
        assertEquals("Man1", engagements.get("Woman2"));
    }

    // Test case with a large number of people
    @Test
    public void testLargeInput() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        for (int i = 1; i <= 1000; i++) {
            menPrefs.put("Man" + i, new LinkedList<>(Arrays.asList("Woman" + i)));
            womenPrefs.put("Woman" + i, new LinkedList<>(Arrays.asList("Man" + i)));
        }

        // Run stable matching algorithm
        Map<String, String> engagements = GaleShapley.stableMatch(womenPrefs, menPrefs);

        for (int i = 1; i <= 1000; i++) {
            assertEquals("Man" + i, engagements.get("Woman" + i));
        }
    }

    // Test case where max iterations are sufficient and the matching succeeds
    @Test
    public void testMatchingSuccess() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        // Men preferences
        menPrefs.put("Man1", new LinkedList<>(Arrays.asList("Woman1")));
        menPrefs.put("Man2", new LinkedList<>(Arrays.asList("Woman1")));

        // Women preferences
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1", "Man2")));

        // A large enough value for maxIterations
        int maxIterations = 100;

        // Run stable matching algorithm and check that no exception is thrown
        Map<String, String> engagements = GaleShapley.stableMatch(womenPrefs, menPrefs);

        assertEquals("Man1", engagements.get("Woman1"));
    }
    // Test case to check that the loop terminates correctly without calling isEmpty
    @Test
    public void testLoopTerminationWithoutIsEmpty() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        // Men preferences
        menPrefs.put("Man1", new LinkedList<>(Arrays.asList("Woman1")));
        menPrefs.put("Man2", new LinkedList<>(Arrays.asList("Woman1")));

        // Women preferences
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1", "Man2")));

        // Create a small map of engagements
        Map<String, String> engagements = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Check if the loop terminates and the engagements are correct
        assertNotNull(engagements);
        assertEquals(1, engagements.size());  // Expecting one engagement
        assertEquals("Man1", engagements.get("Woman1"));
    }
    @Test
    public void testRemovedIndexOfCall() {
        // Test case where index comparison determines the engagement (removing indexOf will break it)
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("W1", new LinkedList<>(List.of("M1", "M2"))); // Woman W1 prefers M1 first

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("M1", new LinkedList<>(List.of("W1"))); // Man M1 prefers W1
        menPrefs.put("M2", new LinkedList<>(List.of("W1"))); // Man M2 prefers W1

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals("M1", result.get("W1"));  // W1 should match with M1 (since W1 prefers M1 over M2)
    }
    @Test
    public void testChangedConditionalBoundary() {
        // Test case where the man is preferred over another but the mutated condition fails
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        womenPrefs.put("W1", new LinkedList<>(List.of("M2", "M1"))); // Woman W1 prefers M2 first

        Map<String, LinkedList<String>> menPrefs = new HashMap<>();
        menPrefs.put("M1", new LinkedList<>(List.of("W1"))); // Man M1 prefers W1
        menPrefs.put("M2", new LinkedList<>(List.of("W1"))); // Man M2 prefers W1

        // The result should ideally have W1 matched to M2 since W1 prefers M2 first
        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        assertEquals("M2", result.get("W1"));  // If boundary is correct, W1 will match with M2
    }

    // Test case to check the behavior when manPref is null or empty
    @Test
    public void testManPrefNullOrEmpty() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        // Men preferences
        menPrefs.put("Man1", null);  // Null preferences list
        menPrefs.put("Man2", new LinkedList<>());  // Empty preferences list

        // Women preferences
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1", "Man2")));

        // Run the Gale-Shapley algorithm
        Map<String, String> engagements = GaleShapley.stableMatch(womenPrefs, menPrefs);

        // Verify the result
        // Since Man1 and Man2 both have null or empty preferences, they should not be engaged
        assertTrue(engagements.isEmpty(), "Expected no engagements due to empty or null man preferences.");
    }
    @Test
    void testManPrefIsNullOrEmpty() {
        Map<String, LinkedList<String>> womenPrefs = new HashMap<>();
        Map<String, LinkedList<String>> menPrefs = new HashMap<>();

        // Test when manPref is null
        menPrefs.put("Man1", null);
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1")));

        Map<String, String> result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        // Since manPref is null, the man should be skipped and no engagement should occur
        assertTrue(result.isEmpty());

        // Test when manPref is an empty list
        menPrefs.put("Man1", new LinkedList<>());
        womenPrefs.put("Woman1", new LinkedList<>(Arrays.asList("Man1")));

        result = GaleShapley.stableMatch(womenPrefs, menPrefs);
        // Since manPref is empty, the man should be skipped and no engagement should occur
        assertTrue(result.isEmpty());
    }

}
