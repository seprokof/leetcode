import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 3, 2, 2 }, 2),
                new TestCase(new int[] { 1, 2, 3, 4 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestSubarray(test.in);
            assert test.expected == actual : "longestSubarray(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int longestSubarray(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        int subResult = 0;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                result = Math.max(result, ++subResult);
            } else {
                subResult = 0;
            }
        }
        return result;
    }

}