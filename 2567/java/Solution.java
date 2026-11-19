import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 1, 4, 7, 8, 5 }, 3),
                new TestCase(new int[] { 1, 4, 3 }, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimizeSum(test.in);
            assert test.expected == actual : "minimizeSum(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int minimizeSum(int[] nums) {
        int min0 = Integer.MAX_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int max0 = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num <= min0) {
                min2 = min1;
                min1 = min0;
                min0 = num;
            } else if (num <= min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
            if (num >= max0) {
                max2 = max1;
                max1 = max0;
                max0 = num;
            } else if (num >= max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }
        return Math.min(max0 - min2, Math.min(max1 - min1, max2 - min0));
    }

}