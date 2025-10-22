import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } }, 8),
                new TestCase(new int[][] { { 3, 2 }, { 1, 0 } }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countNegatives(test.in);
            assert test.expected == actual : "countNegatives(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    count += grid[0].length - j;
                    break;
                }
            }
        }
        return count;
    }

}