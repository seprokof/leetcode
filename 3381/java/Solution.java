import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2 }, 1, 3L),
                new TestCase(new int[] { -1, -2, -3, -4, -5 }, 4, -10L),
                new TestCase(new int[] { -5, 1, 2, -3, 4 }, 2, 4L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.maxSubarraySum(test.in1, test.in2);
            assert test.expected == actual : "maxSubarraySum(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public long maxSubarraySum(int[] nums, int k) {
        long[] minPrefix = new long[k];
        Arrays.fill(minPrefix, Long.MAX_VALUE / 2);
        minPrefix[k - 1] = 0;
        long prefixSum = 0;
        long result = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            int rem = i % k;
            result = Math.max(result, prefixSum - minPrefix[rem]);
            minPrefix[rem] = Math.min(prefixSum, minPrefix[rem]);
        }
        return result;
    }

}