import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 2, 5 }, 6),
                new TestCase(new int[] { 3, 4, 5, 1, 12, 14, 13 }, 15)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.missingInteger(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "missingInteger(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int missingInteger(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length && nums[i] == nums[i - 1] + 1; i++) {
            sum += nums[i];
        }
        int result = sum;
        while (contains(nums, result)) {
            result++;
        }
        return result;
    }

    private static boolean contains(int[] nums, int num) {
        if (num > 50) {
            return false;
        }
        for (int n : nums) {
            if (n == num) {
                return true;
            }
        }
        return false;
    }

}