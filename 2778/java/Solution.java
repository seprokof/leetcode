import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3, 4 }, 21),
                new TestCase(new int[] { 2, 7, 1, 19, 18, 3 }, 63)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sumOfSquares(test.in);
            assert test.expected == actual : "sumOfSquares(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                result += nums[i] * nums[i];
            }
        }
        return result;
    }

}