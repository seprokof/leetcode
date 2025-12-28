class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("1001", false),
                new TestCase("110", true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkOnesSegment(test.in);
            assert test.expected == actual : "checkOnesSegment('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean checkOnesSegment(String s) {
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '1' && s.charAt(i - 1) == '0') {
                return false;
            }
        }
        return true;
    }

}