import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int[] in3, int[] in4, int expected) {}

        TestCase[] tests = {
                new TestCase(4, 3, new int[] { 2, 3 }, new int[] { 2 }, 4),
                new TestCase(6, 7, new int[] { 2 }, new int[] { 4 }, -1)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maximizeSquareArea(test.in1, test.in2, Arrays.copyOf(test.in3, test.in3.length),
                    Arrays.copyOf(test.in4, test.in4.length));
            assert test.expected == actual : "maximizeSquareArea(%s, %s, %s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, Arrays.toString(test.in3), Arrays.toString(test.in4), actual, test.expected);
        }
    }

    private static final int MODULO = 1_000_000_007;

    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        Set<Integer> hSideLens = new HashSet<>();
        for (int f : hFences) {
            hSideLens.add(f - 1);
            hSideLens.add(m - f);
        }
        hSideLens.add(m - 1);
        for (int i = 0; i < hFences.length; i++) {
            for (int j = i + 1; j < hFences.length; j++) {
                hSideLens.add(Math.abs(hFences[j] - hFences[i]));
            }
        }
        int len = -1;
        int maxSideLen = len;
        for (int f : vFences) {
            len = f - 1;
            if (hSideLens.contains(len)) {
                maxSideLen = Math.max(maxSideLen, len);
            }
            len = n - f;
            if (hSideLens.contains(len)) {
                maxSideLen = Math.max(maxSideLen, len);
            }
        }
        len = n - 1;
        if (hSideLens.contains(len)) {
            maxSideLen = Math.max(maxSideLen, len);
        }
        for (int i = 0; i < vFences.length; i++) {
            for (int j = i + 1; j < vFences.length; j++) {
                len = Math.abs(vFences[j] - vFences[i]);
                if (hSideLens.contains(len)) {
                    maxSideLen = Math.max(maxSideLen, len);
                }
            }
        }
        if (maxSideLen == -1) {
            return -1;
        }
        return (int) (1L * maxSideLen * maxSideLen % MODULO);
    }

}