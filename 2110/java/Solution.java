import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { 3, 2, 1, 4 }, 7),
                new TestCase(new int[] { 8, 6, 7, 7 }, 4),
                new TestCase(new int[] { 1 }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.getDescentPeriods(test.in);
            assert test.expected == actual : "getDescentPeriods(%s) = %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public long getDescentPeriods(int[] prices) {
        long result = 1L;
        long periodDays = 1L;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] == prices[i - 1] - 1) {
                periodDays++;
            } else {
                periodDays = 1L;
            }
            result += periodDays;
        }
        return result;
    }

}