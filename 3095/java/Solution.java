import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 2, 1),
                new TestCase(new int[] { 2, 1, 8 }, 10, 3),
                new TestCase(new int[] { 1, 2 }, 0, 1),
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumSubarrayLength(test.in1, test.in2);
            assert test.expected == actual : "minimumSubarrayLength(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int result = -1;
        for (int left = 0; left < nums.length; left++) {
            int orsVal = 0;
            for (int right = left; right < nums.length; right++) {
                orsVal |= nums[right];
                if (orsVal >= k) {
                    if (result > 0) {
                        result = Math.min(result, right - left + 1);
                    } else {
                        result = right - left + 1;
                    }
                    break;
                }
            }
        }
        return result;
    }

}