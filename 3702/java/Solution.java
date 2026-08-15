import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 2),
                new TestCase(new int[] { 2, 3, 4 }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestSubsequence(test.in);
            assert test.expected == actual : "longestSubsequence(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int longestSubsequence(int[] nums) {
        int totalXor = 0;
        boolean hasPositive = false;
        for (int num : nums) {
            totalXor ^= num;
            if (num > 0) {
                hasPositive = true;
            }
        }
        if (totalXor > 0) {
            return nums.length;
        }
        if (hasPositive) {
            return nums.length - 1;
        }
        return 0;
    }

}