import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 0 }, { 0, 1 } }, 0),
                new TestCase(new int[][] { { 1, 0 }, { 1, 1 } }, 3),
                new TestCase(new int[][] { { 1, 1, 0, 0 }, { 0, 0, 1, 0 }, { 0, 0, 1, 0 }, { 0, 0, 0, 1 } }, 4)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countServers(test.in);
            assert test.expected == actual : "countServers(%s) == %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rc = new int[m];
        int[] cc = new int[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    rc[row]++;
                    cc[col]++;
                }
            }
        }
        int result = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1 && (rc[row] > 1 || cc[col] > 1)) {
                    result++;
                }
            }
        }
        return result;
    }

}