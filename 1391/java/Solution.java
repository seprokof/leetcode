import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 2, 4, 3 }, { 6, 5, 2 } }, true),
                new TestCase(new int[][] { { 1, 2, 1 }, { 1, 2, 1 } }, false),
                new TestCase(new int[][] { { 1, 1, 2 } }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.hasValidPath(test.in);
            assert test.expected == actual : "hasValidPath(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public boolean hasValidPath(int[][] grid) {
        if (grid.length == 1 && grid[0].length == 1) {
            return true;
        }
        int[] starts = START[grid[0][0] - 1];
        return visit(grid, starts[0]) || visit(grid, starts[1]);
    }

    private static final int[][] START = { { 1, 3 }, { 0, 2 }, { 2, 3 }, { 1, 2 }, { 0, 3 }, { 0, 1 } };
    private static final int[][] DIRECTIONS = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };
    private static final int[][] TRANSITIONS = { { -1, 1, -1, 3 }, { 0, -1, 2, -1 }, { 3, 2, -1, -1 }, { 1, -1, -1, 2 },
            { -1, 0, 3, -1 }, { -1, -1, 1, 0 } };

    private boolean visit(int[][] grid, int direction) {
        int m = grid.length;
        int n = grid[0].length;
        int row = DIRECTIONS[direction][0];
        int col = DIRECTIONS[direction][1];
        while (row >= 0 && row < grid.length && col >= 0 && col < n) {
            direction = TRANSITIONS[grid[row][col] - 1][direction];
            if (direction == -1 || row == 0 && col == 0) {
                return false;
            }
            if (row == m - 1 && col == n - 1) {
                return true;
            }
            row += DIRECTIONS[direction][0];
            col += DIRECTIONS[direction][1];
        }
        return false;
    }

}