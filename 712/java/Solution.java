class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, int expected) {}

        TestCase[] tests = {
                new TestCase("sea", "eat", 231),
                new TestCase("delete", "leet", 403)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumDeleteSum(test.in1, test.in2);
            assert test.expected == actual : "minimumDeleteSum('%s', '%s') = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public int minimumDeleteSum(String s1, String s2) {
        int len1 = s1.length();
        int total = 0;
        for (int i = 0; i < len1; i++) {
            total += s1.charAt(i);
        }
        int len2 = s2.length();
        for (int i = 0; i < len2; i++) {
            total += s2.charAt(i);
        }
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + s1.charAt(i - 1);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return total - 2 * dp[len1][len2];
    }

}