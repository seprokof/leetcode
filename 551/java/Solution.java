class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("PPALLP", true),
                new TestCase("PPALLL", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkRecord(test.in);
            assert test.expected == actual : "checkRecord('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean checkRecord(String s) {
        int absent = 0;
        boolean lateStreak = false;
        for (int i = 0; i < s.length() && i < 2; i++) {
            if (s.charAt(i) == 'A') {
                absent++;
            }
        }
        for (int i = 2; i < s.length() && absent < 2 && !lateStreak; i++) {
            if (s.charAt(i) == 'A') {
                absent++;
            } else if (s.charAt(i) == 'L' && s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') {
                lateStreak = true;
            }
        }
        return absent < 2 && !lateStreak;
    }

}