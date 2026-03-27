import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }, 4, false),
                new TestCase(new int[][] { { 1, 2, 1, 2 }, { 5, 5, 5, 5 }, { 6, 3, 6, 3 } }, 2, true),
                new TestCase(new int[][] { { 2, 2 }, { 2, 2 } }, 3, true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.areSimilar(test.in1, test.in2);
            assert test.expected == actual : "areSimilar(%s, %s) = %s, want %s".formatted(Arrays.deepToString(test.in1),
                    test.in2, actual, test.expected);
        }
    }

    public boolean areSimilar(int[][] mat, int k) {
        int n = mat[0].length;
        for (int row = 0; row < mat.length; row++) {
            for (int col = 0; col < n; col++) {
                if (mat[row][col] != mat[row][(col + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }

}