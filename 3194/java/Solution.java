import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, double expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 7, 8, 3, 4, 15, 13, 4, 1 }, 5.5),
                new TestCase(new int[] { 1, 9, 8, 3, 10, 5 }, 5.5),
                new TestCase(new int[] { 1, 2, 3, 7, 8, 9 }, 5.0)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            double actual = s.minimumAverage(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "minimumAverage(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < n / 2; i++) {
            min = Math.min(min, (nums[i] + nums[n - 1 - i]) / 2.0);
        }
        return min;
    }

}