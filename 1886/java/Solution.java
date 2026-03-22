import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int[][] in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 0, 1 }, { 1, 0 } }, new int[][] { { 1, 0 }, { 0, 1 } }, true),
                new TestCase(new int[][] { { 0, 1 }, { 1, 1 } }, new int[][] { { 1, 0 }, { 0, 1 } }, false),
                new TestCase(new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } }, new int[][] { { 1, 1, 1 }, { 0, 1, 0 }, { 0, 0, 0 } }, true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.findRotation(deepCopyOf(test.in1), test.in2);
            assert test.expected == actual : "findRotation(%s, %s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    private static int[][] deepCopyOf(int[][] arr) {
        int[][] copy = new int[arr.length][];
        for (int row = 0; row < arr.length; row++) {
            copy[row] = Arrays.copyOf(arr[row], arr[0].length);
        }
        return copy;
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        int[][] rotated;
        for (int i = 0; i < 4; i++) {
            rotated = new int[mat.length][mat.length];
            for (int row = 0; row < mat.length; row++) {
                for (int col = 0; col < mat.length; col++) {
                    rotated[mat.length - 1 - col][row] = mat[row][col];
                }
            }
            if (Arrays.deepEquals(rotated, target)) {
                return true;
            }
            mat = rotated;
        }
        return false;
    }

}