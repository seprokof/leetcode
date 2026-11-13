import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 23, 55, 42, 21 }, 2355),
                new TestCase(new int[] { 34, 7, 11, 11 }, 347),
                new TestCase(new int[] { 9, 20 }, 920)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minMergedInteger(test.in);
            assert test.expected == actual : "minMergedInteger(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minMergedInteger(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i += 2) {
            int second = nums[i];
            int multiplier;
            if (second > 999) {
                multiplier = 10000;
            } else if (second > 99) {
                multiplier = 1000;
            } else if (second > 9) {
                multiplier = 100;
            } else {
                multiplier = 10;
            }
            min = Math.min(min, nums[i - 1] * multiplier + second);
        }
        return min;
    }

}