import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 7, 3 }, { 9, 8, 2 }, { 4, 5, 6 } }, new int[][] { { 8, 2, 3 }, { 9, 6, 7 }, { 4, 5, 1 } }),
                new TestCase(new int[][] { { 0, 1 }, { 1, 2 } }, new int[][] { { 2, 1 }, { 1, 0 } }),
                new TestCase(new int[][] { { 1 } }, new int[][] { { 1 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.sortMatrix(deepCopy(test.in));
            assert Arrays.deepEquals(test.expected, actual) : "sortMatrix(%s) = %s, want %s".formatted(
                    Arrays.deepToString(test.in), Arrays.deepToString(actual), Arrays.deepToString(test.expected));
        }
    }

    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    public int[][] sortMatrix(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            sortDiagonal(grid, i, 0);
        }
        for (int i = 1; i < grid.length; i++) {
            sortDiagonal(grid, 0, i);
        }
        return grid;
    }

    private void sortDiagonal(int[][] grid, int row, int col) {
        List<Integer> values = new ArrayList<>();
        for (int i = col, j = row; i < grid.length && j < grid.length; i++, j++) {
            values.add(grid[j][i]);
        }
        if (row < col) {
            Collections.sort(values);
        } else {
            Collections.sort(values, Collections.reverseOrder());
        }
        for (int i = col, j = row, k = 0; i < grid.length && j < grid.length; i++, j++, k++) {
            grid[j][i] = values.get(k);
        }
    }

}