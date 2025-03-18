import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 8, 48, 10 }, 3),
                new TestCase(new int[] { 3, 1, 5, 11, 13 }, 1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestNiceSubarray(test.in);
            assert test.expected == actual : "longestNiceSubarray(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int longestNiceSubarray(int[] nums) {
        int max = 1;
        int left = 0;
        int mask = 0;
        for (int right = 0; right < nums.length; right++) {
            while ((mask & nums[right]) != 0) {
                mask ^= nums[left++];
            }
            mask |= nums[right];
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

}