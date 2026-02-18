class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(int in, boolean expected) {}

        TestCase[] tests = {
                new TestCase(5, true),
                new TestCase(7, false),
                new TestCase(11, false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.hasAlternatingBits(test.in);
            assert test.expected == actual : "hasAlternatingBits(%s) = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean hasAlternatingBits(int n) {
        int previousReminder = 2;
        while (n > 0) {
            int reminder = n % 2;
            if (reminder == previousReminder) {
                return false;
            } else {
                previousReminder = reminder;
            }
            n /= 2;
        }
        return true;
    }

}