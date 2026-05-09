import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 40, 10 }, { 30, 20 } }, 1, new int[][] { { 10, 20 }, { 40, 30 } }),
                new TestCase(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }, 2, new int[][] { { 3, 4, 8, 12 }, { 2, 11, 10, 16 }, { 1, 7, 6, 15 }, { 5, 9, 13, 14 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.rotateGrid(test.in1, test.in2);
            assert Arrays.deepEquals(test.expected, actual) : "rotateGrid(%s, %s) = %s, want %s".formatted(
                    Arrays.deepToString(test.in1), test.in2, Arrays.deepToString(actual),
                    Arrays.deepToString(test.expected));
        }
    }

    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < Math.min(m, n) / 2; i++) {
            List<Integer> values = new ArrayList<>();
            for (int j = i; j < n - i; j++) {
                values.add(grid[i][j]);
            }
            for (int j = i + 1; j < m - i; j++) {
                values.add(grid[j][n - i - 1]);
            }
            for (int j = n - i - 2; j >= i; j--) {
                values.add(grid[m - i - 1][j]);
            }
            for (int j = m - i - 2; j > i; j--) {
                values.add(grid[j][i]);
            }
            Collections.rotate(values, -k % values.size());
            int l = 0;
            for (int j = i; j < n - i; j++) {
                grid[i][j] = values.get(l++);
            }
            for (int j = i + 1; j < m - i; j++) {
                grid[j][n - i - 1] = values.get(l++);
            }
            for (int j = n - i - 2; j >= i; j--) {
                grid[m - i - 1][j] = values.get(l++);
            }
            for (int j = m - i - 2; j > i; j--) {
                grid[j][i] = values.get(l++);
            }
        }
        return grid;
    }

}
