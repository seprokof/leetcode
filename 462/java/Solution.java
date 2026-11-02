import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 3 }, 2),
                new TestCase(new int[] { 1, 10, 2, 9 }, 16)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minMoves2(test.in);
            assert test.expected == actual : "minMoves2(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int median;
        if (nums.length % 2 == 0) {
            median = (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2;
        } else {
            median = nums[nums.length / 2];
        }
        int result = 0;
        for (int num : nums) {
            result += Math.abs(num - median);
        }
        return result;
    }

}