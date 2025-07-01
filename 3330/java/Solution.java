class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("abbcccc", 5),
                new TestCase("abcd", 1),
                new TestCase("aaaa", 4)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.possibleStringCount(test.in);
            assert test.expected == actual : "possibleStringCount('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int possibleStringCount(String word) {
        int result = 1;
        for (int i = 1; i < word.length(); i++) {
            if (word.charAt(i) == word.charAt(i - 1)) {
                result++;
            }
        }
        return result;
    }

}