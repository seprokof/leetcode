import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 0, 2, 1, 0, 0 }, { 0, 5, 0, 0, 5 }, { 0, 0, 1, 0, 0 }, { 0, 1, 4, 7, 0 }, { 0, 2, 0, 0, 8 } }, 5, 2),
                new TestCase(new int[][] { { 3, 0, 3, 0 }, { 0, 3, 0, 3 }, { 3, 0, 3, 0 } }, 3, 6)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countIslands(deepCopy(test.in1), test.in2);
            assert test.expected == actual : "countIslands(%s, %s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), test.in2, actual, test.expected);
        }
    }

    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    public int countIslands(int[][] grid, int k) {
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] > 0 && dfs(row, col, grid) % k == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    private static final int[][] DIRECTIONS = new int[][] { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };

    private static long dfs(int row, int col, int[][] grid) {
        long sum = grid[row][col];
        grid[row][col] = 0;
        for (int[] direction : DIRECTIONS) {
            int x = col + direction[0];
            int y = row + direction[1];
            if (x >= 0 && x < grid[0].length && y >= 0 && y < grid.length && grid[y][x] > 0) {
                sum += dfs(y, x, grid);
            }
        }
        return sum;
    }

}