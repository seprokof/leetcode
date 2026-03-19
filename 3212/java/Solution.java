import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(char[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new char[][] { { 'X', 'Y', '.' }, { 'Y', '.', '.' } }, 3),
                new TestCase(new char[][] { { 'X', 'X' }, { 'X', 'Y' } }, 0),
                new TestCase(new char[][] { { '.', '.' }, { '.', '.' } }, 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.numberOfSubmatrices(test.in);
            assert test.expected == actual : "numberOfSubmatrices(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int numberOfSubmatrices(char[][] grid) {
        int[] sumX = new int[grid[0].length];
        int[] sumY = new int[grid[0].length];
        int result = 0;
        for (int row = 0; row < grid.length; row++) {
            int x = 0;
            int y = 0;
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 'X') {
                    x++;
                } else if (grid[row][col] == 'Y') {
                    y++;
                }
                sumX[col] += x;
                sumY[col] += y;
                if (sumX[col] > 0 && sumX[col] == sumY[col]) {
                    result++;
                }
            }
        }
        return result;
    }

}