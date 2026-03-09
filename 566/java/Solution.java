import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, int in3, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2 }, { 3, 4 } }, 1, 4, new int[][] { { 1, 2, 3, 4 } }),
                new TestCase(new int[][] { { 1, 2 }, { 3, 4 } }, 2, 2, new int[][] { { 1, 2 }, { 3, 4 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.matrixReshape(test.in1, test.in2, test.in3);
            assert Arrays.deepEquals(test.expected, actual) : "matrixReshape(%s, %s, %s) = %s, want %s".formatted(
                    Arrays.deepToString(test.in1), test.in2, test.in3, Arrays.deepToString(actual),
                    Arrays.deepToString(test.expected));
        }
    }

    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m * n != r * c) {
            return mat;
        }
        int[][] result = new int[r][c];
        int seqIndex = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++, seqIndex++) {
                result[seqIndex / c][seqIndex % c] = mat[row][col];
            }
        }
        return result;
    }

}