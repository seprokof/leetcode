import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, List<List<Integer>> expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 1, List.of(List.of(9, 1, 2), List.of(3, 4, 5), List.of(6, 7, 8))),
                new TestCase(new int[][] { { 3, 8, 1, 9 }, { 19, 7, 2, 5 }, { 4, 6, 11, 10 }, { 12, 0, 21, 13 } }, 4, List.of(List.of(12, 0, 21, 13), List.of(3, 8, 1, 9), List.of(19, 7, 2, 5), List.of(4, 6, 11, 10)))
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            List<List<Integer>> actual = s.shiftGrid(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "shiftGrid(%s, %s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), test.in2, actual, test.expected);
        }
    }

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;
        int[] flat = new int[size];
        for (int i = 0, row = 0; row < m; row++) {
            for (int col = 0; col < n; col++, i++) {
                flat[i] = grid[row][col];
            }
        }
        List<List<Integer>> result = new ArrayList<>(m);
        for (int row = 0; row < m; row++) {
            List<Integer> r = new ArrayList<>(n);
            for (int i = row * n + size - k % size, col = 0; col < n; col++, i++) {
                r.add(flat[i % size]);
            }
            result.add(r);
        }
        return result;
    }

}