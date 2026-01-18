import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 7, 1, 4, 5, 6 }, { 2, 5, 1, 6, 4 }, { 1, 5, 4, 3, 2 }, { 1, 2, 7, 3, 4 } }, 3),
                new TestCase(new int[][] { { 5, 1, 3, 1 }, { 9, 3, 3, 1 }, { 1, 3, 3, 8 } }, 2),
                new TestCase(new int[][] { { 1,9,3,5,5,8,1,6,9 }, { 4,1,1,6,8,3,5,7,6 }, { 9,8,4,7,2,4,9,2,7 }, { 1,9,8,10,5,10,1,6,3 } }, 3)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.largestMagicSquare(test.in);
            assert test.expected == actual : "largestMagicSquare(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int largestMagicSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] prefixSumX = new int[m][n];
        for (int row = 0; row < m; row++) {
            prefixSumX[row][0] = grid[row][0];
            for (int col = 1; col < n; col++) {
                prefixSumX[row][col] = prefixSumX[row][col - 1] + grid[row][col];
            }
        }
        int[][] prefixSumY = new int[m][n];
        for (int col = 0; col < n; col++) {
            prefixSumY[0][col] = grid[0][col];
            for (int row = 1; row < m; row++) {
                prefixSumY[row][col] = prefixSumY[row - 1][col] + grid[row][col];
            }
        }
        int max = 1;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                int len = Math.min(m - row, n - col);
                for (int l = len; l > 0; l--) {
                    if (isMagicSquare(grid, prefixSumX, prefixSumY, col, row, l)) {
                        max = Math.max(max, l);
                        break;
                    }
                }

            }
        }
        return max;
    }

    private static boolean isMagicSquare(int[][] grid, int[][] prefixSumX, int[][] prefixSumY, int x, int y, int len) {
        int sum = prefixSumX[y][x + len - 1] - prefixSumX[y][x] + grid[y][x];
        for (int i = 0; i < len; i++) {
            if (prefixSumX[y + i][x + len - 1] - prefixSumX[y + i][x] + grid[y + i][x] != sum) {
                return false;
            }
        }
        for (int i = 0; i < len; i++) {
            if (prefixSumY[y + len - 1][x + i] - prefixSumY[y][x + i] + grid[y][x + i] != sum) {
                return false;
            }
        }
        int sumDiag1 = 0;
        int sumDiag2 = 0;
        for (int i = 0; i < len; i++) {
            sumDiag1 += grid[y + i][x + i];
            sumDiag2 += grid[y + len - 1 - i][x + i];
        }
        if (sumDiag1 != sumDiag2 || sumDiag1 != sum) {
            return false;
        }
        return true;
    }

}