import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 4, 1, 1, 6, 5 }, 3),
                new TestCase(new int[] { 6, 6, 5, 5, 4, 1 }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countHillValley(test.in);
            assert test.expected == actual : "countHillValley(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int countHillValley(int[] nums) {
        int result = 0;
        int left = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }
            if ((left > nums[i] && nums[i] < nums[i + 1]) || (left < nums[i] && nums[i] > nums[i + 1])) {
                result++;
            }
            left = nums[i];
        }
        return result;
    }

}