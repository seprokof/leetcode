import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 2, 10, 5, 7 }, true),
                new TestCase(new int[] { 2, 3, 1, 2 }, false),
                new TestCase(new int[] { 1, 1, 1 }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canBeIncreasing(test.in);
            assert test.expected == actual : "canBeIncreasing(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public boolean canBeIncreasing(int[] nums) {
        int prevPrev = 0;
        int prev = nums[0];
        boolean alreadyRemoved = false;
        for (int i = 1; i < nums.length; i++) {
            if (prev >= nums[i]) {
                if (alreadyRemoved) {
                    return false;
                }
                alreadyRemoved = true;
                if (prevPrev < nums[i]) {
                    prev = nums[i];
                    prevPrev = 0;
                } else if (!(((i + 1) < nums.length && prev < nums[i + 1]) || (i + 1 == nums.length))) {
                    return false;
                }
            } else {
                prevPrev = prev;
                prev = nums[i];
            }
        }
        return true;
    }

}