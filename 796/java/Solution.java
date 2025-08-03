class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, boolean expected) {}

        TestCase[] tests = {
                new TestCase("abcde", "cdeab", true),
                new TestCase("abcde", "abced", false)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.rotateString(test.in1, test.in2);
            assert test.expected == actual : "rotateString('%s', '%s') = %s, want %s".formatted(test.in1, test.in2,
                    actual, test.expected);
        }
    }

    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == goal.charAt(0)) {
                String rotated = s.substring(i, s.length()) + s.substring(0, i);
                if (rotated.equals(goal)) {
                    return true;
                }
            }
        }
        return false;
    }

}