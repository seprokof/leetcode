import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, new int[] { 1, 2, 4, 7, 5, 3, 6, 8, 9 }),
                new TestCase(new int[][] { { 1, 2 }, { 3, 4 } }, new int[] { 1, 2, 3, 4 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.findDiagonalOrder(test.in);
            assert Arrays.equals(test.expected, actual) : "findDiagonalOrder(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int colIdx = 0;
        int rowIdx = 0;
        boolean goDown = false;
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];
        for (int i = 0; i < result.length; i++) {
            result[i] = mat[rowIdx][colIdx];
            if (goDown) {
                if (rowIdx == m - 1) {
                    colIdx++;
                    goDown = false;
                } else if (colIdx == 0) {
                    rowIdx++;
                    goDown = false;
                } else {
                    colIdx--;
                    rowIdx++;
                }
            } else {
                if (colIdx == n - 1) {
                    rowIdx++;
                    goDown = true;
                } else if (rowIdx == 0) {
                    colIdx++;
                    goDown = true;
                } else {
                    colIdx++;
                    rowIdx--;
                }
            }
        }
        return result;
    }

}