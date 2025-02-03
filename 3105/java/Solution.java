import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 4, 3, 3, 2 }, 2),
                new TestCase(new int[] { 3, 3, 3, 3 }, 1),
                new TestCase(new int[] { 3, 2, 1 }, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestMonotonicSubarray(test.in);
            assert test.expected == actual : "longestMonotonicSubarray(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int inc = 1;
        int dec = 1;
        for (int i = 1; i < nums.length; i++) {
            inc = nums[i - 1] < nums[i] ? ++inc : 1;
            dec = nums[i - 1] > nums[i] ? ++dec : 1;
            max = Math.max(max, Math.max(inc, dec));
        }
        return max;
    }

}