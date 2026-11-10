import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(4, new int[] { 1, 2, 3, 4 }, 13),
                new TestCase(4, new int[] { 5, 1, 6, 2 }, 11),
                new TestCase(3, new int[] { 9, 8, 3 }, 12)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.climbStairs(test.in1, test.in2);
            assert test.expected == actual : "climbStairs(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public int climbStairs(int n, int[] costs) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int min = dp[i - 1] + costs[i - 1] + 1;
            if (i >= 2) {
                min = Math.min(min, dp[i - 2] + costs[i - 1] + 4);
            }
            if (i >= 3) {
                min = Math.min(min, dp[i - 3] + costs[i - 1] + 9);
            }
            dp[i] = min;
        }
        return dp[n];
    }

}