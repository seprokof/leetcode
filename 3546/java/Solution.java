import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 4 }, { 2, 3 } }, true),
                new TestCase(new int[][] { { 1, 3 }, { 2, 4 } }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.canPartitionGrid(test.in);
            assert test.expected == actual : "canPartitionGrid(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public boolean canPartitionGrid(int[][] grid) {
        long total = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                total += grid[row][col];
            }
        }
        if (total % 2 != 0) {
            return false;
        }
        long sum = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                sum += grid[row][col];
            }
            if (sum == total - sum) {
                return true;
            }
        }
        sum = 0;
        for (int col = 0; col < grid[0].length; col++) {
            for (int row = 0; row < grid.length; row++) {
                sum += grid[row][col];
            }
            if (sum == total - sum) {
                return true;
            }
        }
        return false;
    }

}