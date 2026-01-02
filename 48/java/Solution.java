import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, new int[][] { { 7, 4, 1 }, { 8, 5, 2 }, { 9, 6, 3 } }),
                new TestCase(new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } }, new int[][] { { 15, 13, 2, 5 }, { 14, 3, 4, 1 }, { 12, 6, 8, 9 }, { 16, 7, 10, 11 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = deepCopy(test.in);
            s.rotate(actual);
            assert Arrays.deepEquals(test.expected, actual) : "rotate(%s) result %s, want %s".formatted(
                    Arrays.deepToString(test.in), Arrays.deepToString(actual), Arrays.deepToString(test.expected));
        }
    }

    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int row = 0; row < n; row++) {
            for (int col = row; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        for (int row = 0; row < n; row++) {
            int[] arr = matrix[row];
            for (int col = 0; col < n / 2; col++) {
                int temp = arr[col];
                arr[col] = arr[n - 1 - col];
                arr[n - 1 - col] = temp;
            }
        }
    }

}