import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 4 }, 3),
                new TestCase(new int[] { -5, -10, -5 }, 5)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxAdjacentDistance(test.in);
            assert test.expected == actual : "maxAdjacentDistance(%s) == %s, want %s"
                    .formatted(Arrays.toString(test.in), actual, test.expected);
        }
    }

    public int maxAdjacentDistance(int[] nums) {
        int result = Math.abs(nums[0] - nums[nums.length - 1]);
        for (int i = 0; i < nums.length - 1; i++) {
            result = Math.max(result, Math.abs(nums[i] - nums[i + 1]));
        }
        return result;
    }

}