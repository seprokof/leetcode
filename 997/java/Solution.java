import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(2, new int[][] { { 1, 2 } }, 2),
                new TestCase(3, new int[][] { { 1, 3 }, { 2, 3 } }, 3),
                new TestCase(3, new int[][] { { 1, 3 }, { 2, 3 }, { 3, 1 } }, -1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findJudge(test.in1, test.in2);
            assert test.expected == actual : "findJudge(%s, %s) = %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int findJudge(int n, int[][] trust) {
        int[] trustCount = new int[n + 1];
        for (int[] t : trust) {
            trustCount[t[0]]--;
            trustCount[t[1]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (trustCount[i] == n - 1) {
                return i;
            }
        }
        return -1;
    }

}