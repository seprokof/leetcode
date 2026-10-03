import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("(()", 2),
                new TestCase(")()())", 4),
                new TestCase("", 0),
                new TestCase("()(()", 2)
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            int actual = s.longestValidParentheses(test.in);
            assert test.expected == actual : "longestValidParentheses('%s') == %s, want %s".formatted(test.in, actual,
                    test.expected);
        }
    }

    public int longestValidParentheses(String s) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    max = Math.max(max, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }
        return max;
    }

}