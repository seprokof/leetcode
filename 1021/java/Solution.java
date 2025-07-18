import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("(()())(())", "()()()"),
                new TestCase("(()())(())(()(()))", "()()()()(())"),
                new TestCase("()()", "")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.removeOuterParentheses(test.in);
            assert Objects.equals(test.expected, actual) : "removeOuterParentheses('%s') == '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int stack = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                if (stack++ > 0) {
                    sb.append(ch);
                }
            } else {
                if (--stack > 0) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }

}