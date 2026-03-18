import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 7, 6, 3 }, { 6, 6, 1 } }, 18, 4),
                new TestCase(new int[][] { { 7, 2, 9 }, { 1, 5, 0 }, { 2, 6, 6 } }, 20, 6)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countSubmatrices(test.in1, test.in2);
            assert test.expected == actual : "countSubmatrices(%s, %s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), test.in2, actual, test.expected);
        }
    }

    public int countSubmatrices(int[][] grid, int k) {
        int[] colSum = new int[grid[0].length];
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            int rowSum = 0;
            for (int col = 0; col < grid[0].length; col++) {
                colSum[col] += grid[row][col];
                rowSum += colSum[col];
                if (rowSum <= k) {
                    result++;
                }
            }
        }
        return result;
    }

}