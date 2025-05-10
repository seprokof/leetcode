import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int[] in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 2, 0, 1, 0 }, new int[] { 6, 5, 0 }, 12L),
                new TestCase(new int[] { 2, 0, 2, 0 }, new int[] { 1, 4 }, -1L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.minSum(test.in1, test.in2);
            assert test.expected == actual : "minSum(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    Arrays.toString(test.in2), actual, test.expected);
        }
    }

    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zero1Count = 0;
        for (int num : nums1) {
            sum1 += num;
            zero1Count += num == 0 ? 1 : 0;
        }
        long sum2 = 0;
        int zero2Count = 0;
        for (int num : nums2) {
            sum2 += num;
            zero2Count += num == 0 ? 1 : 0;
        }
        long minSum1 = sum1 + zero1Count;
        long minSum2 = sum2 + zero2Count;
        if ((minSum1 > minSum2 && zero2Count == 0) || (minSum2 > minSum1 && zero1Count == 0)) {
            return -1;
        }
        return Math.max(minSum1, minSum2);
    }

}