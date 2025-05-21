import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[][] expected) {}
        
        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } }, new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } }),
                new TestCase(new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } }, new int[][] { { 0, 0, 0, 0 }, { 0, 4, 5, 0 }, { 0, 3, 1, 0 } })
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] copy = deepCopy(test.in);
            s.setZeroes(copy);
            assert Arrays.deepEquals(test.expected, copy) : "setZeroes(%s) -> %s, want %s".formatted(
                    Arrays.deepToString(test.in), Arrays.deepToString(copy), Arrays.deepToString(test.expected));
        }
    }

    private static int[][] deepCopy(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int i = 0; i < arr.length; i++) {
            copy[i] = Arrays.copyOf(arr[i], arr[i].length);
        }
        return copy;
    }

    public void setZeroes(int[][] matrix) {
        boolean zeroFirst = false;
        for (int y = 0; y < matrix.length; y++) {
            zeroFirst |= matrix[y][0] == 0;
            for (int x = 1; x < matrix[y].length; x++) {
                if (matrix[y][x] == 0) {
                    matrix[0][x] = 0;
                    matrix[y][0] = 0;
                }
            }
        }
        for (int y = matrix.length - 1; y >= 0; y--) {
            for (int x = matrix[y].length - 1; x >= 1; x--) {
                if (matrix[0][x] == 0 || matrix[y][0] == 0) {
                    matrix[y][x] = 0;
                }
            }
            if (zeroFirst) {
                matrix[y][0] = 0;
            }
        }
    }

}