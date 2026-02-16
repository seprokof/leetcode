import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { -4, -2, 1, 4, 8 }, 1),
                new TestCase(new int[] { 2, -1, 1 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findClosestNumber(test.in);
            assert test.expected == actual : "findClosestNumber(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int findClosestNumber(int[] nums) {
        int minDiff = 100_001;
        int value = 100_001;
        for (int n : nums) {
            int diff = Math.abs(n);
            if (diff < minDiff || (diff == minDiff && value < n)) {
                minDiff = diff;
                value = n;
            }
        }
        return value;
    }

}