import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in1, int in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 3, 2 }, 2, 4L),
                new TestCase(new int[] { 4, 2, 5, 1 }, 3, 12L)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.maxTotalValue(test.in1, test.in2);
            assert test.expected == actual : "maxTotalValue(%s, %s) == %s, want %s".formatted(Arrays.toString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public long maxTotalValue(int[] nums, int k) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        return (max - min) * 1L * k;
    }

}