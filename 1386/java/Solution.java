import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(3, new int[][] { { 1, 2 }, { 1, 3 }, { 1, 8 }, { 2, 6 }, { 3, 1 }, { 3, 10 } }, 4),
                new TestCase(2, new int[][] { { 2, 1 }, { 1, 8 }, { 2, 6 } }, 2),
                new TestCase(4, new int[][] { { 4, 3 }, { 1, 4 }, { 4, 6 }, { 1, 7 } }, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxNumberOfFamilies(test.in1, test.in2);
            assert test.expected == actual : "maxNumberOfFamilies(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        int result = n * 2;
        Map<Integer, boolean[]> reserved = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            if (reservedSeat[1] >= 2 && reservedSeat[1] <= 9) {
                reserved.computeIfAbsent(reservedSeat[0], ignore -> new boolean[10])[reservedSeat[1]] = true;
            }
        }
        for (boolean[] reservedRow : reserved.values()) {
            if ((reservedRow[2] || reservedRow[3] || reservedRow[4] || reservedRow[5])
                    && (reservedRow[4] || reservedRow[5] || reservedRow[6] || reservedRow[7])
                    && (reservedRow[6] || reservedRow[7] || reservedRow[8] || reservedRow[9])) {
                result -= 2;
            } else {
                result--;
            }
        }
        return result;
    }

}