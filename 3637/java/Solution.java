import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 5, 4, 2, 6 }, true),
                new TestCase(new int[] { 2, 1, 3 }, false)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isTrionic(test.in);
            assert test.expected == actual : "isTrionic(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public boolean isTrionic(int[] nums) {
        int extremes = 0;
        for (int i = 1; i < nums.length - 1 && extremes < 4; i++) {
            if ((nums[i - 1] > nums[i] && nums[i] < nums[i + 1]) || (nums[i - 1] < nums[i] && nums[i] > nums[i + 1])) {
                extremes++;
            } else if (nums[i - 1] == nums[i] || nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return extremes == 2 && nums[0] < nums[1];
    }

}