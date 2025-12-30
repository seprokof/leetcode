import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 4, 3, 8, 4 }, { 9, 5, 1, 9 }, { 2, 7, 6, 2 } }, 1),
                new TestCase(new int[][] { { 8 } }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numMagicSquaresInside(test.in);
            assert test.expected == actual : "numMagicSquaresInsid(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int numMagicSquaresInside(int[][] grid) {
        int result = 0;
        for (int row = 0; row < grid.length - 2; row++) {
            for (int col = 0; col < grid[0].length - 2; col++) {
                if (isMagicSquare(grid, col, row)) {
                    result++;
                }
            }
        }
        return result;
    }

    private static boolean isMagicSquare(int[][] grid, int x, int y) {
        boolean[] seen = new boolean[10];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int val = grid[y + i][x + j];
                if (val < 1 || val > 9 || seen[val]) {
                    return false;
                }
                seen[val] = true;
            }
        }
        for (int i = 0; i < 3; i++) {
            if (grid[y + i][x] + grid[y + i][x + 1] + grid[y + i][x + 2] != 15) {
                return false;
            }
            if (grid[y][x + i] + grid[y + 1][x + i] + grid[y + 2][x + i] != 15) {
                return false;
            }
        }
        if (grid[y][x] + grid[y + 1][x + 1] + grid[y + 2][x + 2] != 15) {
            return false;
        }
        if (grid[y][x + 2] + grid[y + 1][x + 1] + grid[y + 2][x] != 15) {
            return false;
        }
        return true;
    }

}