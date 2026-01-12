import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1 }, { 3, 4 }, { -1, 0 } }, 7),
                new TestCase(new int[][] { { 3, 2 }, { -2, 2 } }, 5)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minTimeToVisitAllPoints(test.in);
            assert test.expected == actual : "minTimeToVisitAllPoints(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;
        for (int i = 1; i < points.length; i++) {
            int[] previous = points[i - 1];
            int[] current = points[i];
            result += Math.max(Math.abs(current[1] - previous[1]), Math.abs(current[0] - previous[0]));
        }
        return result;
    }

}