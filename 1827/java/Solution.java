import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 1 }, 3),
                new TestCase(new int[] { 1, 5, 2, 4, 1 }, 14),
                new TestCase(new int[] { 8 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in);
            assert test.expected == actual : "minOperations(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minOperations(int[] nums) {
        int target = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            target = Math.max(target + 1, nums[i]);
            result += (target - nums[i]);
        }
        return result;
    }

}