import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[] { -5, 1, 5, 0, -7 }, 1),
                new TestCase(new int[] { -4, -3, -2, -1, 4, 3, 2 }, 0),
                new TestCase(new int[] { 52, -91, 72 }, 52)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.largestAltitude(test.in);
            assert test.expected == actual : "largestAltitude(%s) == %s, want %s".formatted(Arrays.toString(test.in),
                    actual, test.expected);
        }
    }

    public int largestAltitude(int[] gain) {
        int max = Math.max(gain[0], 0);
        for (int i = 1; i < gain.length; i++) {
            gain[i] += gain[i - 1];
            max = Math.max(max, gain[i]);
        }
        return max;
    }

}