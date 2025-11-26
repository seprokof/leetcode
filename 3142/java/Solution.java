import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 0, 2 }, { 1, 0, 2 } }, true),
                new TestCase(new int[][] { { 1, 1, 1 }, { 0, 0, 0 } }, false),
                new TestCase(new int[][] { { 1 }, { 2 }, { 3 } }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.satisfiesConditions(test.in);
            assert test.expected == actual : "satisfiesConditions(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public boolean satisfiesConditions(int[][] grid) {
        for (int i = 1; i < grid[0].length; i++) {
            if (grid[0][i] == grid[0][i - 1]) {
                return false;
            }
        }
        int[] row = grid[0];
        for (int i = 1; i < grid.length; i++) {
            if (!Arrays.equals(row, grid[i])) {
                return false;
            }
        }
        return true;
    }

}