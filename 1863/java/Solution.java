import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3 }, 6),
                new TestCase(new int[] { 5, 1, 6 }, 28),
                new TestCase(new int[] { 3, 4, 5, 6, 7, 8 }, 480)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.subsetXORSum(test.in);
            assert test.expected == actual : "subsetXORSum(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int subsetXORSum(int[] nums) {
        return subsetXorSum(nums, 0, 0);
    }

    private int subsetXorSum(int[] nums, int idx, int subsetXor) {
        if (idx == nums.length) {
            return subsetXor;
        }
        return subsetXorSum(nums, idx + 1, subsetXor) + subsetXorSum(nums, idx + 1, subsetXor ^ nums[idx]);
    }

}