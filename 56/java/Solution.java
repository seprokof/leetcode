import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int[][] in, int[][] expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }, new int[][] { { 1, 6 }, { 8, 10 }, { 15, 18 } }),
                new TestCase(new int[][] { { 1, 4 }, { 4, 5 } }, new int[][] { { 1, 5 } })
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int[][] actual = s.merge(Arrays.copyOf(test.in, test.in.length));
            assert Arrays.deepEquals(test.expected, actual) : "merge(%s) == %s, want %s".formatted(
                    Arrays.deepToString(test.in), Arrays.deepToString(actual), Arrays.deepToString(test.expected));
        }
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (l, r) -> l[1] - r[1]);
        int j = intervals.length - 1;
        for (int i = intervals.length - 1; i > 0; i--) {
            if (intervals[j][0] <= intervals[i - 1][1]) {
                intervals[j][0] = Math.min(intervals[i - 1][0], intervals[j][0]);
            } else {
                j--;
                intervals[j] = intervals[i - 1];
            }
        }
        return Arrays.copyOfRange(intervals, j, intervals.length);
    }

}