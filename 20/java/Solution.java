import java.util.Stack;

class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(String in, boolean expected) {}

        TestCase[] tests = {
                new TestCase("()", true),
                new TestCase("()[]{}", true),
                new TestCase("(]", false),
                new TestCase("([])", true)
                };
         // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			boolean actual = s.isValid(test.in);
			assert test.expected == actual : "isValid('%s') == %s, want %s".formatted(test.in, actual, test.expected);
		}
	}

	public boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '[' || ch == '{') {
				stack.push(ch);
			} else if (stack.isEmpty()) {
				return false;
			} else if (ch == ')' && stack.pop() != '(') {
				return false;
			} else if (ch == ']' && stack.pop() != '[') {
				return false;
			} else if (ch == '}' && stack.pop() != '{') {
				return false;
			}
		}
		return stack.isEmpty();
	}

}