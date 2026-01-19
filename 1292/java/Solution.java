import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 }, { 1, 1, 3, 2, 4, 3, 2 } }, 4, 2),
                new TestCase(new int[][] { { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 }, { 2, 2, 2, 2, 2 } }, 1, 0)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxSideLength(test.in1, test.in2);
            assert test.expected == actual : "maxSideLength(%s, %s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int maxSideLength(int[][] mat, int threshold) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] prefixSum = new int[m + 1][n + 1];
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                prefixSum[row][col] = prefixSum[row - 1][col] + prefixSum[row][col - 1] - prefixSum[row - 1][col - 1]
                        + mat[row - 1][col - 1];
            }
        }
        int max = 0;
        for (int row = 1; row <= m; row++) {
            for (int col = 1; col <= n; col++) {
                int len = Math.min(m - row + 1, n - col + 1);
                for (int l = len; l > max; l--) {
                    int sum = prefixSum[row + l - 1][col + l - 1] - prefixSum[row - 1][col + l - 1]
                            - prefixSum[row + l - 1][col - 1] + prefixSum[row - 1][col - 1];
                    if (sum <= threshold) {
                        max = Math.max(max, l);
                    }
                }
            }
        }
        return max;
    }

}