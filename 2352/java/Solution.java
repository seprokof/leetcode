import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 3, 2, 1 }, { 1, 7, 6 }, { 2, 7, 7 } }, 1),
                new TestCase(new int[][] { { 3, 1, 2, 2 }, { 1, 4, 4, 5 }, { 2, 4, 2, 2 }, { 2, 4, 2, 2 } }, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.equalPairs(test.in);
            assert test.expected == actual : "equalPairs(%s) == %s, want %s".formatted(Arrays.toString(test.in), actual,
                    test.expected);
        }
    }

    public int equalPairs(int[][] grid) {
        int count = 0;
        for (int colIdx = 0; colIdx < grid.length; colIdx++) {
            int[] column = new int[grid.length];
            for (int rowIdx = 0; rowIdx < grid.length; rowIdx++) {
                column[rowIdx] = grid[rowIdx][colIdx];
            }
            for (int[] row : grid) {
                System.out.println(Arrays.toString(row));
                if (Arrays.equals(column, row)) {
                    count++;
                }
            }
        }
        return count;
    }

}