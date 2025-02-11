import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in1, String in2, String expected) {}

        TestCase[] tests = {
                new TestCase("daabcbaabcbc", "abc", "dab"),
                new TestCase("axxxxyyyyb", "xy", "ab")
                };
        // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.removeOccurrences(test.in1, test.in2);
            assert Objects.equals(test.expected, actual) : "removeOccurrences('%s', '%s') == '%s', want '%s'"
                    .formatted(test.in1, test.in2, actual, test.expected);
        }
    }

    public String removeOccurrences(String s, String part) {
        StringBuilder sb = new StringBuilder(s);
        int startIdx = -1;
        while ((startIdx = sb.indexOf(part)) > -1) {
            sb.delete(startIdx, startIdx + part.length());
        }
        return sb.toString();
    }

}