import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1 }, { 2, 3 }, { 3, 2 } }, true),
                new TestCase(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 3 } }, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.isBoomerang(test.in);
            assert test.expected == actual : "isBoomerang(%s) = %s, want %s".formatted(Arrays.deepToString(test.in),
                    actual, test.expected);
        }
    }

    public boolean isBoomerang(int[][] points) {
        // S = 1/2 * | x1(y2 - y3) + x2(y3 - y1) + x3(y1 - y2) |
        return points[0][0] * (points[1][1] - points[2][1]) + points[1][0] * (points[2][1] - points[0][1])
                + points[2][0] * (points[0][1] - points[1][1]) != 0;
    }

}