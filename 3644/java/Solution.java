import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 0, 3, 2, 1 }, 1),
                new TestCase(new int[] { 0, 1, 3, 2 }, 2),
                new TestCase(new int[] { 3, 2, 1, 0 }, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.sortPermutation(test.in);
            assert test.expected == actual : "sortPermutation(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int sortPermutation(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                result &= nums[i];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}