import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(char[][] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new char[][] { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'a', 'a', 'a' } }, true),
                new TestCase(new char[][] { { 'c', 'c', 'c', 'a' }, { 'c', 'd', 'c', 'c' }, { 'c', 'c', 'e', 'c' }, { 'f', 'c', 'c', 'c' } }, true),
                new TestCase(new char[][] { { 'a', 'b', 'b' }, { 'b', 'z', 'b' }, { 'b', 'b', 'a' } }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.containsCycle(test.in);
            assert test.expected == actual : "containsCycle(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited[row][col] && dfs(grid, visited, row, col, -1, -1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final int[][] DIRECTIONS = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    private static boolean dfs(char[][] grid, boolean[][] visited, int row, int col, int rowParent, int colParent) {
        visited[row][col] = true;
        for (int[] direction : DIRECTIONS) {
            int x = col + direction[0];
            int y = row + direction[1];
            if (y != rowParent || x != colParent) {
                if (y >= 0 && y < grid.length && x >= 0 && x < grid[0].length) {
                    if (grid[y][x] == grid[row][col]) {
                        if (visited[y][x] || dfs(grid, visited, y, x, row, col)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

}