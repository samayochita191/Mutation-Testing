package org.example.GreedyAlgorithmsTest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.example.GreedyAlgorithms.BandwidthAllocation;
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

}

