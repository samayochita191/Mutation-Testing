package org.example.GreedyAlgorithmsTest;
import static org.junit.jupiter.api.Assertions.*;
import org.example.GreedyAlgorithms.BinaryAddition;
import org.junit.jupiter.api.Test;

public class BinaryAdditionTest {

    BinaryAddition binaryAddition = new BinaryAddition();

    // Test case for simple binary addition without carry
    @Test
    public void testSimpleBinaryAddition() {
        String a = "1010";
        String b = "0101";
        String expected = "1111";

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case for binary addition with carry
    @Test
    public void testBinaryAdditionWithCarry() {
        String a = "111";
        String b = "111";
        String expected = "1110"; // 7 + 7 = 14 => 1110

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case where binary strings are of different lengths
    @Test
    public void testDifferentLengthBinaryStrings() {
        String a = "1010";
        String b = "110";
        String expected = "10000"; // 10 + 6 = 16 => 10000

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case where one binary string is longer than the other
    @Test
    public void testLongerBinaryString() {
        String a = "110011";
        String b = "101";
        String expected = "111000";

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case for addition with padding of zeros
    @Test
    public void testBinaryAdditionWithPadding() {
        String a = "1";
        String b = "11";
        String expected = "100"; // 1 + 3 = 4 => 100

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case for binary addition where both strings are zero
    @Test
    public void testZeroBinaryAddition() {
        String a = "0";
        String b = "0";
        String expected = "0"; // 0 + 0 = 0

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case where the sum results in a carry at the highest bit
    @Test
    public void testBinaryAdditionWithCarryAtHighestBit() {
        String a = "111";
        String b = "1";
        String expected = "1000"; // 7 + 1 = 8 => 1000

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case for adding two binary strings that result in no carry and no padding
    @Test
    public void testSimpleNoCarryNoPadding() {
        String a = "101";
        String b = "010";
        String expected = "111"; // 5 + 2 = 7 => 111

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case for adding binary strings with a carry at the middle bit
    @Test
    public void testCarryInMiddle() {
        String a = "1011";
        String b = "1101";
        String expected = "11000"; // 11 + 13 = 24 => 11000

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case for binary addition where both strings are large numbers
    @Test
    public void testLargeBinaryAddition() {
        String a = "110110101101110110111";
        String b = "10101010101010101010";
        String expected = "1001100000011001100001"; // large numbers added

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }

    // Test case for binary addition resulting in no carry
    @Test
    public void testBinaryAdditionNoCarry() {
        String a = "1010";
        String b = "0010";
        String expected = "1100"; // 10 + 2 = 12 => 1100

        String result = binaryAddition.addBinary(a, b);
        assertEquals(expected, result);
    }
    // Test case when count is 0 (all inputs are '0')
        @Test
        public void testSumWithNoOnes() {
            char a = '0';
            char b = '0';
            char carry = '0';
            char expected = '0'; // count = 0, should return '0'

            char result = binaryAddition.sum(a, b, carry);
            assertEquals(expected, result);
        }
    // Test case for testing the mutated logic where count might be decremented (e.g. using -1 instead of +1)
    @Test
    public void testSumWithNegativeIncrementMutation() {
        // This is a scenario where we expect count to behave differently due to the mutation
        char a = '1';
        char b = '0';
        char carry = '1';
        // If the increment was changed to -1, we might get different behavior in the carry calculation
        char expected = '0'; // count would be 2 (should return 0 based on normal logic)

        char result = binaryAddition.sum(a, b, carry);
        assertEquals(expected, result);
    }

    // Additional test case for carry-over logic with different bit patterns
    @Test
    public void testCarryWithAlternatingBits() {
        // Alternating bit pattern where sum should properly carry over
        char a = '1';
        char b = '1';
        char carry = '1';
        char expectedSum = '1'; // Sum should be '1' and carry-over should be handled

        char sumResult = binaryAddition.sum(a, b, carry);
        char expectedCarry = binaryAddition.carry(a, b, carry);

        assertEquals(expectedSum, sumResult);
        assertEquals('1', expectedCarry); // carry should be '1'
    }

    // Integration Test for IPVR (Integration Parameter Variable Replacement)
    @Test
    public void testIPVR() {
        String a = "1101";
        String b = "1011";
        // Replace parameters with reversed strings
        String mutatedResult = binaryAddition.addBinary(new StringBuilder(a).reverse().toString(), b);
        String originalResult = binaryAddition.addBinary(a, b);

        assertNotEquals(originalResult, mutatedResult, "IVPR mutation was not killed!");
    }

    // Integration Test for IUOI (Integration Unary Operator Insertion)
    @Test
    public void testIUOI() {
        String a = "1101";
        String b = "1011";
        // Negate characters (simulate a faulty unary operator insertion)
        String mutatedResult = binaryAddition.addBinary(
                a.replace('1', '0').replace('0', '1'),
                b.replace('1', '0').replace('0', '1')
        );
        String originalResult = binaryAddition.addBinary(a, b);

        assertNotEquals(originalResult, mutatedResult, "IUOI mutation was not killed!");
    }

    // Integration Test for IMCD (Integration Method Call Deletion)
    @Test
    public void testIMCD() {
        String a = "1101";
        String b = "1011";
        // Simulate mutation by skipping carry calculations
        String mutatedResult = addBinaryWithoutCarry(a, b);
        String originalResult = binaryAddition.addBinary(a, b);

        assertNotEquals(originalResult, mutatedResult, "IMCD mutation was not killed!");
    }

    // Integration Test for IREM (Integration Return Expression Modification)
    @Test
    public void testIREM() {
        String a = "1101";
        String b = "1011";
        // Mutate by adding an extra '1' at the end of the result
        String mutatedResult = binaryAddition.addBinary(a, b) + "1";
        String originalResult = binaryAddition.addBinary(a, b);

        assertNotEquals(originalResult, mutatedResult, "IREM mutation was not killed!");
    }

    /**
     * Helper method to simulate IMCD by skipping carry calculations.
     */
    private String addBinaryWithoutCarry(String a, String b) {
        int maxLength = Math.max(a.length(), b.length());
        a = String.format("%" + maxLength + "s", a).replace(' ', '0');
        b = String.format("%" + maxLength + "s", b).replace(' ', '0');

        StringBuilder result = new StringBuilder();

        for (int i = maxLength - 1; i >= 0; i--) {
            char sum = binaryAddition.sum(a.charAt(i), b.charAt(i), '0'); // Always use '0' as carry
            result.append(sum);
        }

        return result.reverse().toString();
    }
}
