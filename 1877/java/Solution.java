import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 5, 2, 3 }, 7),
                new TestCase(new int[] { 3, 5, 4, 2, 4, 6 }, 8)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minPairSum(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "minPairSum(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int max = 0;
        for (int i = 0; i < n / 2; i++) {
            max = Math.max(max, nums[i] + nums[n - 1 - i]);
        }
        return max;
    }

}