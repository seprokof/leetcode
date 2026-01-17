import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in1, int[][] in2, long expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 1 }, { 2, 2 }, { 3, 1 } }, new int[][] { { 3, 3 }, { 4, 4 }, { 6, 6 } }, 1L),
                new TestCase(new int[][] { { 1, 1 }, { 1, 3 }, { 1, 5 } }, new int[][] { { 5, 5 }, { 5, 7 }, { 5, 9 } }, 4L),
                new TestCase(new int[][] { { 1, 1 }, { 2, 2 }, { 1, 2 } }, new int[][] { { 3, 3 }, { 4, 4 }, { 3, 4 } }, 1L),
                new TestCase(new int[][] { { 1, 1 }, { 3, 3 }, { 3, 1 } }, new int[][] { { 2, 2 }, { 4, 4 }, { 4, 2 } }, 0L)
        };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            long actual = s.largestSquareArea(test.in1, test.in2);
            assert test.expected == actual : "largestSquareArea(%s, %s) = %s, want %s"
                    .formatted(Arrays.deepToString(test.in1), Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int maxSideLen = 0;
        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = i + 1; j < bottomLeft.length; j++) {
                int xLen = Math.min(topRight[i][0], topRight[j][0]) - Math.max(bottomLeft[i][0], bottomLeft[j][0]);
                int yLen = Math.min(topRight[i][1], topRight[j][1]) - Math.max(bottomLeft[i][1], bottomLeft[j][1]);
                maxSideLen = Math.max(maxSideLen, Math.min(xLen, yLen));
            }
        }
        return 1L * maxSideLen * maxSideLen;
    }

}