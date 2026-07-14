import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 0, 0, 2, 0, 1 }, 2),
                new TestCase(new int[] { 1, 0, 1, 0 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minAbsoluteDifference(test.in);
            assert test.expected == actual : "minAbsoluteDifference(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int minAbsoluteDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == 3) {
                    min = Math.min(min, j - i);
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}