import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, new int[][] { { 1, 4, 7 }, { 2, 5, 8 }, { 3, 6, 9 } }),
                new TestCase(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } }, new int[][] { { 1, 4 }, { 2, 5 }, { 3, 6 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.transpose(test.in);
            assert Arrays.deepEquals(test.expected, actual) : "transpose(%s) == %s, want %s".formatted(
                    Arrays.deepToString(test.in), Arrays.deepToString(actual), Arrays.deepToString(test.expected));
        }
    }

    public int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[j][i];
            }
        }
        return result;
    }

}