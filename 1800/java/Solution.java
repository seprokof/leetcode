import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 10, 20, 30, 5, 10, 50 }, 65),
                new TestCase(new int[] { 10, 20, 30, 40, 50 }, 150),
                new TestCase(new int[] { 12, 17, 15, 13, 10, 11, 12 }, 33)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxAscendingSum(test.in);
            assert test.expected == actual : "maxAscendingSum(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int maxAscendingSum(int[] nums) {
        int sum = nums[0];
        int maxSum = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = nums[i - 1] < nums[i] ? sum + nums[i] : nums[i];
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }

}