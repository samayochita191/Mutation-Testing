package org.example.GreedyAlgorithmsTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.GreedyAlgorithms.BandwidthAllocation;

import java.util.Arrays;

public class BandwidthAllocationTest {
        // Unit Tests
        @Test
        void testZeroBandwidth() {
            int bandwidth = 0;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};
            assertEquals(0, BandwidthAllocation.maxValue(bandwidth, users, values));
        }

        @Test
        void testExactBandwidthAllocation() {
            int bandwidth = 15;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};
            assertEquals(60, BandwidthAllocation.maxValue(bandwidth, users, values));
        }

        @Test
        void testFractionalAllocation() {
            int bandwidth = 10;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};
            assertEquals(42.0, BandwidthAllocation.maxValue(bandwidth, users, values), 0.001);
        }

    // Integration Tests
        @Test
        void testNoUsersOrValues() {
            int bandwidth = 10;
            int[] users = {};
            int[] values = {};
            assertEquals(0, BandwidthAllocation.maxValue(bandwidth, users, values));
        }

        @Test
        void testMismatchedArrayLengths() {
            int bandwidth = 10;
            int[] users = {3, 5};
            int[] values = {10, 20, 30};
            assertThrows(IllegalArgumentException.class, () -> {
                BandwidthAllocation.maxValue(bandwidth, users, values);
            });
        }
        @Test
        void testLargeInputValues() {
            int bandwidth = 10000;
            int[] users = {100, 200, 300, 400, 500};
            int[] values = {1000, 2000, 3000, 4000, 5000};
            assertEquals(15000, BandwidthAllocation.maxValue(bandwidth, users, values));
        }
        @Test
        void testFractionalAllocationOnly() {
            int bandwidth = 2;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};
            double expectedValue = 8.571; // Fractional allocation to user 0
            assertEquals(expectedValue, BandwidthAllocation.maxValue(bandwidth, users, values), 0.001);
        }

        @Test
        void testExactAllocation() {
            int bandwidth = 5;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};
            double expectedValue = 21.428;
            assertEquals(expectedValue, BandwidthAllocation.maxValue(bandwidth, users, values), 0.001);
        }

        @Test
        void testMixedAllocation() {
            int bandwidth = 8;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};
            double expectedValue = 34;
            assertEquals(expectedValue, BandwidthAllocation.maxValue(bandwidth, users, values), 0.001);
        }
        @Test
        void testDiverseRatios() {
            int bandwidth = 8;
            int[] users = {4, 2, 6};
            int[] values = {12, 20, 18};
            double expectedValue = 20 + 12 + 6; // Full allocation to user 1 and partial to others
            assertEquals(expectedValue, BandwidthAllocation.maxValue(bandwidth, users, values), 0.001);
        }
        @Test
        void testLargeRatios() {
            int bandwidth = 5;
            int[] users = {1, 10, 8};
            int[] values = {10, 50, 24};
            double expectedValue = 10 + 20; // Partial allocation to user 1 after user 0
            assertEquals(expectedValue, BandwidthAllocation.maxValue(bandwidth, users, values), 0.001);
        }
        @Test
        void testFractionalAllocationEdgeCase() {
            int bandwidth = 4;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};
            double expectedValue = 17.1428; // Fractional allocation to user 1
            assertEquals(expectedValue, BandwidthAllocation.maxValue(bandwidth, users, values), 0.001);
        }
        @Test
        void testExactMatchWithFractionalAllocation() {
            int bandwidth = 7;
            int[] users = {5, 10};
            int[] values = {50, 100};
            double expectedValue = 50 + 20; // Fully allocate to user 0, fractionally to user 1
            assertEquals(expectedValue, BandwidthAllocation.maxValue(bandwidth, users, values), 0.001);
        }
        // IPVR Mutation Test
        @Test
        public void testIPVR() {
            int bandwidth = 10;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};

            // Mutate by replacing 'users' with 'values' (IPVR simulation)
            double mutatedResult = BandwidthAllocation.maxValue(bandwidth, values, values);
            double originalResult = BandwidthAllocation.maxValue(bandwidth, users, values);

            assertNotEquals(originalResult, mutatedResult, "IVPR mutation was not killed!");
        }

        // IUOI Mutation Test
        @Test
        public void testIUOI() {
            int bandwidth = 10;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};

            // Mutate by applying a unary operator (negate values)
            int[] mutatedValues = Arrays.stream(values).map(v -> -v).toArray();
            double mutatedResult = BandwidthAllocation.maxValue(bandwidth, users, mutatedValues);
            double originalResult = BandwidthAllocation.maxValue(bandwidth, users, values);

            assertNotEquals(originalResult, mutatedResult, "IUOI mutation was not killed!");
        }

        // IMCD Mutation Test
        @Test
        public void testIMCD() {
            int bandwidth = 10;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};

            // Mutate by bypassing sorting step
            double mutatedResult = maxValueWithoutSorting(bandwidth, users, values);
            double originalResult = BandwidthAllocation.maxValue(bandwidth, users, values);

            assertNotEquals(originalResult, mutatedResult, "IMCD mutation was not killed!");
        }

        /**
         * Helper function to simulate IMCD mutation by skipping sorting.
         */
        private double maxValueWithoutSorting(int bandwidth, int[] users, int[] values) {
            int n = users.length;
            double maxValue = 0;

            // Allocate bandwidth without sorting
            for (int i = 0; i < n; i++) {
                if (bandwidth >= users[i]) {
                    maxValue += values[i];
                    bandwidth -= users[i];
                } else {
                    maxValue += values[i] * ((double) bandwidth / users[i]);
                    break;
                }
            }
            return maxValue;
        }
        // IREM Mutation Test
        @Test
        public void testIREM() {
            int bandwidth = 10;
            int[] users = {3, 5, 7};
            int[] values = {10, 20, 30};

            // Mutate by modifying return value
            double mutatedResult = BandwidthAllocation.maxValue(bandwidth, users, values) + 10;
            double originalResult = BandwidthAllocation.maxValue(bandwidth, users, values);

            assertNotEquals(originalResult, mutatedResult, "IREM mutation was not killed!");
        }

}

