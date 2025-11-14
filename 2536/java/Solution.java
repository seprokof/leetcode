import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(3, new int[][] { { 1, 1, 2, 2 }, { 0, 0, 1, 1 } }, new int[][] { { 1, 1, 0 }, { 1, 2, 1 }, { 0, 1, 1 } }),
                new TestCase(2, new int[][] { { 0, 0, 1, 1 } }, new int[][] { { 1, 1 }, { 1, 1 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.rangeAddQueries(test.in1, test.in2);
            assert Arrays.deepEquals(test.expected, actual) : "rangeAddQueries(%s, %s) = %s, want %s".formatted(
                    test.in1, Arrays.deepToString(test.in2), Arrays.deepToString(actual),
                    Arrays.deepToString(test.expected));
        }
    }

    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int[n + 1][n + 1];
        for (int[] query : queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];
            diff[row1][col1] += 1;
            diff[row2 + 1][col1] -= 1;
            diff[row1][col2 + 1] -= 1;
            diff[row2 + 1][col2 + 1] += 1;
        }
        int[][] mat = new int[n][n];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                int above = row == 0 ? 0 : mat[row - 1][col];
                int left = col == 0 ? 0 : mat[row][col - 1];
                int diagonal = row == 0 || col == 0 ? 0 : mat[row - 1][col - 1];
                mat[row][col] = diff[row][col] + above + left - diagonal;
            }
        }
        return mat;
    }

}