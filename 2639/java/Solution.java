import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1 }, { 22 }, { 333 } }, new int[] { 3 }),
                new TestCase(new int[][] { { -15, 1, 3 }, { 15, 7, 12 }, { 5, 6, -2 } }, new int[] { 3, 1, 2 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.findColumnWidth(test.in);
            assert Arrays.equals(test.expected, actual) : "findColumnWidth(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] findColumnWidth(int[][] grid) {
        int[] ans = new int[grid[0].length];
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                int tmp = grid[row][col];
                int len = 0;
                if (tmp == 0) {
                    len++;
                } else {
                    if (tmp < 0) {
                        len++;
                    }
                    while (tmp != 0) {
                        len++;
                        tmp /= 10;
                    }
                }
                ans[col] = Math.max(ans[col], len);
            }
        }
        return ans;
    }

}