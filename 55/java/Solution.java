import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 3, 1, 1, 4 }, true),
                new TestCase(new int[] { 3, 2, 1, 0, 4 }, false),
                new TestCase(new int[] { 2, 0, 0 }, true)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canJump(test.in);
            assert test.expected == actual : "canJump(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public boolean canJump(int[] nums) {
        return canJump(nums, nums.length - 1, new int[nums.length]);
    }

    private boolean canJump(int[] nums, int step, int[] cache) {
        for (int i = step - 1; i >= 0; i--) {
            if (nums[i] >= step - i) {
                if (cache[i] == 0) {
                    cache[i] = canJump(nums, i, cache) ? 1 : -1;
                }
                return cache[i] > 0;
            }
        }
        return step == 0;
    }

}