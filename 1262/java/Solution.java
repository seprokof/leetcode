import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 6, 5, 1, 8 }, 18),
                new TestCase(new int[] { 4 }, 0),
                new TestCase(new int[] { 1, 2, 3, 4, 4 }, 12)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxSumDivThree(test.in);
            assert test.expected == actual : "maxSumDivThree(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        for (int num : nums) {
            int[] currentDp = new int[3];
            System.arraycopy(dp, 0, currentDp, 0, 3);
            for (int sum : currentDp) {
                int updSum = sum + num;
                int reminder = updSum % 3;
                dp[reminder] = Math.max(dp[reminder], updSum);
            }
        }
        return dp[0];
    }

}