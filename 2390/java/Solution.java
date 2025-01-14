class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("leet**cod*e", "lecoe"),
                new TestCase("erase*****", "")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.removeStars(test.in);
            assert test.expected.equals(actual) : "removeStars('%s') == '%s', want '%s'".formatted(test.in, actual,
                    test.expected);
        }
    }

    public String removeStars(String s) {
        StringBuilder sb = new StringBuilder(s.length());
        for (char ch : s.toCharArray()) {
            if (ch != '*') {
                sb.append(ch);
            } else if (!sb.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

}