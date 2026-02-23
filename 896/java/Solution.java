import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 2, 3 }, true),
                new TestCase(new int[] { 6, 5, 4, 4 }, true),
                new TestCase(new int[] { 1, 3, 2 }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isMonotonic(test.in);
            assert test.expected == actual : "isMonotonic(%s) = %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public boolean isMonotonic(int[] nums) {
        boolean isIncreasing = false;
        boolean isDecreasing = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                isDecreasing = true;
            } else if (nums[i - 1] < nums[i]) {
                isIncreasing = true;
            }
            if (isIncreasing && isDecreasing) {
                return false;
            }
        }
        return true;
    }

}