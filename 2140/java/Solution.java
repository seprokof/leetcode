import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 3, 2 }, { 4, 3 }, { 4, 4 }, { 2, 5 } }, 5L),
                new TestCase(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, { 5, 5 } }, 7L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.mostPoints(test.in);
            assert test.expected == actual : "mostPoints(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public long mostPoints(int[][] questions) {
        long[] dp = new long[questions.length];
        dp[questions.length - 1] = questions[questions.length - 1][0];
        for (int i = questions.length - 2; i >= 0; i--) {
            int nextIdx = i + questions[i][1] + 1;
            dp[i] = questions[i][0] + (nextIdx < questions.length ? dp[nextIdx] : 0);
            dp[i] = Math.max(dp[i + 1], dp[i]);
        }
        return dp[0];
    }

}