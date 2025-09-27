import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, double expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 0, 2 }, { 2, 0 } }, 2.0),
                new TestCase(new int[][] { { 1, 0 }, { 0, 0 }, { 0, 1 } }, 0.5)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            double actual = s.largestTriangleArea(test.in);
            assert test.expected == actual : "largestTriangleArea(%s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public double largestTriangleArea(int[][] points) {
        double max = 0;
        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int t1 = points[j][1] - points[i][1];
                int t2 = points[i][0] - points[j][0];
                for (int k = j + 1; k < points.length; k++) {
                    double area = Math.abs(((points[i][0] - points[k][0]) * t1) - (t2 * (points[k][1] - points[i][1])))
                            / 2.0;
                    max = Math.max(max, area);
                }
            }
        }
        return max;
    }

}