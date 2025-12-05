import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 10, 10, 3, 7, 6 }, 4),
                new TestCase(new int[] { 1, 2, 2 }, 0),
                new TestCase(new int[] { 2, 4, 6, 8 }, 3),
                new TestCase(new int[] { 1, 1 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countPartitions(test.in);
            assert test.expected == actual : "countCollisions(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int countPartitions(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int prefixSum = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            prefixSum += nums[i];
            if ((prefixSum - (sum - prefixSum)) % 2 == 0) {
                result++;
            }
        }
        return result;
    }

}