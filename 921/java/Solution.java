class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("())", 1),
                new TestCase("(((", 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minAddToMakeValid(test.in);
            assert test.expected == actual : "minAddToMakeValid('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minAddToMakeValid(String s) {
        int open = 0;
        int additional = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else if (open > 0) {
                open--;
            } else {
                additional++;
            }
        }
        return open + additional;
    }

}