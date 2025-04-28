import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 1, 2, 2, 3, 3 }, 3),
                new TestCase(new int[] { 1, 1, 2, 3 }, 2),
                new TestCase(new int[] { 6, 6, 6, 6 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countSubarrays(test.in);
            assert test.expected == actual : "countSubarrays(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int countSubarrays(int[] nums) {
        int result = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i - 1] / 2 == nums[i] + nums[i - 2]) {
                result++;
            }
        }
        return result;
    }

}