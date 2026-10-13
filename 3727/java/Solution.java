import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 12L),
                new TestCase(new int[] { 1, -1, 2, -2, 3, -3 }, 16L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.maxAlternatingSum(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "maxAlternatingSum(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        long result = 0L;
        for (int i = 0; i < nums.length / 2; i++) {
            result += nums[nums.length - 1 - i] - nums[i];
        }
        if (nums.length % 2 != 0) {
            result += nums[nums.length / 2];
        }
        return result;
    }

}