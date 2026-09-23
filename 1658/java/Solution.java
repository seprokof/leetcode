import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 4, 2, 3 }, 5, 2),
                new TestCase(new int[] { 5, 6, 7, 8, 9 }, 4, -1),
                new TestCase(new int[] { 3, 2, 20, 1, 1, 3 }, 10, 5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minOperations(test.in1, test.in2);
            assert test.expected == actual : "minOperations(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int targetSum = sum - x;
        if (targetSum < 0) {
            return -1;
        } else if (targetSum == 0) {
            return nums.length;
        }
        sum = 0;
        int maxSubarrayLen = 0;
        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum > targetSum) {
                sum -= nums[left++];
            }
            if (sum == targetSum) {
                maxSubarrayLen = Math.max(maxSubarrayLen, right - left + 1);
            }
        }
        return maxSubarrayLen == 0 ? -1 : nums.length - maxSubarrayLen;
    }

}