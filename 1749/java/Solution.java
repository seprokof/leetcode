import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, -3, 2, 3, -4 }, 5),
                new TestCase(new int[] { 2, -5, 1, -4, 3, -2 }, 8)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxAbsoluteSum(test.in);
            assert test.expected == actual : "maxAbsoluteSum(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int maxAbsoluteSum(int[] nums) {
        int sum = 0;
        int maxSum = 0;
        int minSum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
            if (sum < minSum) {
                minSum = sum;
            }
        }
        return maxSum - minSum;
    }

}