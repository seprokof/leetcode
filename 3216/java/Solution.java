import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("45320", "43520"),
                new TestCase("001", "001")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.getSmallestString(test.in);
            assert Objects.equals(test.expected, actual) : "getSmallestString('%s') == '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String getSmallestString(String s) {
        StringBuilder sb = new StringBuilder(s);
        for (int i = 0; i < s.length() - 1; i++) {
            char current = s.charAt(i);
            char next = s.charAt(i + 1);
            if (next < current && next % 2 == current % 2) {
                sb.setCharAt(i, next);
                sb.setCharAt(i + 1, current);
                break;
            }
        }
        return sb.toString();
    }

}