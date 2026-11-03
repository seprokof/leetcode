import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 1, 3 }, 3),
                new TestCase(new int[] { 4, 4, 5 }, 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minMoves(test.in);
            assert test.expected == actual : "minMoves(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int minMoves(int[] nums) {
        int max = nums[0];
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                result += (nums[i] - max) * i;
                max = nums[i];
            } else {
                result += max - nums[i];
            }
        }
        return result;
    }

}