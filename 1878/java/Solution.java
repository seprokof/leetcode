import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 3, 4, 5, 1, 3 }, { 3, 3, 4, 2, 3 }, { 20, 30, 200, 40, 10 }, { 1, 5, 5, 4, 1 }, { 4, 3, 2, 2, 5 } }, new int[] { 228, 216, 211 }),
                new TestCase(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, new int[] { 20, 9, 8 }),
                new TestCase(new int[][] { { 7, 7, 7 } }, new int[] { 7 })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[] actual = s.getBiggestThree(test.in);
            assert Arrays.equals(test.expected, actual) : "getBiggestThree(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), Arrays.toString(actual), Arrays.toString(test.expected));
        }
    }

    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] sums = new int[] { 0, 0, 0 };
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                updateMaxSums(sums, grid[row][col]);
                for (int len = 1; row + len * 2 < m && col - len >= 0 && col + len < n; len++) {
                    int sum = 0;
                    for (int i = 0; i < len; i++) {
                        sum += grid[row + i][col + i];
                        sum += grid[row + 2 * len - i][col - i];
                        sum += grid[row + len + i][col + len - i];
                        sum += grid[row + len - i][col - len + i];
                    }
                    updateMaxSums(sums, sum);
                }
            }
        }
        if (sums[1] == 0) {
            return new int[] { sums[0] };
        } else if (sums[2] == 0) {
            return new int[] { sums[0], sums[1] };
        } else {
            return sums;
        }
    }

    private static void updateMaxSums(int[] sums, int sum) {
        for (int i = 0; i < 3; i++) {
            if (sums[i] == sum) {
                return;
            }
            if (sums[i] < sum) {
                for (int j = 2; j > i; j--) {
                    sums[j] = sums[j - 1];
                }
                sums[i] = sum;
                return;
            }
        }
    }

}