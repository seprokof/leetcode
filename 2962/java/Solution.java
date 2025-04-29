import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 2, 3, 3 }, 2, 6L),
                new TestCase(new int[] { 1, 4, 2, 1 }, 3, 0L)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.countSubarrays(test.in1, test.in2);
            assert test.expected == actual : "countSubarrays(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public long countSubarrays(int[] nums, int k) {
        int left = 0;
        int max = Integer.MIN_VALUE;
        int count = 0;
        long result = 0L;
        for (int right = 0; right < nums.length; right++) {
            if (max < nums[right]) {
                max = nums[right];
                left = 0;
                count = 1;
                result = 0L;
            } else if (max == nums[right]) {
                count++;
            }
            while (count >= k) {
                result += nums.length - right;
                if (nums[left++] == max) {
                    count--;
                }
            }
        }
        return result;
    }

}