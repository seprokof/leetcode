import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int in2, int[][] in3, int[][] in4, int expected) {}

        TestCase[] tests = {
                new TestCase(4, 6, new int[][] { { 0, 0 }, { 1, 1 },  { 2, 3 } }, new int[][] { { 0, 1 }, { 2, 2 }, { 1, 4 } }, 7),
                new TestCase(3, 3, new int[][] { { 1, 1 } }, new int[][] { { 0, 1 }, { 1, 0 }, { 2, 1 },  { 1, 2 } }, 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countUnguarded(test.in1, test.in2, test.in3, test.in4);
            assert test.expected == actual : "countUnguarded(%s, %s, %s, %s) = %s, want %s".formatted(test.in1,
                    test.in2, Arrays.deepToString(test.in3), Arrays.deepToString(test.in4), actual, test.expected);
        }
    }

    private static final int UNGUARDED = 0;
    private static final int WALL = 1;
    private static final int GUARD = 2;
    private static final int GUARDED = 3;

    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = GUARD;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = WALL;
        }
        for (int[] guard : guards) {
            int guardRow = guard[0];
            int guardCol = guard[1];
            for (int i = guardCol - 1; i >= 0 && grid[guardRow][i] != WALL && grid[guardRow][i] != GUARD; i--) {
                grid[guardRow][i] = GUARDED;
            }
            for (int i = guardCol + 1; i < n && grid[guardRow][i] != WALL && grid[guardRow][i] != GUARD; i++) {
                grid[guardRow][i] = GUARDED;
            }
            for (int i = guardRow - 1; i >= 0 && grid[i][guardCol] != WALL && grid[i][guardCol] != GUARD; i--) {
                grid[i][guard[1]] = GUARDED;
            }
            for (int i = guardRow + 1; i < m && grid[i][guardCol] != WALL && grid[i][guardCol] != GUARD; i++) {
                grid[i][guardCol] = GUARDED;
            }
        }
        int result = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == UNGUARDED) {
                    result++;
                }
            }
        }
        return result;
    }

}