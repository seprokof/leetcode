class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("01000111", 6),
                new TestCase("00111", 4),
                new TestCase("111", 0)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.findTheLongestBalancedSubstring(test.in);
            assert test.expected == actual : "findTheLongestBalancedSubstring('%s') = %s, want %s".formatted(test.in,
                    actual, test.expected);
        }
    }

    public int findTheLongestBalancedSubstring(String s) {
        int zeros = 0;
        int ones = 0;
        int maxStreak = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (ones > 0) {
                    maxStreak = Math.max(maxStreak, Math.min(zeros, ones));
                    zeros = 0;
                    ones = 0;
                }
                zeros++;
            } else {
                ones++;
            }
        }
        maxStreak = Math.max(maxStreak, Math.min(zeros, ones));
        return maxStreak * 2;
    }

}