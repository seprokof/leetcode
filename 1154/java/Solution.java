class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("2019-01-09", 9),
                new TestCase("2019-02-10", 41)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.dayOfYear(test.in);
            assert test.expected == actual : "dayOfYear('%s') == %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    private static final int[] DAYS_PER_MONTH = new int[] { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

    public int dayOfYear(String date) {
        int year = (date.charAt(0) - '0') * 1000 + (date.charAt(1) - '0') * 100 + (date.charAt(2) - '0') * 10
                + (date.charAt(3) - '0');
        int month = (date.charAt(5) - '0') * 10 + (date.charAt(6) - '0');
        int day = (date.charAt(8) - '0') * 10 + (date.charAt(9) - '0');
        int result = 0;
        for (int i = 0; i < month - 1; i++) {
            result += DAYS_PER_MONTH[i];
            if (i == 1 && isLeapYear(year)) {
                result += 1;
            }
        }
        return result + day;
    }

    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

}