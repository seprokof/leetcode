class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("abc", 148),
                new TestCase("zaza", 160)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.reverseDegree(test.in);
            assert test.expected == actual : "reverseDegree('%s') = %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int reverseDegree(String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += (i + 1) * (26 - (s.charAt(i) - 'a'));
        }
        return result;
    }

}