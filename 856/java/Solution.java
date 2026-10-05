class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("()", 1),
                new TestCase("(())", 2),
                new TestCase("()()", 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.scoreOfParentheses(test.in);
            assert test.expected == actual : "scoreOfParentheses('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int scoreOfParentheses(String s) {
        int depth = 0;
        int score = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    score += 1 << depth;
                }
            }
        }
        return score;
    }

}