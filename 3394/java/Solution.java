import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase(5, new int[][] { { 1, 0, 5, 2 }, { 0, 2, 2, 4 }, { 3, 2, 5, 3 }, { 0, 4, 4, 5 } }, true),
                new TestCase(4, new int[][] { { 0, 0, 1, 1 }, { 2, 0, 3, 4 }, { 0, 2, 2, 3 }, { 3, 0, 4, 3 } }, true),
                new TestCase(4, new int[][] { { 0, 2, 2, 4 }, { 1, 0, 3, 2 }, { 2, 2, 3, 4 }, { 3, 0, 4, 2 }, { 3, 2, 4, 4 } }, false)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkValidCuts(test.in1, test.in2);
            assert test.expected == actual : "checkValidCuts(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public boolean checkValidCuts(int n, int[][] rectangles) {
        List<int[]> xIntervals = new ArrayList<>();
        List<int[]> yIntervals = new ArrayList<>();
        for (int[] rectangle : rectangles) {
            xIntervals.add(new int[] { rectangle[0], rectangle[2] });
            yIntervals.add(new int[] { rectangle[1], rectangle[3] });
        }
        return isValidCuts(xIntervals) || isValidCuts(yIntervals);
    }

    private static boolean isValidCuts(List<int[]> intervals) {
        Collections.sort(intervals, (l, r) -> l[0] - r[0]);
        int l = 0;
        int r = 1;
        int piecesCount = 1;
        while (r < intervals.size() && piecesCount < 3) {
            int[] left = intervals.get(l);
            int[] right = intervals.get(r);
            if (left[1] > right[0]) {
                left[1] = Math.max(left[1], right[1]);
            } else {
                piecesCount++;
                l = r;
            }
            r++;
        }
        return piecesCount == 3;
    }

}