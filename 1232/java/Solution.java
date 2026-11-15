import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 6, 7 } }, true),
                new TestCase(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 4 }, { 4, 5 }, { 5, 6 }, { 7, 7 } }, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkStraightLine(test.in);
            assert test.expected == actual : "checkStraightLine(%s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates.length == 2) {
            return true;
        }
        int[] p1 = coordinates[0];
        int[] p2 = coordinates[1];
        for (int i = 2; i < coordinates.length; i++) {
            int[] p3 = coordinates[i];
            if ((p2[1] - p1[1]) * (p3[0] - p1[0]) != (p3[1] - p1[1]) * (p2[0] - p1[0])) {
                return false;
            }
        }
        return true;
    }

}