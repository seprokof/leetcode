import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, int in3, int in4, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }, 1, 0, 3, new int[][] { { 1, 2, 3, 4 }, { 13, 14, 15, 8 }, { 9, 10, 11, 12 }, { 5, 6, 7, 16 } }),
                new TestCase(new int[][] { { 3, 4, 2, 3 }, { 2, 3, 4, 2 } }, 0, 2, 2, new int[][] { { 3, 4, 4, 2 }, { 2, 3, 2, 3 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.reverseSubmatrix(deepCopyOf(test.in1), test.in2, test.in3, test.in4);
            assert Arrays.deepEquals(test.expected, actual) : "reverseSubmatrix(%s, %s, %s, %s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), test.in2, test.in3, test.in4, Arrays.deepToString(actual),
                            Arrays.deepToString(test.expected));
        }
    }

    private static int[][] deepCopyOf(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int row = 0; row < arr.length; row++) {
            copy[row] = Arrays.copyOf(arr[row], arr[0].length);
        }
        return copy;
    }

    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int row = 0; row < k / 2; row++) {
            for (int col = y; col < y + k; col++) {
                int temp = grid[x + row][col];
                grid[x + row][col] = grid[x + k - 1 - row][col];
                grid[x + k - 1 - row][col] = temp;
            }
        }
        return grid;
    }

}