import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 5, 11, 5 }, true),
                new TestCase(new int[] { 1, 2, 3, 5 }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canPartition(test.in);
            assert test.expected == actual : "subsetXORSum(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean canPartition(int[] nums) {
        if (nums.length == 1) {
            return false;
        }
        int totalSum = 0;
        for (int n : nums) {
            totalSum += n;
        }
        if (totalSum % 2 != 0) {
            return false;
        }
        int targetSum = totalSum / 2;
        boolean[] dp = new boolean[targetSum + 1];
        dp[0] = true;
        for (int n : nums) {
            for (int i = targetSum; i >= n; i--) {
                dp[i] = dp[i] || dp[i - n];
            }
            if (dp[targetSum]) {
                return true;
            }
        }
        return dp[targetSum];
    }

}