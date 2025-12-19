import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } }, 1),
                new TestCase(new int[][] { { 1, 0, 0 }, { 0, 1, 0 }, { 0, 0, 1 } }, 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numSpecial(test.in);
            assert test.expected == actual : "numSpecial(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int numSpecial(int[][] mat) {
        int[] rowCount = new int[mat.length];
        int[] colCount = new int[mat[0].length];
        for (int row = 0; row < rowCount.length; row++) {
            for (int col = 0; col < colCount.length; col++) {
                if (mat[row][col] == 1) {
                    rowCount[row]++;
                    colCount[col]++;
                }
            }
        }
        int result = 0;
        for (int row = 0; row < rowCount.length; row++) {
            for (int col = 0; col < colCount.length; col++) {
                if (mat[row][col] == 1 && rowCount[row] == 1 && colCount[col] == 1) {
                    result++;
                }
            }
        }
        return result;
    }

}