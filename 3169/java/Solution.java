import java.util.Arrays;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in1, int[][] in2, int expected) {}

        TestCase[] tests = {
                new TestCase(10, new int[][] { { 5, 7 }, { 1, 3 }, { 9, 10 } }, 2),
                new TestCase(5, new int[][] { { 2, 4 }, { 1, 3 } }, 1),
                new TestCase(6, new int[][] { { 1, 6 } }, 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countDays(test.in1, test.in2);
            assert test.expected == actual : "countDays(%s, %s) == %s, want %s".formatted(test.in1,
                    Arrays.deepToString(test.in2), actual, test.expected);
        }
    }

    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (l, r) -> l[0] - r[0]);
        int l = 0;
        int r = 1;
        int sum = 0;
        while (r < meetings.length) {
            if (meetings[l][1] >= meetings[r][0]) {
                meetings[l][0] = Math.min(meetings[l][0], meetings[r][0]);
                meetings[l][1] = Math.max(meetings[l][1], meetings[r][1]);
            } else {
                sum += meetings[l][1] - meetings[l][0] + 1;
                l = r;
            }
            r++;
        }
        sum += meetings[l][1] - meetings[l][0] + 1;
        return days - sum;
    }

}