class Solution {

	public static void main(String[] args) {
		// @formatter:off
        record TestCase(String in, int expected) {}

        TestCase[] tests = {
                new TestCase("42", 42),
                new TestCase(" -042", -42),
                new TestCase("1337c0d3", 1337),
                new TestCase("0-1", 0),
                new TestCase("words and 987", 0)
                };
         // @formatter:on
		Solution s = new Solution();

		for (TestCase test : tests) {
			int actual = s.myAtoi(test.in);
			assert test.expected == actual : "myAtoi('%s') == %s, want %s".formatted(test.in, actual, test.expected);
		}
	}

	public int myAtoi(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int i = 0;
		while (i < s.length() && s.charAt(i) == ' ') {
			i++;
		}
		int sign = 1;
		if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
			sign = s.charAt(i) == '-' ? -1 : 1;
			i++;
		}
		int result = 0;
		while (i < s.length() && Character.isDigit(s.charAt(i))) {
			int digit = s.charAt(i) - '0';
			if (result > (Integer.MAX_VALUE - digit) / 10) {
				return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
			}
			result = result * 10 + digit;
			i++;
		}
		return result * sign;
	}

}