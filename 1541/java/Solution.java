class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("(()))", 1),
                new TestCase("())", 0),
                new TestCase("))())(", 3)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.minInsertions(test.in);
            assert test.expected == actual : "minInsertions('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int minInsertions(String s) {
        char[] arr = s.toCharArray();
        int opened = 0;
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (arr[i] == '(') {
                opened++;
            } else {
                if (i < s.length() - 1 && arr[i + 1] == ')') {
                    i++;
                } else {
                    result++;
                }
                if (opened == 0) {
                    result++;
                } else {
                    opened--;
                }
            }
        }
        return result + opened * 2;
    }

}