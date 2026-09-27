import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("(abcd)", "dcba"),
                new TestCase("(u(love)i)", "iloveu"),
                new TestCase("(ed(et(oc))el)", "leetcode")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.reverseParentheses(test.in);
            assert Objects.equals(test.expected, actual) : "reverseParentheses('%s') = '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String reverseParentheses(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        stack.push(new StringBuilder());
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(new StringBuilder());
            } else if (ch == ')') {
                StringBuilder sb = stack.pop().reverse();
                stack.peek().append(sb);
            } else {
                stack.peek().append(ch);
            }
        }
        return stack.peek().toString();
    }

}