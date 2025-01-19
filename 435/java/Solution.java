import java.util.Arrays;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(int[][] in, int expected) {}

        TestCase[] tests = {
                new TestCase(new int[][] { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 3 } }, 1),
                new TestCase(new int[][] { { 1, 2 }, { 1, 2 }, { 1, 2 } }, 2),
                new TestCase(new int[][] { { 1, 2 }, { 2, 3 } }, 0)};
        // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			int actual = s.eraseOverlapIntervals(test.in);
			assert test.expected == actual : "eraseOverlapIntervals(%s) == %s, want %s"
					.formatted(Arrays.deepToString(test.in), actual, test.expected);
		}
	}

	public int eraseOverlapIntervals(int[][] intervals) {
		Arrays.sort(intervals, (i1, i2) -> i1[1] - i2[1]);
		int previousIdx = 0;
		int deletedCount = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] < intervals[previousIdx][1]) {
				deletedCount++;
			} else {
				previousIdx = i;
			}
		}
		return deletedCount;
	}

}