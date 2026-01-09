import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 1, 1, 1 }, 3, 5),
                new TestCase(new int[] { 1 }, 1, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findTargetSumWays(test.in1, test.in2);
            assert test.expected == actual : "findTargetSumWays(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int findTargetSumWays(int[] nums, int target) {
        return getNumWays(nums, target, 0);
    }

    private static int getNumWays(int[] nums, int target, int i) {
        if (i == nums.length) {
            return target == 0 ? 1 : 0;
        }
        return getNumWays(nums, target - nums[i], i + 1) + getNumWays(nums, target + nums[i], i + 1);
    }

}