package org.example.GreedyAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

// Problem Link: https://en.wikipedia.org/wiki/Activity_selection_problem

public class ActivitySelection {

    /**
     * Function to perform activity selection using a greedy approach.
     *
     * The goal is to select the maximum number of activities that don't overlap
     * with each other, based on their start and end times. Activities are chosen
     * such that no two selected activities overlap.
     *
     * @param startTimes Array containing the start times of the activities.
     * @param endTimes   Array containing the end times of the activities.
     * @return A list of indices representing the selected activities that can be
     *         performed without overlap.
     */
    public static ArrayList<Integer> activitySelection(int[] startTimes, int[] endTimes) {
        int n = startTimes.length;
        ArrayList<Integer> selectedActivities = new ArrayList<>();

        // Handle edge case of no activities
        if (n == 0) {
            return selectedActivities;
        }

        // Create a 2D array to store activity index, start, and end times
        int[][] activities = new int[n][3];
        for (int i = 0; i < n; i++) {
            activities[i][0] = i;         // Original index
            activities[i][1] = startTimes[i]; // Start time
            activities[i][2] = endTimes[i];   // End time
        }

        // Sort activities by end time; use index for secondary sorting
        Arrays.sort(activities, Comparator.<int[]>comparingInt(a -> a[2]).thenComparingInt(a -> a[0]));

        // Select the first activity
        selectedActivities.add(activities[0][0]);
        int lastEndTime = activities[0][2];

        // Iterate through sorted activities
        for (int i = 1; i < n; i++) {
            // Include activity if it doesn't overlap
            if (activities[i][1] >= lastEndTime) {
                selectedActivities.add(activities[i][0]);
                lastEndTime = activities[i][2];
            }
        }

        // Sort the selected indices to match the original order
        selectedActivities.sort(Integer::compareTo);

        return selectedActivities;
    }
}
