import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 4, 2, 3 }, 1, 5),
                new TestCase(new int[] { 3, -1, 0, 2 }, 3, 6),
                new TestCase(new int[] { 2, -3, -1, 5, -4 }, 2, 13)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.largestSumAfterKNegations(Arrays.copyOf(test.in1, test.in1.length), test.in2);
            assert test.expected == actual : "largestSumAfterKNegations(%s, %s) = %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int sum = 0;
        int minAbs = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (k > 0 && nums[i] <= 0) {
                sum += -nums[i];
                k--;
                minAbs = Math.min(minAbs, -nums[i]);
            } else if (k > 0) {
                sum += nums[i];
                k = k % 2;
                minAbs = Math.min(minAbs, nums[i]);
            } else {
                sum += nums[i];
            }
        }
        if (k > 0) {
            sum -= 2 * minAbs;
        }
        return sum;
    }

}