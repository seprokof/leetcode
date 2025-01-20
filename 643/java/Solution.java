import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, double expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 12, -5, -6, 50, 3 }, 4, 12.75),
                new TestCase(new int[] { 5 }, 1, 5)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            double actual = s.findMaxAverage(test.in1, test.in2);
            assert test.expected == actual : "findMaxAverage(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = 1; i < nums.length - k + 1; i++) {
            sum = sum - nums[i - 1] + nums[i + k - 1];
            max = Math.max(max, sum);
        }
        return (double) max / k;
    }

}