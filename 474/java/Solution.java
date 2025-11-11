import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String[] in1, int in2, int in3, int expected) {}

        TestCase[] tests = {
                new TestCase(new String[] { "10", "0001", "111001", "1", "0" }, 5, 3, 4),
                new TestCase(new String[] { "10", "0", "1" }, 1, 1, 2)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findMaxForm(test.in1, test.in2, test.in3);
            assert test.expected == actual : "findMaxForm(%s, %s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, test.in3, actual, test.expected);
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int zeros = 0;
            int ones = 0;
            for (char digit : str.toCharArray()) {
                if (digit == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

}