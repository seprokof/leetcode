class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("(1+(2*3)+((8)/4))+1", 3),
                new TestCase("(1)+((2))+(((3)))", 3),
                new TestCase("()(())((()()))", 3)
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.maxDepth(test.in);
            assert test.expected == actual : "maxDepth('%s') = %s, want %s".formatted(test.in, actual, test.expected);
        }
    }

    public int maxDepth(String s) {
        int depth = 0;
        int max = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                max = Math.max(max, ++depth);
            } else if (ch == ')') {
                depth--;
            }
        }
        return max;
    }

}