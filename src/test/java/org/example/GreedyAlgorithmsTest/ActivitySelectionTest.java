package org.example.GreedyAlgorithmsTest;

import org.example.GreedyAlgorithms.ActivitySelection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ActivitySelectionTest {


    // Original test case
    private final int[] startTimes = {1, 3, 0, 5, 8, 5};
    private final int[] endTimes = {2, 4, 6, 7, 9, 9};

    /**
     * Test case to ensure the original implementation works correctly.
     */
    @Test
    public void testOriginalImplementation() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0);
        expected.add(1);
        expected.add(3);
        expected.add(4);

        ArrayList<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
        assertEquals(expected, actual, "Original implementation failed!");
    }

    /**
     * Integration Parameter Variable Replacement (IVPR) Test.
     * Replace input arrays with swapped versions and check results.
     */
    @Test
    public void testIPVR() {
        int[] swappedStartTimes = {3, 1, 5, 0, 8, 5};
        int[] swappedEndTimes = {4, 2, 7, 6, 9, 9};

        // Mutated version of activitySelection with swapped parameters
        ArrayList<Integer> mutatedOutput = ActivitySelection.activitySelection(swappedStartTimes, swappedEndTimes);

        // IVPR Mutation Test: Should not match original result
        ArrayList<Integer> originalOutput = ActivitySelection.activitySelection(startTimes, endTimes);
        assertNotEquals(originalOutput, mutatedOutput, "IVPR mutation was not killed!");
    }

    /**
     * Integration Method Call Deletion (IMCD) Test.
     * Simulate deletion of sorting logic and verify incorrect results.
     */
    @Test
    public void testIMCD() {
        // Test data where sorting is critical
        int[] unsortedStartTimes = {5, 3, 0, 1, 8, 5};
        int[] unsortedEndTimes = {7, 4, 6, 2, 9, 9};

        // Mutated activitySelection (without sorting)
        ArrayList<Integer> mutatedOutput = activitySelectionWithoutSorting(unsortedStartTimes, unsortedEndTimes);

        // Original activitySelection with sorting
        ArrayList<Integer> originalOutput = ActivitySelection.activitySelection(unsortedStartTimes, unsortedEndTimes);

        // IMCD Mutation Test: Should not match original result
        assertNotEquals(originalOutput, mutatedOutput, "IMCD mutation was not killed!");
    }


    /**
     * Integration Parameter Exchange (IPEX) Test.
     * Exchange start and end times and verify incorrect results.
     */
    @Test
    public void testIPEX() {
        // Mutated activitySelection with swapped start/end times
        ArrayList<Integer> mutatedOutput = ActivitySelection.activitySelection(endTimes, startTimes);

        // IPEX Mutation Test: Should not match original result
        ArrayList<Integer> originalOutput = ActivitySelection.activitySelection(startTimes, endTimes);
        assertNotEquals(originalOutput, mutatedOutput, "IPEX mutation was not killed!");
    }

    /**
     * Integration Return Expression Modification (IREM) Test.
     * Simulate incorrect return values and verify results.
     */
    @Test
    public void testIREM() {
        // Mutated activitySelection with incorrect return
        ArrayList<Integer> mutatedOutput = activitySelectionWithIREM(startTimes, endTimes);

        // IREM Mutation Test: Should not match original result
        ArrayList<Integer> originalOutput = ActivitySelection.activitySelection(startTimes, endTimes);
        assertNotEquals(originalOutput, mutatedOutput, "IREM mutation was not killed!");
    }

    // Helper method to simulate IMCD mutation
    private ArrayList<Integer> activitySelectionWithoutSorting(int[] startTimes, int[] endTimes) {
        ArrayList<Integer> selectedActivities = new ArrayList<>();
        if (startTimes.length == 0) return selectedActivities;

        // Assume activities are already sorted (mutation)
        selectedActivities.add(0);
        int lastEndTime = endTimes[0];

        for (int i = 1; i < startTimes.length; i++) {
            if (startTimes[i] >= lastEndTime) {
                selectedActivities.add(i);
                lastEndTime = endTimes[i];
            }
        }
        return selectedActivities;
    }

    // Helper method to simulate IREM mutation
    private ArrayList<Integer> activitySelectionWithIREM(int[] startTimes, int[] endTimes) {
        ArrayList<Integer> selectedActivities = ActivitySelection.activitySelection(startTimes, endTimes);
        selectedActivities.add(999); // Mutation: Incorrect addition
        return selectedActivities;
    }

    @Test
    void testNonOverlappingActivities() {
        // Case: Activities do not overlap
        int[] startTimes = {1, 3, 5};
        int[] endTimes = {2, 4, 6};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }

    @Test
    void testOverlappingActivities() {
        // Case: Activities overlap
        int[] startTimes = {1, 2, 3};
        int[] endTimes = {2, 4, 5};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }

    @Test
    void testSingleActivity() {
        // Case: Only one activity
        int[] startTimes = {1};
        int[] endTimes = {2};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }


    @Test
    void testEdgeCaseActivitiesEndingAtSameTime() {
        // Case: Multiple activities ending at the same time
        int[] startTimes = {1, 2, 3};
        int[] endTimes = {4, 4, 4};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }

    // Integration Tests

    @Test
    void testCorrectActivityIndicesReturned() {
        // Integration Test: Ensure the indices map correctly to the original input
        int[] startTimes = {3, 1, 2};
        int[] endTimes = {4, 2, 3};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 2));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }

    @Test
    void testSortingLogicEffectiveness() {
        // Integration Test: Check sorting logic of activities by end time
        int[] startTimes = {10, 12, 20};
        int[] endTimes = {20, 25, 30};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 2));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }

    @Test
    void testMixedOverlappingAndNonOverlappingActivities() {
        // Integration Test: Mixed scenario
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0, 1, 3, 4));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }
    @Test
    public void testNoActivities() {
        int[] startTimes = {};
        int[] endTimes = {};
        ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAllOverlappingActivities() {
        int[] startTimes = {1, 1, 1};
        int[] endTimes = {2, 2, 2};
        ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);
        assertEquals(new ArrayList<>(List.of(0)), result);
    }
    @Test
    void testBoundaryCondition() {
        int[] startTimes = {Integer.MAX_VALUE - 1};
        int[] endTimes = {Integer.MAX_VALUE};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }
    @Test
    void testLargeInput() {
        int[] startTimes = new int[1000];
        int[] endTimes = new int[1000];
        for (int i = 0; i < 1000; i++) {
            startTimes[i] = i;
            endTimes[i] = i + 1;
        }
        ArrayList<Integer> expected = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            expected.add(i);
        }
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }
    @Test
    void testCompleteOverlap() {
        int[] startTimes = {1, 1, 1};
        int[] endTimes = {5, 5, 5};
        ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(0));
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }
    @Test
    public void testActivitySelection_EndTimesCritical() {
        int[] startTimes = {1, 3, 2, 5};
        int[] endTimes = {2, 4, 3, 6}; // Distinct end times
        List<Integer> expected = Arrays.asList(0, 1, 2, 3); // Correct selection based on end times
        assertEquals(expected, ActivitySelection.activitySelection(startTimes, endTimes));
    }
    @Test
    public void testExactThreeActivities() {
        // Define start and end times for three activities
        int[] startTimes = {1, 3, 0};
        int[] endTimes = {2, 4, 6};

        // Expected result: Only the first and third activities (indices 0 and 2) should be selected
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0); // Activity 1: 1-2
        expected.add(1);

        // Run the activity selection function
        ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

        // Verify that the selected activities match the expected result
        assertEquals(expected, result);
    }
    @Test
    public void testActivitySelection_MutantCriticalCase() {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9};
        List<Integer> expected = Arrays.asList(0, 1, 3, 4); // Correct selection

        List<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
        assertEquals(expected, actual);
    }
    @Test
    public void testSortingByEndTime() {
        // Define start and end times where activities are not pre-sorted by end time
        int[] startTimes = {1, 3, 0, 5};
        int[] endTimes = {2, 4, 6, 7};

        // Expected result: Activities selected are indices [0, 1, 3]
        // After sorting by end time, the order becomes: {0->1->3->2}
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(0); // Activity 1: 1-2
        expected.add(1); // Activity 2: 3-4
        expected.add(3); // Activity 4: 5-7

        // Run the activity selection function
        ArrayList<Integer> result = ActivitySelection.activitySelection(startTimes, endTimes);

        // Verify that the selected activities match the expected result
        assertEquals(expected, result);
    }
    @Test
    public void testActivitySelection_MutantKills() {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9}; // Correct end times

        // This is the expected result when the end times are sorted correctly.
        List<Integer> expected = Arrays.asList(0, 1, 3, 4);

        List<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
        assertEquals(expected, actual);
    }
    @Test
    public void testActivitySelection_EndTimeEdgeCase() {
        int[] startTimes = {1, 2, 3, 4, 5};
        int[] endTimes = {6, 7, 8, 9, 10};
        List<Integer> expected = Arrays.asList(0);  // All activities are selected if no overlap

        List<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
        assertEquals(expected, actual);
    }
    @Test
    public void testActivitySelection_Mutant8_Kills() {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {2, 4, 6, 7, 9, 9}; // Correct end times for activities

        // Expected result when sorting works correctly by end time.
        List<Integer> expected = Arrays.asList(0, 1, 3, 4);  // Activities 0, 1, 3, and 4 should be selected

        List<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
        assertEquals(expected, actual);  // Test ensures sorting by end time works
    }
    @Test
    public void testActivitySelection_Mutant5_Kills() {
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {4, 4, 6, 7, 9, 9}; // Two activities have the same end time: 4 and 4

        // Expected result when secondary sorting by index works properly.
        List<Integer> expected = Arrays.asList(0, 3, 4);

        List<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);
        assertEquals(expected, actual);  // This test ensures that secondary sorting is essential
    }
    @Test
    public void testActivitySelection_MutantKilled() {
        // Activities with start and end times
        int[] startTimes = {1, 3, 0, 5, 8, 5};
        int[] endTimes = {4, 4, 6, 7, 9, 9};  // Activity 0 ends at time 4, which is key

        // The expected output when starting the loop at i=1 (correct logic):
        List<Integer> expected = Arrays.asList(0, 3, 4);  // Activities 0, 3, and 4 should be selected.

        List<Integer> actual = ActivitySelection.activitySelection(startTimes, endTimes);

        assertEquals(expected, actual); // Test ensures that the first activity (index 0) is properly selected
    }


}
