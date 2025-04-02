import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 12, 6, 1, 2, 7 }, 77L),
                new TestCase(new int[] { 1, 10, 3, 4, 19 }, 133L),
                new TestCase(new int[] { 1, 2, 3 }, 0L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.maximumTripletValue(test.in);
            assert test.expected == actual : "maximumTripletValue(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public long maximumTripletValue(int[] nums) {
        long result = 0L;
        long substractionMax = 0L;
        long iMax = 0L;
        for (int k = 0; k < nums.length; k++) {
            result = Math.max(result, substractionMax * nums[k]);
            substractionMax = Math.max(substractionMax, iMax - nums[k]);
            iMax = Math.max(iMax, nums[k]);
        }
        return result;
    }

}