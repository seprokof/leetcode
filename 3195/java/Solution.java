import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 0, 1, 0 }, { 1, 0, 1 } }, 6),
                new TestCase(new int[][] { { 1, 0 }, { 0, 0 } }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minimumArea(test.in);
            assert test.expected == actual : "minimumArea(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public int minimumArea(int[][] grid) {
        int minY = -1;
        for (int rowIndex = 0; minY == -1; rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid[rowIndex].length; columnIndex++) {
                if (grid[rowIndex][columnIndex] == 1) {
                    minY = rowIndex;
                    break;
                }
            }
        }
        int maxY = -1;
        for (int rowIndex = grid.length - 1; maxY == -1; rowIndex--) {
            for (int columnIndex = 0; columnIndex < grid[rowIndex].length; columnIndex++) {
                if (grid[rowIndex][columnIndex] == 1) {
                    maxY = rowIndex;
                    break;
                }
            }
        }
        int minX = -1;
        for (int columnIndex = 0; minX == -1; columnIndex++) {
            for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
                if (grid[rowIndex][columnIndex] == 1) {
                    minX = columnIndex;
                    break;
                }
            }
        }
        int maxX = -1;
        for (int columnIndex = grid[0].length - 1; maxX == -1; columnIndex--) {
            for (int rowIndex = 0; rowIndex < grid.length; rowIndex++) {
                if (grid[rowIndex][columnIndex] == 1) {
                    maxX = columnIndex;
                    break;
                }
            }
        }
        return (maxX - minX + 1) * (maxY - minY + 1);
    }

}