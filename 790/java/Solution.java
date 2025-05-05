class Solution {

    private static final int MODULO = 1_000_000_007;

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, int expected) {}

        TestCase[] tests = {
                new TestCase(3, 5),
                new TestCase(1, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numTilings(test.in);
            assert test.expected == actual : "numTilings(%s) == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int numTilings(int n) {
        if (n <= 2) {
            return n;
        }
        if (n == 3) {
            return 5;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++) {
            dp[i] = (int) ((2L * dp[i - 1] + dp[i - 3]) % MODULO);
        }
        return dp[n];
    }

}