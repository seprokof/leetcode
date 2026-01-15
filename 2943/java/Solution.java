import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int[] in3, int[] in4, int expected) {}

        TestCase[] tests = {
                new TestCase(2, 1, new int[] { 2, 3 }, new int[] { 2 }, 4),
                new TestCase(1, 1, new int[] { 2 }, new int[] { 2 }, 4),
                new TestCase(2, 3, new int[] { 2, 3 }, new int[] { 2, 4 }, 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximizeSquareHoleArea(test.in1, test.in2, Arrays.copyOf(test.in3, test.in3.length),
                    Arrays.copyOf(test.in4, test.in4.length));
            assert test.expected == actual : "maximizeSquareHoleArea(%s, %s, %s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, Arrays.toString(test.in3), Arrays.toString(test.in4), actual, test.expected);
        }
    }

    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int len = 1;
        int maxHLen = len;
        for (int i = 1; i < hBars.length; i++) {
            if (hBars[i] == hBars[i - 1] + 1) {
                len++;
                maxHLen = Math.max(maxHLen, len);
            } else {
                len = 1;
            }
        }
        len = 1;
        int maxYLen = len;
        for (int i = 1; i < vBars.length; i++) {
            if (vBars[i] == vBars[i - 1] + 1) {
                len++;
                maxYLen = Math.max(maxYLen, len);
            } else {
                len = 1;
            }
        }
        int sideLen = Math.min(maxHLen, maxYLen) + 1;
        return sideLen * sideLen;
    }

}