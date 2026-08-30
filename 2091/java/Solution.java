import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 2, 10, 7, 5, 4, 1, 8, 6 }, 5),
                new TestCase(new int[] { 0, -4, 19, 1, 8, -2, -3, 5 }, 3),
                new TestCase(new int[] { 101 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumDeletions(test.in);
            assert test.expected == actual : "minimumDeletions(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minimumDeletions(int[] nums) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int max = Integer.MIN_VALUE;
        int maxIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIdx = i;
            }
            if (nums[i] > max) {
                max = nums[i];
                maxIdx = i;
            }
        }
        int opt1 = Math.max(minIdx, maxIdx) + 1;
        int opt2 = nums.length - Math.min(minIdx, maxIdx);
        int opt3 = Math.min(minIdx, maxIdx) + 1 + nums.length - Math.max(minIdx, maxIdx);
        return Math.min(opt1, Math.min(opt2, opt3));
    }

}