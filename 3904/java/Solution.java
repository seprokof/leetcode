import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 5, 0, 1, 4 }, 3, 3),
                new TestCase(new int[] { 3, 2, 1 }, 1, -1),
                new TestCase(new int[] { 0 }, 0, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.firstStableIndex(test.in1, test.in2);
            assert test.expected == actual : "firstStableIndex(%s, %s) == %s, want %s"
                    .formatted(Arrays.toString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] mins = new int[n];
        mins[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            mins[i] = Math.min(mins[i + 1], nums[i]);
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            if (max - mins[i] <= k) {
                return i;
            }
        }
        return -1;
    }

}