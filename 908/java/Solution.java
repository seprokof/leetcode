import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1 }, 0, 0),
                new TestCase(new int[] { 0, 10 }, 2, 6),
                new TestCase(new int[] { 1, 3, 6 }, 3, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.smallestRangeI(test.in1, test.in2);
            assert test.expected == actual : "smallestRangeI(%s, %s) = %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public int smallestRangeI(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return Math.max(max - k - min - k, 0);
    }

}