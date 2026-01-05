import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, -1 }, { -1, 1 } }, 4),
                new TestCase(new int[][] { { 1, 2, 3 }, { -1, -2, -3 }, { 1, 2, 3 } }, 16)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.maxMatrixSum(test.in);
            assert test.expected == actual : "maxMatrixSum(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public long maxMatrixSum(int[][] matrix) {
        int countNegative = 0;
        long sum = 0L;
        int minAbs = Integer.MAX_VALUE;
        for (int[] row : matrix) {
            for (int value : row) {
                if (value < 0) {
                    countNegative++;
                    value = -value;
                }
                sum += value;
                minAbs = Math.min(minAbs, value);
            }
        }
        if (countNegative % 2 == 0) {
            return sum;
        }
        return sum - 2 * minAbs;
    }

}