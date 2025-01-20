import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1 ,0, 1 }, 3),
                new TestCase(new int[] { 0, 1, 1, 1, 0, 1, 1, 0, 1 }, 5),
                new TestCase(new int[] { 1, 1, 1 }, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestSubarray(test.in);
            assert test.expected == actual : "longestSubarray(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int longestSubarray(int[] nums) {
        int start = 0;
        int end = 0;
        boolean zeroFound = false;
        int max = 0;
        for (; end < nums.length; end++) {
            if (nums[end] == 0) {
                if (zeroFound) {
                    max = Math.max(max, end - start - 1);
                    while (zeroFound) {
                        if (nums[start++] == 0) {
                            zeroFound = false;
                        }
                    }
                }
                zeroFound = true;
            }
        }
        return Math.max(max, end - start - 1);
    }

}