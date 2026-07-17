class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("aaabbb", true),
                new TestCase("abab", false),
                new TestCase("bbb", true)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            boolean actual = s.checkString(test.in);
            assert test.expected == actual : "checkString('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public boolean checkString(String s) {
        return !s.contains("ba");
    }

}