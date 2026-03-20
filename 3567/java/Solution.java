import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 8 }, { 3, -2 } }, 2, new int[][] { { 2 } }),
                new TestCase(new int[][] { { 3, -1 } }, 1, new int[][] { { 0, 0 } }),
                new TestCase(new int[][] { { 1, -2, 3 }, { 2, 3, 5 } }, 2, new int[][] { { 1, 2 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.minAbsDiff(test.in1, test.in2);
            assert Arrays.deepEquals(test.expected, actual) : "minAbsDiff(%s, %s) = %s, want %s".formatted(
                    Arrays.deepToString(test.in1), test.in2, Arrays.deepToString(actual),
                    Arrays.deepToString(test.expected));
        }
    }

    public int[][] minAbsDiff(int[][] grid, int k) {
        int[][] ans = new int[grid.length - k + 1][grid[0].length - k + 1];
        for (int row = 0; row < ans.length; row++) {
            for (int col = 0; col < ans[0].length; col++) {
                ans[row][col] = getMinDiff(grid, row, col, k);
            }
        }
        return ans;
    }

    private static int getMinDiff(int[][] grid, int i, int j, int k) {
        if (k == 1) {
            return 0;
        }
        int[] values = new int[k * k];
        for (int row = i, idx = 0; row < i + k; row++) {
            for (int col = j; col < j + k; col++, idx++) {
                values[idx] = grid[row][col];
            }
        }
        Arrays.sort(values);
        int minDiff = Integer.MAX_VALUE;
        for (int idx = 1; idx < values.length; idx++) {
            int diff = Math.abs(values[idx] - values[idx - 1]);
            if (diff > 0) {
                minDiff = Math.min(minDiff, diff);
            }
        }
        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }

}