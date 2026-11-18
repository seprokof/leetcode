class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("1001", 2),
                new TestCase("10", 1),
                new TestCase("0000", 0)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minChanges(test.in);
            assert test.expected == actual : "minChanges('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minChanges(String s) {
        int result = 0;
        for (int i = 1; i < s.length(); i += 2) {
            if (s.charAt(i - 1) != s.charAt(i)) {
                result++;
            }
        }
        return result;
    }

}