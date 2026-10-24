class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, String in3, String in4, int expected) {}

        TestCase[] tests = {
                new TestCase("08-15", "08-18", "08-16", "08-19", 3),
                new TestCase("10-01", "10-31", "11-01", "12-31", 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.countDaysTogether(test.in1, test.in2, test.in3, test.in4);
            assert test.expected == actual : "countDaysTogether('%s', '%s', '%s', '%s') == %s, want %s"
                    .formatted(test.in1, test.in2, test.in3, test.in4, actual, test.expected);
        }
    }

    private static final int[] PREF_SUM_DAYS = new int[] { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int aa = getDayOfYear(arriveAlice);
        int al = getDayOfYear(leaveAlice);
        int ba = getDayOfYear(arriveBob);
        int bl = getDayOfYear(leaveBob);
        return Math.max(Math.min(al, bl) - Math.max(aa, ba) + 1, 0);
    }

    private static int getDayOfYear(String date) {
        int m = Integer.valueOf(date.substring(0, 2));
        int d = Integer.valueOf(date.substring(3));
        return PREF_SUM_DAYS[m - 1] + d;
    }

}