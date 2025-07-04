import java.util.Objects;

class Solution {

    public static void main(String[] args) {
        // @formatter:off
        record TestCase(String in, String expected) {}

        TestCase[] tests = {
                new TestCase("abbaca", "ca"),
                new TestCase("azxxzy", "ay")
                };
         // @formatter:on
        Solution s = new Solution();

        for (TestCase test : tests) {
            String actual = s.removeDuplicates(test.in);
            assert Objects.equals(test.expected, actual) : "removeDuplicates('%s') == '%s', want '%s'"
                    .formatted(test.in, actual, test.expected);
        }
    }

    public String removeDuplicates(String s) {
        char[] result = new char[s.length()];
        int currentIdx = -1;
        for (char ch : s.toCharArray()) {
            if (currentIdx >= 0 && result[currentIdx] == ch) {
                currentIdx--;
            } else {
                result[++currentIdx] = ch;
            }
        }
        return new String(result, 0, currentIdx + 1);
    }

}