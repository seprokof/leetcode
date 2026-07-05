import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(4, new int[][] { { 0, 0 }, { 1, 0 }, { 1, 0 }, { 2, 1 }, { 2, 1 }, { 2, 0 } }, 2),
                new TestCase(5, new int[][] { { 1, 1 }, { 1, 2 }, { 1, 3 }, { 1, 4 } }, 0),
                new TestCase(5, new int[][] { { 1, 1 }, { 2, 4 }, { 2, 4 }, { 2, 4 } }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.winningPlayerCount(test.in1, test.in2);
            assert test.expected == actual : "winningPlayerCount(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int winningPlayerCount(int n, int[][] pick) {
        int[][] frequency = new int[n][11];
        for (int[] p : pick) {
            frequency[p[0]][p[1]]++;
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int f : frequency[i]) {
                if (f > i) {
                    result++;
                    break;
                }
            }
        }
        return result;
    }

}