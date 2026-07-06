import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 4 }, { 3, 6 }, { 2, 8 } }, 2),
                new TestCase(new int[][] { { 1, 4 }, { 2, 3 } }, 1)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.removeCoveredIntervals(Arrays.copyOf(test.in, test.in.length));
            assert test.expected == actual : "removeCoveredIntervals(%s) == %s, want %s"
                    .formatted(Arrays.deepToString(test.in), actual, test.expected);
        }
    }

    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (l, r) -> l[0] == r[0] ? r[1] - l[1] : l[0] - r[0]);
        int maxEnd = 0;
        int result = 0;
        for (int[] interval : intervals) {
            if (interval[1] > maxEnd) {
                result++;
                maxEnd = interval[1];
            }
        }
        return result;
    }

}