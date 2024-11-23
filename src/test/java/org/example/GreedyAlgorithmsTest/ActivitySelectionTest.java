package org.example.GreedyAlgorithmsTest;

import org.example.GreedyAlgorithms.ActivitySelection;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ActivitySelectionTest {

    // Unit Tests

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

}
