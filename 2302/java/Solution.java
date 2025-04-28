import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, long in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 4, 3, 5 }, 10L, 6L),
                new TestCase(new int[] { 1, 1, 1 }, 5L, 5L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.countSubarrays(test.in1, test.in2);
            assert test.expected == actual : "countSubarrays(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public long countSubarrays(int[] nums, long k) {
        long sum = 0L;
        int left = 0;
        long result = 0L;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum * (right - left + 1) >= k) {
                sum -= nums[left++];
            }
            result += (right - left + 1);
        }
        return result;
    }

}