package org.example.Backtracking;

import java.util.Arrays;

public class PartitionsOfaSet {

    static boolean
    isKPartitionPossible(int[] arr, int[] subsetSum,
                         boolean[] taken, int target, int k,
                         int n, int currIdx, int limitIdx) {

        if (subsetSum[currIdx] == target) {
            if (currIdx == k - 2)
                return true;
            return isKPartitionPossible(arr, subsetSum,
                    taken, target, k, n,
                    currIdx + 1, n - 1);
        }

        for (int i = limitIdx; i >= 0; i--) {
            if (taken[i])
                continue;

            int temp = subsetSum[currIdx] + arr[i];
            if (temp<= target) {
                taken[i] = true;
                subsetSum[currIdx] += arr[i];
                if (isKPartitionPossible(arr, subsetSum,
                        taken, target, k,
                        n, currIdx, i - 1))
                    return true;
                taken[i] = false;
                subsetSum[currIdx] -= arr[i];
            }
        }
        return false;
    }

    static boolean isKPartitionPossible(int[] arr, int k) {
        int n = arr.length;
        int sum = Arrays.stream(arr).sum();
        if (k == 1) {
            return true;
        }
        if (n < k || sum % k != 0) {
            return false;
        }
        int target = sum / k;
        int[] subsetSum = new int[k];
        boolean[] taken = new boolean[n];
        subsetSum[0] = arr[n - 1];
        taken[n - 1] = true;
        return isKPartitionPossible(arr, subsetSum, taken,
                target, k, n, 0, n - 1);
    }
}
