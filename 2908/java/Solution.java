import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 8, 6, 1, 5, 3 }, 9),
                new TestCase(new int[] { 5, 4, 8, 7, 10, 2 }, 13),
                new TestCase(new int[] { 6, 5, 4, 3, 4, 5 }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumSum(test.in);
            assert test.expected == actual : "minimumSum(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int minimumSum(int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                if (nums[i] < nums[j]) {
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] < nums[j]) {
                            result = Math.min(result, nums[i] + nums[j] + nums[k]);
                        }
                    }
                }
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

}