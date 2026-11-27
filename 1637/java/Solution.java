import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 8, 7 }, { 9, 9 }, { 7, 4 }, { 9, 7 } }, 1),
                new TestCase(new int[][] { { 3, 1 }, { 9, 0 }, { 1, 0 }, { 1, 4 }, { 5, 3 }, { 8, 8 } }, 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxWidthOfVerticalArea(test.in);
            assert test.expected == actual : "maxWidthOfVerticalArea(%s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int maxWidthOfVerticalArea(int[][] points) {
        int[] x = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            result = Math.max(result, x[i] - x[i - 1]);
        }
        return result;
    }

}